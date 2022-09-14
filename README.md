![rtgrhyt3hy](https://user-images.githubusercontent.com/93411167/190228970-882d493b-61ec-4d96-b9bd-75b41040988b.png)

<h1 align="center" id="topo">Olá, seja bem vindo(a) à API Hellobank</h1>
Esse projeto consiste em uma API para gerenciar as transações de um banco fictício utilizando Java, MySQL e AWS. Efetuamos a aplicação por meio de Spring Boot, usando Maven com CRUD e dividimos as funções em microserviços. Para o banco de dados utilizamos o MySql com deploy no Docker e pipeline em Jenkins.

<h3 id="RQEntrega">Requisitos de Entrega</h3>

- [X] Metodologias Ágeis:
- [X] Kanban com todas as tarefas organizadas e responsáveis definidos.
- [X] Back-end:
       <br> -Cadastro de clientes
        <br> -Listagem de clientes
        <br> -Atualização de clientes
       <br> -Deletar clientes
         <br> -Histórico de transações entre contas
- [X] Banco de Dados:
         <br> -Tabelas bem estruturadas e populadas com valores para testes.
         <br>-O Banco deve ser entregue em script SQL junto ao repositório.
- [X] Gerais:
         <br>-O código deve ser entregue em um repositório no Github.
- [X]Liste os endpoints no README.md
 
<h3 id="RQEntrega">Opcionais</h3>

- [X] Testes automatizados, podem ser testes unitários ou testes de integração.
- [X] A API deve ser disponibilizada em ambiente AWS com EC2 e em Beanstalk .
- [X] A aplicação deve ter um pipeline em Jenkins ou no Aws Build.
- [X] A aplicação precisa ser configurada no API Gateway da AWS.
- [X] A aplicação precisa ter no mínimo um endpoint de SNS para cadastro de emails e verificação automática.
- [X] A aplicação precisa ter no mínimo um Lambda.
<br/><hr>
<h2 id="endpoints">Endpoints</h2>
<p>
API pode ser acessada por meio de URL que executa a função escolhida quando chamada. Sendo assim, cada endpoint listado abaixo, executa um determinado trecho de código.
</p>
<h4 align="center"> Endpoints - Cliente:</h4>
***[GET]*** Listar Clientes:
```
http://localhost:8080/cliente
```
##### Exemple Request
curl --location --request GET 'http://localhost:8080/cliente' \
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
