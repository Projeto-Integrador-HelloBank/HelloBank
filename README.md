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
