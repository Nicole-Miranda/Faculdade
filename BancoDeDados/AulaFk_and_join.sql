CREATE DATABASE ccoa;
USE ccoa;

CREATE TABLE turma(
ID INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45),
ra VARCHAR(8),
descricao VARCHAR(20),
periodo YEAR 
);

CREATE TABLE alunos(
id INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(45),
ra CHAR(8),
Dtnascimento DATE,
fkTurma INT,
CONSTRAINT ctFkTurma
FOREIGN KEY(fkTurma)
REFERENCES turma(ID)
);

insert into turma (descricao, periodo) values
('1CCOA 20261',2026),
('1CCOB 20261',2026),
('1CCOK 20252',2025);

insert into alunos (nome,ra,Dtnascimento,fkTurma) values
('Marcos Paulo','42619990','2006-10-12',1),
('Rafael Canudo','04261998','2007-01-13',2),
('George Smith','04261997','1998-09-09',3);

select*from turma;
select*from alunos;

insert into alunos (nome,ra,Dtnascimento,fkTurma) values
('João Pedro','04261996','2004-03-22',1);

create table disciplinas(
id int primary key auto_increment,
nome varchar(45),
fkTurma int,
foreign key (fkTurma) references
turma(ID)
);

alter table disciplina drop column fkTurma;

insert into disciplinas (nome,fkTurma) values
('Banco de dados',1),
('Algoritmos',2);

Select
alunos.id as idAluno,
turma.ID as idTurma,
alunos.nome as nomeAluno,
turma.descricao as turma
from
alunos
left join turma on alunos.fkTurma=turma.ID
left join disciplinas on disciplinas.fkTurma=turma.ID;

create table empresa(
idEmpresa int primary key auto_increment,
razao_social varchar(45),
cnpj char(14)
);

create table pessoa (
idPessoa int primary key auto_increment,
nome varchar(45),
cpf char(11),
fkEmpresa int,
constraint ctFkempresa
foreign key (fkEmpresa)
references empresa(idEmpresa)
);

insert into empresa (razao_social, cnpj) values
('Safra','00000000000000');

insert into pessoa (nome, cpf, fkEmpresa) values
('Raphael Canudo', '99999999999',1);

select razao_social, nome
from empresa
join pessoa on idEmpresa=fkEmpresa;

select razao_social, nome
from empresa 
join pessoa on idEmpresa=fkEmpresa
where razao_social like 'Safra


