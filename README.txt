Passos para configuração da máquina AWS

Conectar a máquina
$ ssh ubuntu@<ip_publico> -o ServerAliveInterval=60
-------------
$ sudo apt update

---nginx
$ sudo apt install nginx

---java 17
$ sudo apt install openjdk-17-jdk openjdk-17-jre

---maven
$ TMP_MAVEN_VERSION=3.8.6
$ wget https://apache.org/dist/maven/maven-3/$TMP_MAVEN_VERSION/binaries/apache-maven-$TMP_MAVEN_VERSION-bin.tar.gz -P /tmp

$ sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt
$ sudo rm /tmp/apache-maven-*-bin.tar.gz

$ sudo ln -s /opt/apache-maven-$TMP_MAVEN_VERSION /opt/maven

$ sudo nano /etc/profile.d/maven.sh

    export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
    export M2_HOME=/opt/maven
    export MAVEN_HOME=/opt/maven
    export PATH=${M2_HOME}/bin:${PATH}

$ sudo chmod +x /etc/profile.d/maven.sh
$ source /etc/profile.d/maven.sh

$ mvn -v

---Jenkins
$ wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
$ sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
$ sudo apt update
$ sudo apt install jenkins

$ chown root:jenkins /var/run/docker.sock

local projeto
$ cd /var/lib/jenkins/workspace/hello-bank


    login: hellobank
    senha: root
    url: http://<ip_publico>:8080/

    ferramenta de configuração global
        Nome: Apache Maven 3.6.3
        MAVEN_HOME: /opt/maven

---docker
$ sudo apt install docker.io

---mysql
$ sudo apt install mysql-server

$ sudo mysql

mysql> CREATE USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'mysql';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
mysql> FLUSH PRIVILEGES;

$ sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
bind-address        = 0.0.0.0
mysqlx-bind-address = 0.0.0.0

$ sudo systemctl restart mysql

acesso pelo private IP da máquina
$ mysql -uroot -p'mysql' -h <ip_privado>

node {
    def mvnHome
    stage('Preparation') {
        // Get the Maven tool.
        mvnHome = tool 'Apache Maven 3.6.3'
    }
    stage('git-clone') {
        git url: "https://github.com/Projeto-Integrador-HelloBank/HelloBank.git", branch: "main"
    }
    stage('clean') {
        withEnv(["MVN_HOME=$mvnHome"]) {
            sh '"$MVN_HOME/bin/mvn" clean'
        }
    }
    stage('build') {
        withEnv(["MVN_HOME=$mvnHome"]) {
            sh '"$MVN_HOME/bin/mvn" package -Dmaven.test.skip'
        }
    }
    stage('test') {
        withEnv(["MVN_HOME=$mvnHome"]) {
            sh '"$MVN_HOME/bin/mvn" test'
        }
    }
    stage('prepare-Dockerfile') {
        sh "echo 'FROM openjdk:17-jdk-alpine' > Dockerfile"
        sh "echo 'COPY target/*.jar app.jar' >> Dockerfile"
        sh "echo 'ENTRYPOINT [\"java\",\"-jar\",\"app.jar\"]' >> Dockerfile"
    }
    stage('build-docker') {
        sh 'docker build -t hello-bank .'
    }
    stage('remove-container') {
        sh "docker rm hello-bank --force" 
    }
    stage('deploy') {
        sh "docker run --net=host --env USER=root --env PASSWORD=mysql --env HOST=<ip_privado> --env DATABASE=db_hellobank -p 8090:3000 --name hello-bank hello-bank"
    }
}

--- config nginx
$ vim /etc/nginx/sites-avaliable/default

server {
    listen 80 default_server;
    listen [::]80 default_server;
    location / {
        proxy_pass http://localhost:8090;
    }
}
