-- Praticar - Sprint2
Create database ex1;
use ex1;
create table pessoa(
idPessoa int primary key auto_increment,
nome varchar(45),
cpf char(11)
);
insert into pessoa (nome,cpf) values
('Ana Beatriz ', '12345678900'),
('Marcos Oliveira ', '23456789011'),
('Julia Lima', '34567890122'),
('Ricardo Costa', '45678901233'),
('Fernando Dos Santos', '56789012344');

create table reserva (
idReserva int primary key auto_increment,
dtReserva datetime,
dtRetirada datetime,
dtDevolucao datetime,
fkPessoa int,
constraint fkPessoa foreign key (fkPessoa) references pessoa(idpessoa));

insert into reserva (dtReserva, dtRetirada, dtDevolucao, fkPessoa) values
('2026-03-17', '2026-03-18', '2026-03-20', 1),
('2026-03-17', '2026-03-19', '2026-03-22', 2),
('2026-03-18', '2026-03-20', '2026-03-25', 3),
('2026-03-19', '2026-03-21', '2026-03-24', 4),
('2026-03-20', '2026-03-22', '2026-03-26', 5);

select 
nome,
cpf,
reserva.dtReserva,
reserva.dtRetirada
from
pessoa
join
reserva on pessoa.idpessoa = reserva.fkPessoa;

select
nome as Nome,
cpf as CPF,
reserva.dtReserva as Data_Reserva,
reserva.dtRetirada as Data_Retirada
from 
pessoa
join
reserva on pessoa.idpessoa = reserva.fkPessoa;

select 
nome as Nome,
cpf as CPF,
reserva.dtReserva as Data_Reserva,
reserva.dtRetirada as Data_Retirada
from
pessoa
join
reserva on pessoa.idpessoa = reserva.fkPessoa;

select
nome as Nome,
cpf as CPF,
reserva.dtReserva as Data_Reserva,
reserva.dtRetirada as Data_Retirada
from
pessoa
join
reserva on pessoa.idpessoa = reserva.fkPessoa;

select
nome as Nome,
cpf as CPF,
reserva.dtRetirada,
reserva.dtDevolucao,
case 
when now() <reserva.dtRetirada then 'Reservado'
when now() between reserva.dtRetirada and reserva.dtDevolucao then 'Em uso'
when now() >reserva.dtDevolucao then 'Finalizado'
end as StatusReserva
from pessoa
join reserva on pessoa.idpessoa = reserva.fkpessoa;

select 
nome as Nome,
cpf as CPF,
reserva.dtRetirada,
reserva.dtDevolucao,
case
when now()<reserva.dtRetirada then 'Reservado'
when now() between reserva.dtRetirada and reserva.dtDevolucao then 'Em uso'
when now() > reserva.dtDevolucao then 'Finalizado'
end as StatusReserva
from pessoa
join reserva on pessoa.idpessoa = reserva.fkPessoa;

select 
nome as Nome,
cpf as CPF,
dtRetirada as Retirada,
ifnull(dtDevolucao,'Ainda não devolvido') as Devolucao
from pessoa
join reserva on pessoa.idpessoa = reserva.fkPessoa;

-- Exercício 2
create database ex2;
use ex2;
create table Pessoal(
idPessoal int primary key auto_increment,
nome varchar(45),
dtNascimento date
);

create table pessoa2 (
idPessoa2 int primary key auto_increment,
nome varchar(45),
dtNascimento date,
fkPessoal int,
constraint fkPessoal foreign key (fkPessoal) references Pessoal (idPessoal)
);

insert into Pessoal (nome, dtNascimento) values
('João Silva', '1990-05-12'),
('Maria Oliveira', '1985-09-23'),
('Carlos Souza', '2000-01-15'),
('Ana Pereira', '1995-07-30'),
('Lucas Santos', '1988-11-02');

insert into pessoa2 (nome,dtNascimento, fkPessoal) values 
('Pedro Almeida', '1992-03-10', 1),
('Juliana Costa', '1998-06-25', 2),
('Rafael Gomes', '1987-12-05', 3),
('Fernanda Rocha', '1993-08-14', 4),
('Bruno Martins', '2001-11-30', 5);

select
nome,
dtNascimento,
case
when year(curdate()) - year(dtNascimento) >= 18 then 'Mais velho'
else 'Mais novo'
end as Classificacao
from pessoa2;

select
nome,
ifnull(fkPessoal,'Sem responsável') as Responsavel
from pessoa2;


-- Exercício 3
create database ex3;

use ex3;

create table Candidato (
idCandidato int primary key auto_increment,
nome varchar(100),
cpf char(11),
dtNascimento date
);

create table Habilitacao(
idHabilitacao int primary key auto_increment,
categoria varchar(3),
dtemissao date,
dtValidade date,
fkCandidato int unique,
constraint ckCategoria
check(categoria in('a','b','ab','acc')),
constraint fkCandidatoHabilitacao
foreign key (fkCandidato) references Candidato (idCandidato)
);

insert into Candidato(nome,cpf,dtNascimento) values
('João Silva', '12345678900', '1990-05-10'),
('Maria Souza', '98765432100', '1985-08-22'),
('Carlos Pereira', '45612378900', '1992-12-03');

insert into Habilitacao (categoria, dtEmissao, dtValidade, fkCandidato) values
('A', '2019-03-10', '2024-03-10', 1),
('B', '2021-07-22', '2026-07-22', 2),
('AB', '2018-11-05', '2023-11-05', 3);

select *
from Candidato 
join Habilitacao
on Candidato.idCandidato = Habilitacao.fkcandidato;

select
	Candidato.nome as Nome,
    Habilitacao.categoria as Categoria,
    Habilitacao.dtValidade as validade
    from Candidato
    join Habilitacao
    on Candidato.idcandidato = Habilitacao.fkCandidato;
    
    select 
    Candidato.nome,
    Habilitacao.categoria,
    case
    when curdate() <= Habilitacao.dtValidade then 'Válida'
    else 'Vencida'
    end as StatusCNH
    from Candidato
    join Habilitacao
    on Candidato.idCandidato = Habilitacao.fkCandidato;
    
    select 
    nome,
    ifnull(dtValidade,'Validade não registrada') as Validade
    from Habilitacao
    join Candidato
    on Candidato.idCandidato = Habilitacao.fkCandidato;
    
    -- Exercício 4
    create database ex4;
    use ex4;
    create table Farmacia(
    idFarmacia int primary key auto_increment,
    nome varchar(100),
    cnpj char(14),
    telefone varchar(15)
    );
    
    create table Endereco(
    idEndereco int primary key auto_increment,
    logradouro varchar (100),
    numero varchar (10),
    bairro varchar(50),
    cidade varchar(50),
    cep char (8),
    fkFarmacia int unique,
    constraint fkFarmaciaEndereco
    foreign key (fkFarmacia) references Farmacia (idFarmacia)
    );
    
    create table Famarceutico (
    idFarmaceutico int primary key auto_increment,
    nome varchar(100),
    crf varchar(20),
    turno varchar(20),
    fkFarmacia int,
    constraint fkFarmaciaFarmaceutico
    foreign key (fkFarmacia) references Farmacia(idFarmacia)
    );
    
    insert into Farmacia (nome,cnpj,telefone) values
('Drogaria Central', '11111111000111', '(21) 3333-4444'),
('Farmácia Popular', '22222222000122', '(31) 5555-6666'),
('Bio Fórmulas', '33333333000133', '(41) 7777-8888');

insert into Endereco (logradouro, numero, bairro, cidade, cep, fkFarmacia) values
('Rua das Flores', '123', 'Centro', 'Curitiba', '80010000', 1),
('Rua Rio de Janeiro', '45', 'Savassi', 'Belo Horizonte', '30160040', 2),
('Rua Sete de Setembro', '888', 'Centro', 'Rio de Janeiro', '20050000', 3);

insert into Famarceutico (nome,crf, turno, fkFarmacia) values
('Carlos Oliveira', 'RJ-98765', 'Vespertino', 1),
('Ana Beatriz', 'MG-55443', 'Noturno', 2),
('Ricardo Santos', 'PR-22331', 'Matutino', 3);

SELECT *
FROM Farmacia
JOIN Endereco ON Farmacia.idFarmacia = Endereco.fkFarmacia
JOIN Famarceutico ON Farmacia.idFarmacia = Farmaceutico.fkFarmacia;

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
    
