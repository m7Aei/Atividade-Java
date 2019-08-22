-- Criando a database
create database locadora;
use locadora;

-- Criando a tabela e as colunas
create table if not exists `carros` (
  id int auto_increment primary key,
  marca varchar(255) not null,
  modelo varchar(255) not null,
  ano int not null,
  cor varchar(255) not null,
  motorização double not null,
  quilometragem double not null,
  valorVeículo double not null,
  qtdPortas int not null,
  donoAtual varchar(255) not null,
  placa varchar(7) not null unique
) Engine = InnoDB;