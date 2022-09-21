![rtgrhyt3hy](https://user-images.githubusercontent.com/93411167/190228970-882d493b-61ec-4d96-b9bd-75b41040988b.png)

<h1 align="center" id="topo">Olá, seja bem vindo(a) à API Hellobank</h1>
Esse projeto consiste em uma API para gerenciar as transações de um banco fictício utilizando Java, MySQL e AWS. Efetuamos a aplicação por meio de Spring Boot, usando Maven com CRUD e dividimos as funções em microserviços. Para o banco de dados utilizamos o MySql com deploy no Docker e pipeline em Jenkins.

<hr>


<h2 align="center" id="requisitos">Entregas Minímas</h2>
<h3 id="RQEntrega"> - Metodologias Ágeis</h3>

- [X] Kanban com todas as tarefas organizadas e responsáveis definidos.
<h3 id="RQEntrega"> - Back-end: </h3>

- [X] Cadastro de clientes;
- [X] Listagem de clientes;
- [X] Atualização de clientes;
- [X] Histórico de transações entre contas;
- [X] Deletar Clientes;

<h3 id="RQEntrega"> - Banco de Dados</h3>

- [X] Tabelas bem estruturadas e populadas com valores para testes.
- [X]  O Banco deve ser entregue em script SQL junto ao repositório.

<h3 id="RQEntrega"> - Geral </h3>

- [X] O código deve ser entregue em um repositório no Github.
- [X] A API deve ser disponibilizada em ambiente AWS com EC2 e em Beanstalk.
- [X] A aplicação deve ter um pipeline em Jenkins ou no Aws Build.
- [X] A aplicação precisa ser configurada no API Gateway da AWS.
- [X] A aplicação precisa ter no mínimo um endpoint de SNS para cadastro de
emails e verificação automática.
- [X] A aplicação precisa ter no mínimo um Lambda.
- [X] Liste os endpoints no README.md

<h3 id="RQEntrega"> - Entrega Opcional </h3>

- [ ] Testes automatizados, podem ser testes unitários ou testes de integração.


<h2 align="center" id="requisitos">Requisitos e Funcionalidades</h2>

- [X] Testes automatizados, podem ser testes unitários ou testes de integração;
- [X] A API deve ser disponibilizada em ambiente AWS com EC2 e em Beanstalk;
- [X] A aplicação deve ter um pipeline em Jenkins ou no Aws Build;
- [X] A aplicação precisa ser configurada no API Gateway da AWS;
- [X] A aplicação precisa ter no mínimo um endpoint de SNS para cadastro de emails e verificação automática;
- [X] A aplicação precisa ter no mínimo um Lambda;

<br/><hr>

<h2 id="endpoints">Endpoints</h2>
<p>
    API pode ser acessada por meio de URL que executa a função escolhida quando chamada. Sendo assim, cada endpoint listado abaixo, executa um determinado trecho de código.
</p>

<h4 align="center"> Endpoints - Cliente:</h4>

***[GET]*** Listar Clientes:
```
http://localhost:8090/cliente
```
##### Exemple Request
    curl --location --request GET 'http://localhost:8090/cliente' \
    --data-raw '{
        "tipoConta": "Poupança",
        "numeroConta": "123456789",
        "agencia": "1234",
        "saldo": 1500.00,
        "cliente":{
            "id": 9
        }

    }'
<br>

***[GET]*** Buscar ID Cliente:
```
http://localhost:8090/cliente/1
```
##### Exemple Request
    curl --location --request GET 'http://localhost:8090/cliente/1'

<br>

***[GET]*** Buscar CPF Cliente:
```
http://localhost:8090/cliente/cpf/081.484.010-80
```
##### Exemple Request
    curl --location --request GET 'http://localhost:8090/cliente/cpf/081.484.010-80'
<br>

***[POST]*** Cadastrar cliente:
```
http://localhost:8090/cliente/cadastrar
```
##### Exemple Request
    curl --location --request POST 'http://localhost:8090/cliente/cadastrar' \
    --data-raw '{
        "nome": "Gerson Ronaldo",
        "cpf": "951.947.570-26",
        "endereco": "Rua dos Santos",
        "cidade": "São Paulo",
        "estado": "SP",
        "email": "gerson123@email.com",
        "telefone": "(11) 9 9999-9999"

    }'
<br>

***[PUT]*** Atualizar Cliente:
```
http://localhost:8090/cliente/atualizar
```
##### Exemple Request
    curl --location --request PUT 'http://localhost:8090/cliente/atualizar' \
    --data-raw '{
       "id": 1,
            "nome": "Gerson Ronaldo",
            "cpf": "50839303076",
            "endereco": "Rua dos Santos",
            "cidade": "São Paulo",
            "estado": "SP",
            "email": "gerson348@email.com",
            "telefone": "(11) 9 9999-9999"
    }'
<br>

***[DEL]*** Deletar ID Cliente:
```
curl --location --request DELETE 'http://localhost:8090/cliente/4'
```
##### Exemple Request
    curl --location --request DELETE 'http://localhost:8090/cliente/9'
<h4 align="center"> Endpoints - Conta:</h4>
<br>

***[GET]*** Listar Contas:
```
http://localhost:8090/conta
```
##### Exemple Request
    curl --location --request GET 'http://localhost:8090/conta'
<br>

***[POST]*** Cadastrar Contas:
```
http://localhost:8090/conta/cadastrar
```
##### Exemple Request
    curl --location --request POST 'http://localhost:8090/conta/cadastrar' \
    --data-raw '{
        "tipoConta": "Poupança",
        "numeroConta": "123456789",
        "agencia": "4567",
        "saldo": 1500.00,
        "cliente":{
            "id": 2
        }

    }'
<br>

***[PUT]*** Transacao Deposito:
```
http://localhost:8090/conta/1234/deposito/1000
```
##### Exemple Request
    curl --location --request PUT 'http://localhost:8090/conta/1234/deposito/1000' \
    --data-raw ''

<h4 align="center"> Endpoints - Transação:</h4>
<br>
 
***[GET]*** Historico Transações:
```
http://localhost:8090/transacao
```
##### Exemple Request
    curl --location --request GET 'http://localhost:8090/transacao'
<br>

***[POST]*** Transferencia:
```
http://localhost:8090/transacao/transferencia
```
##### Exemple Request
    curl --location --request POST 'http://localhost:8090/transacao/transferencia' \
    --data-raw '{
        "valorTransacao": 200.00,
        "contaOrigem": "789123456",
        "contaDestino": "123456789"
    }'

<br>

***[POST]*** Saque:
```
http://localhost:8090/transacao/saque
```
##### Exemple Request
    curl --location --request POST 'http://localhost:8090/transacao/saque' \
    --data-raw '{
        "valorTransacao": 200.00,
        "contaOrigem": "789123456"
    }'

<br>

***[POST]*** Deposito:
```
http://localhost:8090/transacao/deposito
```
##### Exemple Request
    curl --location --request POST 'http://localhost:8090/transacao/deposito' \
    --data-raw '{
        "valorTransacao": 200.00,
        "contaDestino": "789123456"
    }'

<h2 id="ferramentas">Postman</h2>
<p>
    O Postman é uma ferramenta que dá suporte à documentação das requisições feitas pela API. Ele possui ambiente para a documentação, execução de testes de APIs e requisições em geral. 
    Disponibilizamos um <a href= "https://documenter.getpostman.com/view/14129628/VVHx2dei#f1f84850-2599-4a39-9204-71c104c546ca">LINK</a> onde estão disponíveis requisições para testar a aplicação.
</p>

<h2 id="ferramentas">Docker</h2>
<p>
    Docker é um conjunto de produtos de plataforma como serviço que usam virtualização de nível de sistema operacional para entregar software em pacotes chamados contêineres. Os contêineres são isolados uns dos outros e agrupam seus próprios softwares, bibliotecas e arquivos de configuração.
</p>

<h2 id="ferramentas">Jenkins</h2>
<p>
    Jenkins é um servidor de automação de código aberto. Ele ajuda a automatizar as partes do desenvolvimento de software relacionadas à construção, teste e implantação, facilitando a integração e a entrega contínuas. É um sistema baseado em servidor que é executado em contêineres de servlet, como o Apache Tomcat.
</p>
<h2 id="ferramentas">SpringBoot</h2>
<p>
    O Spring Boot é um framework Java open source que tem como objetivo facilitar esse processo em aplicações Java. Consequentemente, ele traz mais agilidade para o processo de desenvolvimento, uma vez que devs conseguem reduzir o tempo gasto com as configurações iniciais.  
</p>
<h2 id="ferramentas">Java</h2>
<p>
    Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.  
</p>
<h2 id="ferramentas">MySQL</h2>
<p>
    O MySQL é um sistema de gerenciamento de banco de dados, que utiliza a linguagem SQL como interface. É atualmente um dos sistemas de gerenciamento de bancos de dados mais populares da Oracle Corporation, com mais de 10 milhões de instalações pelo mundo.  
</p>
<h2 id="ferramentas">AWS - Lambda</h2>
<p>
    AWS Lambda é um programa orientado a eventos, em computação sem servidor fornecido pela Amazon como uma parte da Amazon Web Services. É um serviço de computação que executa código em resposta a eventos e gerência automaticamente os recursos de computação exigidos por esse código. Foi anunciado em novembro de 2014.  
</p>
<p align="right"><a href="#topo">Você pode voltar ao topo clicando aqui ↑</a></p>
<h3 id="tecnologias">Ferramentas e tecnologias utilizadas</h3>
<div id="tecnologias" style="display: inline_block" align="center"><br>
    <a href="https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html">
        <img align="center" alt="Java" title="Java 18" height="80px" width="90px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-plain.svg"/>
    </a>
    <a href="https://spring.io/tools#suite-three">
        <img align="center" alt="Spring-Boot-Tools" title="Spring Boot Tools" height="80px" width="90px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"/>
    </a>
    <a href="https://www.mysql.com/">
        <img align="center" alt="MySql" title="MySql" height="80px" width="90" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg"/>
    </a>
   <a href="https://aws.amazon.com/pt/lambda/">
        <img align="center" alt="AWS - Lambda" title="AWS - Lambda" height="80px" width="80px" src="https://upload.wikimedia.org/wikipedia/commons/e/e9/Amazon_Lambda_architecture_logo.png"/>
    </a>
    <a href="https://www.docker.com/get-started">
    <img align="center" alt="Docker" title="Docker" height="90px" width="100px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg"/> 
    </a>
    <a href="https://www.jenkins.io/download/">
        <img align="center" alt="Jenkins" title="Jenkins" height="80px" width="90px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg"/>
    <a href="https://www.postman.com/downloads/">
        <img align="center" alt="Postman" title="Postman" height="80px" width="90px" src="https://user-images.githubusercontent.com/2676579/34940598-17cc20f0-f9be-11e7-8c6d-f0190d502d64.png"/>
    <a href="https://git-scm.com/">
        <img align="center" alt="Git" title="Git" height="80px" width="90px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg"/>
    </a>
</div>

<h3 id="agradecimentos">Agradecimentos</h3>
Agradecemos ao IBM e toda a equipe e suporte da Gama Academy pela iniciativa do projeto if (black) { code( ) }, que possibilitou uma nova jornada de conhecimento a todos os selecionados. A todos os mentores que dedicaram um pouco do seu tempo compartilhando conhecimentos e experiências conosco. Aos nossos colegas de classe. E por último, aos membros da nossa Squad, sem nenhum de nós, esse projeto não seria possível.

<h3 id="squad">Nós somos a Squad MEIDIA...</h3>
Você pode ver mais acerca do nosso desenvolvimento através dos repositórios contidos no GitHub e nos contatar pelo linkedin. Agradecemos desde já o tempo que você dedicou a leitura deste arquivo.😄
<br><br>
	
<a href="https://storyset.com/work">
   <img src="https://lh3.googleusercontent.com/8KFjBDCqD1-Ss8vhhPpX63YOFWHIVHs48-UcbdkXqVWimQmwYKR7jOG0mLvATg-ZVDGmygXOkLY7VY2SRc0IgscGzmxTdvohVCRZKFQwYJVSOWnM8WFH8tsRIbYNXF71ixNMc3PNdxXFpALUIr8i4AcqzNtYbaI-KzEXnjuVWrwC19vDUzrrVAS8qnYLs_9SusIj8BYMD8tK50RnaGsHG826-CaksfY8XDxiTjxCLLV_mDyP0FWHpO536IysOqwSS70foSFuudQsrHJnyVRAOWvtWd4N5Lun9rsrR7m9PSVER5gvZZKwIDlZvuVQi4cqs-lTY1pF2B0XAfRrhHYqDdrCnMt0AXKKX7z6QbQx4YpvtGXXbumKKgbM_Wd3THPQSEu5InRLCFu_YfL1uJDKXfnotB_s9AESniW3w8vvVyykXkA2HD1H6_FezA2EE3svWF_c4BXSKhnqZ3eh-Yt_8kLGFoWUjhu_lCpBS4ObK_y1hEV-EgMKzk6jB3__y2Pg_tUxop6-5ja98ibvhxR6R3nIAykMn1t7dsTnIzLJUvw9qIT-CM-8mQvAGV5UEckTRcXbTgG0N6SfxNxOQBJiNRSv3Q2rDoYb2fPyBEjTukRav7frUS6BUJcbIussb2WIe0A83nFKHQKh3GXkla-N2AD1AHBZa26JZROLq9hXpr_a7dOw_PT3TTYS5FuIiuMgImg07VPigf_yRzYsWImoreelkJTijOfh3Vg38stu4t_HqQkO2MBdJiRy1R8PPJJUMgdSBgRcQaNAJBNfK_w1cvizT674LdQBKUYfA-sirG6cL2F1aqSFU1QxWaAXYB6kNHn7xrvt1l7UwYppmL24s_yELCGypdpqeHDTmnuWNHX3izb38xhBUwp0Qrg_hfUxB9J4OivJyFrcsvWLM9pd3eLA5sxT8GOPknsFf45iQw=s872-no?authuser=0" min-width="350px" max-width="350px" width="350px" align="right"  alt="Work illustrations by Storyset">
</a>
<table width="40%">
    <tr>
        <td>
            <img src="https://media-exp1.licdn.com/dms/image/C4D03AQG9Vs-R_onpYQ/profile-displayphoto-shrink_800_800/0/1637952264056?e=1668643200&v=beta&t=0zR500-9XV2HSqqpl7Y4fIWsi4Tv5Rtq7S3V_muM82E" alt="Foto Alexandre" height="70px" style="border-radius:10px">
        </td>
        <td align="center">
            <a href="https://github.com/alexandreps1123">
                <img src="https://img.shields.io/badge/%20Alexandre%20%20%20%20%20%20%20%20%20Ferreira%20-10?style=social&logo=github&logoColor=006A8A" width="150px;" alt="GitHub" />
            </a>
        </td>
        <td align="center">
            <a href="https://www.linkedin.com/in/alexandreps1123/" target="_blank" alt="Linkedin">
                <img src="https://img.shields.io/badge/%20Alexandre%20%20%20%20%20%20%20%20%20Ferreira%20-0077B5?style=social&logo=linkedin&logoColor=00C6FF&" width="150px;" alt="Linkedin" />
            </a>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://media-exp1.licdn.com/dms/image/C4D03AQGe7HUqViF2tQ/profile-displayphoto-shrink_800_800/0/1636035943602?e=1668643200&v=beta&t=PSK2nweWJIReCjNG0JwWIhemahcdHao2-9JIZq5i1-w" alt="Foto Euritales" height="70px" style="border-radius:10px">
        </td>
        <td align="center">
            <a href="https://github.com/euritales">
                <img src="https://img.shields.io/badge/%20Euritales(Tales)%20%20%20%20%20%20%20%20%20Silva%20-10?style=social&logo=github&logoColor=006A8A" width="150px;" alt="GitHub" />
            </a>
        </td>
        <td align="center">
            <a href="https://www.linkedin.com/in/euritales/" target="_blank" alt="Linkedin">
                <img src="https://img.shields.io/badge/%20Euritales(Tales)%20%20%20%20%20%20%20%20%20Silva%20-0077B5?style=social&logo=linkedin&logoColor=00C6FF&" width="150px;" alt="Linkedin" />
            </a>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://media-exp1.licdn.com/dms/image/D4E35AQFswrCcE3nfkg/profile-framedphoto-shrink_800_800/0/1641248734714?e=1664046000&v=beta&t=0k9xbfqlzigVhtdPAO6wam8rc8Mt3aiVUhrcGgAtXG8" alt="Foto Gerson" height="70px" style="border-radius:10px">
        </td>
        <td align="center">
            <a href="https://github.com/GersonRYE">
                <img src="https://img.shields.io/badge/Gerson%20Ronaldo-10?style=social&logo=github&logoColor=006A8A" width="150px;" alt="GitHub" />
            </a>
        </td>
        <td align="center">
            <a href="https://www.linkedin.com/in/gerson-ronaldo-011282220/" target="_blank" alt="Linkedin">
                <img src="https://img.shields.io/badge/Gerson%20Ronaldo-0077B5?style=social&logo=linkedin&logoColor=00C6FF" width="150px;" alt="Linkedin" />
            </a>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://avatars.githubusercontent.com/u/68935244?s=400&u=60e3df703d368ccfafb34e5bbce49fc5807c89f4&v=4" alt="Foto Laryssa Peçanha" height="70px" style="border-radius:10px text-align: center;">
        </td>
        <td align="center">
            <a href="https://github.com/laryscampark">
                <img src="https://img.shields.io/badge/Laryssa%20%20%20%20Peçanha-10?style=social&logo=github&logoColor=006A8A" width="150px;" alt="GitHub" />
            </a>
        </td>
        <td align="center">
            <a href="https://www.linkedin.com/in/laryssape%C3%A7anha/" target="_blank" alt="Linkedin">
                <img src="https://img.shields.io/badge/Laryssa%20%20%20%20%20Peçanha-0077B5?style=social&logo=linkedin&logoColor=00C6FF" width="150px;" alt="Linkedin" />
            </a>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://media-exp1.licdn.com/dms/image/C5603AQENlBdCKpmINw/profile-displayphoto-shrink_800_800/0/1606437368461?e=1668643200&v=beta&t=K7aVKgHLHs3fbXmIy6xAeExxHywR0z8w5oWnw07vevU" alt="Foto Wegelys Ferreira Alves" height="70px" style="border-radius:10px">
        </td>
        <td align="center">
            <a href="https://github.com/Wegelys">
                <img src="https://img.shields.io/badge/Wegelys%20%20%20%20Ferreira Alves-10?style=social&logo=github&logoColor=006A8A" width="150px;" alt="GitHub" />
            </a>
        </td>
        <td align="center">
            <a href="https://www.linkedin.com/in/wegelys-ferreira-alves-8a3b10200/" target="_blank" alt="Linkedin">
                <img src="https://img.shields.io/badge/Wegelys%20%20%20%20%20Ferreira Alves-0077B5?style=social&logo=linkedin&logoColor=00C6FF" width="150px;" alt="Linkedin" />
            </a>
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://media-exp1.licdn.com/dms/image/D4E03AQEl1PalWThpYg/profile-displayphoto-shrink_800_800/0/1642071666024?e=1668643200&v=beta&t=6IqZnZdJUs-0CwyNAfDf_yiCZyZk8DfJbaVoGh13CL0" alt="Foto Wendel" height="70px" style="border-radius:10px">
        </td>
        <td align="center">
            <a href="https://github.com/dantaswendel">
                <img src="https://img.shields.io/badge/%20Wendel%20%20%20%20%20Dantas%20%20-10?style=social&logo=github&logoColor=006A8A" width="150px;" alt="GitHub" />
            </a>
        </td>
        <td align="center">
            <a href="https://www.linkedin.com/in/wendel-dantas-lima-5104b0166/" target="_blank" alt="Linkedin">
                <img src="https://img.shields.io/badge/%20Wendel%20%20%20%20%20%20Dantas%20%20-0077B5?style=social&logo=linkedin&logoColor=00C6FF" width="150px;" alt="Linkedin" />
            </a>
        </td>
</table>
<p align="right"><a href="#topo">Você pode voltar ao topo clicando aqui ↑</a></p>
