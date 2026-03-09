CREATE DATABASE projeto;
USE projeto;

CREATE TABLE fornecedor(
idFornecedor INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
CNPJ CHAR(14),
produto VARCHAR(50),
estoque VARCHAR(50)
);
CREATE TABLE empresa(
idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
CNPJ CHAR(14),
estoque VARCHAR(50)
);

CREATE TABLE lote(
idLote INT PRIMARY KEY AUTO_INCREMENT,
tipo VARCHAR(30),
retirada DATE,
entrega DATE,
qtdLote INT
);

CREATE TABLE sensor (
idSensor INT PRIMARY KEY auto_increment,
tipo VARCHAR(30),
TempAtual DECIMAL
);

CREATE TABLE transporte(
idTransporte INT PRIMARY KEY AUTO_INCREMENT,
tempoRota DATETIME,
qtdSuporta INT,
cdRetirada VARCHAR(40),
cdEntrega VARCHAR(40)
);