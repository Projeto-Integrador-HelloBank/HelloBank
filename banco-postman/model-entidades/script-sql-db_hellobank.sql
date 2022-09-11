create table tb_cliente(
id int auto_increment,
nome varchar(100) not null,
cpf varchar(20) not null,
endereco varchar(50) not null,
cidade varchar(50) not null, 
estado varchar(50) not null, 
email varchar(60) not null,
telefone varchar(18) not null,
primary key(id));


create table tb_conta(
codigo int auto_increment primary key,
tipo_conta varchar(20) not null,
numero_conta varchar(45) not null,
agencia varchar(45) not null,
saldo double not null,
data_criacao date,
cliente_id int not null,

foreign key(cliente_id) references tb_cliente(id)
);

create table tb_transacao(
codigo int auto_increment primary key,
tipo_transacao varchar(45) not null,
data_transacao date,
valor_transacao double not null,
conta_origem int not null,
conta_destino int not null,

foreign key(conta_origem) references tb_conta(codigo),
foreign key(conta_destino) references tb_conta(codigo)
);

insert into tb_cliente(nome, cpf_cnpj) values ("Ronaldo Alves", "132.546.789-15"), ("Acervo de Condes", "156.489.785-15"), ("Dantas Vieiras", "456.845.897-42");
insert into tb_conta(numero_conta, agencia, saldo, data_criacao, cliente_id) values ("123456", "1234", 1500.00, "09-15-2022", 1), ("145678", "4567", 2000.00, "09-15-2022", 2),
("789452", "4869", 1200.00, "09-15-2022", 3);