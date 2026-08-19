-- Exercício 1
CREATE DATABASE ex1;

USE ex1;

CREATE TABLE pessoa (
	idpessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    cpf CHAR(11)
);

CREATE TABLE Reserva (
	idReserva INT PRIMARY KEY AUTO_INCREMENT,
    dtReserva DATETIME,
    dtRetirada DATETIME,
    dtDevolucao DATETIME,
    fkPessoa INT,
    CONSTRAINT fkPessoa FOREIGN KEY (fkPessoa) REFERENCES pessoa(idpessoa)
);


INSERT INTO pessoa (nome, cpf) VALUES
('João Silva', '12345678901'),
('Maria Oliveira', '98765432100'),
('Carlos Souza', '45612378910'),
('Ana Pereira', '32165498700'),
('Lucas Almeida', '74185296300');

INSERT INTO Reserva (dtReserva, dtRetirada, dtDevolucao, fkPessoa) VALUES
('2026-03-10 09:00:00', '2026-03-11 10:00:00', '2026-03-15 18:00:00', 1),
('2026-03-11 14:30:00', '2026-03-12 08:00:00', '2026-03-14 17:00:00', 2),
('2026-03-12 16:00:00', '2026-03-13 09:30:00', '2026-03-16 19:00:00', 3),
('2026-03-14 15:20:00', '2026-03-16 08:30:00', '2026-03-19 17:00:00', 1),
('2026-03-15 10:10:00', '2026-03-16 10:00:00', '2026-03-21 18:30:00', 2);

SELECT
	nome,
    cpf,
    Reserva.dtReserva,
    Reserva.dtRetirada
FROM 
	pessoa
JOIN
	Reserva ON pessoa.idpessoa = Reserva.fkPessoa;
    
SELECT
	nome AS Nome,
    cpf AS CPF,
    Reserva.dtReserva AS Data_Reserva,
    Reserva.dtRetirada AS Data_Retirada
FROM 
	pessoa
JOIN
	Reserva ON pessoa.idpessoa = Reserva.fkPessoa;

SELECT
	nome AS Nome,
    cpf AS CPF,
    Reserva.dtRetirada,
    Reserva.dtDevolucao,
	CASE
		WHEN NOW() < Reserva.dtRetirada THEN 'Reservado'
        WHEN NOW() BETWEEN Reserva.dtRetirada AND Reserva.dtDevolucao THEN 'Em Uso'
        WHEN NOW() > Reserva.dtDevolucao THEN 'Finalizado'
	END AS StatusReserva
FROM pessoa
JOIN Reserva ON pessoa.idpessoa = Reserva.fkPessoa;

SELECT
	nome AS Nome,
    cpf AS CPF,
    Reserva.dtRetirada,
    Reserva.dtDevolucao,
	CASE
		WHEN NOW() < Reserva.dtRetirada THEN 'Reservado'
        WHEN NOW() BETWEEN Reserva.dtRetirada AND Reserva.dtDevolucao THEN 'Em Uso'
        WHEN NOW() > Reserva.dtDevolucao THEN 'Finalizado'
	END AS StatusReserva
FROM pessoa
JOIN Reserva ON pessoa.idpessoa = Reserva.fkPessoa;

SELECT
    nome AS nome,
    cpf AS CPF,
    dtRetirada AS Retirada,
    IFNULL(dtDevolucao, 'Ainda não devolvido') AS Devolucao
FROM pessoa
JOIN Reserva ON pessoa.idpessoa = Reserva.fkPessoa;

-- Exercício 2
CREATE DATABASE ex2;

USE ex2;

CREATE TABLE Pessoa1(
	idPessoa1 INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    dtNascimento DATE
);

CREATE TABLE Pessoa2(
	idPessoa2 INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    dtNascimento DATE,
    fkPessoa1 INT,
    CONSTRAINT fkPessoa1 FOREIGN KEY (fkPessoa1) REFERENCES Pessoa1(idPessoa1)
);

INSERT INTO Pessoa1 (nome, dtNascimento) VALUES
('Carlos Silva', '1985-03-12'),
('Ana Souza', '1990-07-25'),
('Marcos Oliveira', '1978-11-03'),
('Juliana Pereira', '1995-05-19'),
('Roberto Almeida', '1982-09-30');

INSERT INTO Pessoa2 (nome, dtNascimento, fkPessoa1) VALUES
('Lucas Silva', '2010-04-15', 1),
('Fernanda Souza', '2012-08-20', 2),
('Pedro Oliveira', '2008-01-10', 3),
('Camila Pereira', '2015-06-05', 4),
('Gabriel Almeida', '2011-12-22', 5);

SELECT 
    Pessoa1.nome AS Nome_Pessoa1,
    Pessoa2.nome AS Nome_Pessoa2,
    Pessoa2.dtNascimento AS Nascimento
FROM Pessoa1
JOIN Pessoa2 ON Pessoa1.idPessoa1 = Pessoa2.fkPessoa1;

SELECT
    nome,
    dtNascimento,
    CASE
        WHEN YEAR(CURDATE()) - YEAR(dtNascimento) >= 18 THEN 'Mais velho'
        ELSE 'Mais novo'
    END AS Classificacao
FROM Pessoa2;

SELECT
    nome,
    IFNULL(fkPessoa1, 'Sem responsável') AS Responsavel
FROM Pessoa2;

-- Exercício 3
CREATE DATABASE ex3;

USE ex3;

CREATE TABLE Candidato (
    idCandidato INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cpf CHAR(11),
    dtNascimento DATE
);

CREATE TABLE Habilitacao (
    idHabilitacao INT PRIMARY KEY AUTO_INCREMENT,
    categoria VARCHAR(3),
    dtEmissao DATE,
    dtValidade DATE,
    fkCandidato INT UNIQUE,
    CONSTRAINT ckCategoria 
		CHECK (categoria IN ('A', 'B', 'AB', 'ACC')),
    CONSTRAINT fkCandidatoHabilitacao
        FOREIGN KEY (fkCandidato) REFERENCES Candidato(idCandidato)
);

INSERT INTO Candidato (nome, cpf, dtNascimento) VALUES
('Lucas Martins', '12345678901', '2005-04-10'),
('Ana Souza', '23456789012', '2004-09-21'),
('Carlos Lima', '34567890123', '2003-01-15'),
('Fernanda Alves', '45678901234', '2006-07-30'),
('Bruno Rocha', '56789012345', '2002-11-08');

INSERT INTO Habilitacao (categoria, dtEmissao, dtValidade, fkCandidato) VALUES
('B', '2026-03-13', '2027-03-13', 1),
('A', '2026-03-13', '2027-03-13', 2),
('AB', '2026-03-13', '2027-03-13', 3),
('ACC', '2026-03-13', '2027-03-13', 4),
('B', '2026-03-13', '2027-03-13', 5);

SELECT * 
FROM Candidato
JOIN Habilitacao
ON Candidato.idCandidato = Habilitacao.fkCandidato;

SELECT
    Candidato.nome AS Nome,
    Habilitacao.categoria AS Categoria,
    Habilitacao.dtValidade AS Validade
FROM Candidato
JOIN Habilitacao
ON Candidato.idCandidato = Habilitacao.fkCandidato;

SELECT
    Candidato.nome,
    Habilitacao.categoria,
    CASE
        WHEN CURDATE() <= Habilitacao.dtValidade THEN 'Válida'
        ELSE 'Vencida'
    END AS StatusCNH
FROM Candidato
JOIN Habilitacao
ON Candidato.idCandidato = Habilitacao.fkCandidato;

SELECT
    nome,
    IFNULL(dtValidade, 'Validade não registrada') AS Validade
FROM Habilitacao
JOIN Candidato
ON Candidato.idCandidato = Habilitacao.fkCandidato;

-- Exercício 4
CREATE DATABASE ex4;

USE ex4;

CREATE TABLE Farmacia (
	idFarmacia INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cnpj CHAR(14),
    telefone VARCHAR(15)
);

CREATE TABLE Endereco (
	idEndereco INT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    cep CHAR(8),
    fkFarmacia INT UNIQUE,
    CONSTRAINT fkFarmaciaEndereco
		FOREIGN KEY (fkFarmacia) REFERENCES Farmacia(idFarmacia)
);

CREATE TABLE Farmaceutico (
	idFarmaceutico INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    crf VARCHAR(20),
    turno VARCHAR(20),
    fkFarmacia INT,
    CONSTRAINT fkFarmaciaFarmaceutico
		FOREIGN KEY (fkFarmacia) REFERENCES Farmacia(idFarmacia)
);

INSERT INTO Farmacia (nome, cnpj, telefone) VALUES
('Drogaria Vida', '12345678000101', '11987654321'),
('Farmacia Sao Lucas', '22345678000102', '11976543210'),
('Drogaria Central', '32345678000103', '11965432109'),
('Farmacia Popular', '42345678000104', '11954321098'),
('Drogaria Bem Estar', '52345678000105', '11943210987');

INSERT INTO Endereco (logradouro, numero, bairro, cidade, cep, fkFarmacia) VALUES
('Rua das Flores', '120', 'Centro', 'São Paulo', '01001000', 1),
('Av Paulista', '850', 'Bela Vista', 'São Paulo', '01311000', 2),
('Rua da Paz', '45', 'Mooca', 'São Paulo', '03123000', 3),
('Rua Verde', '300', 'Vila Mariana', 'São Paulo', '04115000', 4),
('Av Brasil', '1500', 'Jardins', 'São Paulo', '01430000', 5);

INSERT INTO Farmaceutico (nome, crf, turno, fkFarmacia) VALUES
('Ana Souza', 'CRF12345', 'Manhã', 1),
('Carlos Lima', 'CRF23456', 'Tarde', 1),
('Fernanda Rocha', 'CRF34567', 'Noite', 2),
('Bruno Alves', 'CRF45678', NULL, 3),
('Juliana Costa', 'CRF56789', 'Manhã', 4);

SELECT *
FROM Farmacia
JOIN Endereco ON Farmacia.idFarmacia = Endereco.fkFarmacia
JOIN Farmaceutico ON Farmacia.idFarmacia = Farmaceutico.fkFarmacia;

SELECT
	Farmacia.nome AS NomeFarmacia,
    Farmacia.cnpj AS CNPJ,
    Endereco.logradouro AS Rua,
    Endereco.numero AS Numero,
    Farmaceutico.nome AS NomeFarmaceutico
FROM Farmacia
JOIN Endereco ON Farmacia.idFarmacia = Endereco.fkFarmacia
JOIN Farmaceutico ON Farmacia.idFarmacia = Farmaceutico.fkFarmacia;

SELECT
	Farmaceutico.nome,
    Farmaceutico.turno,
    CASE
		WHEN Farmaceutico.turno = 'Manhã' THEN 'Turno matinal'
        WHEN Farmaceutico.turno = 'Tarde' THEN 'Turno vespertino'
        WHEN Farmaceutico.turno = 'Noite' THEN 'Turno noturno'
        ELSE 'Turno não informado'
	END AS SituacaoTurno
FROM Farmaceutico;

SELECT
	nome,
    crf,
    IFNULL(turno, 'Sem turno cadastrado') AS Turno
FROM Farmaceutico;