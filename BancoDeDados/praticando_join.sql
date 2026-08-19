-- Para praticar join

-- Exercício 01
Create database Projeto;
use Projeto;

create table alunos (
raAluno int primary key auto_increment, 
nome varchar (45),
telefone char (11),
fkprojeto int,
constraint chFkProjeto foreign key (fkprojeto) references projeto (idProjeto),
fkrepresentante int,
constraint chfkRepresentante foreign key (fkrepresentante) references alunos (raAluno)
);

create table projeto (
idProjeto int primary key auto_increment,
nome varchar (45),
descricaoProjeto varchar(45)
);

INSERT INTO projeto (nome, descricaoProjeto) VALUES 
('AquaTech', 'Monitoramento de temperatura');

insert into alunos (nome, telefone, fkprojeto, fkrepresentante) values
('Miranda','11111111111',1,null),
('Nicole','22222222222',1,1),
('Lorena','33333333333',1,1),
('Rodrigo','44444444444',1,1),
('Amanda','66666666666',1,1);

select * from alunos;
select * from projeto;

select * from alunos 
join projeto on
alunos.fkprojeto = projeto.idProjeto;

select a.raAluno as 'RA Aluno',
a.nome as 'Nome Aluno',
r.nome as 'Nome representante'
from alunos as a
left join alunos as r
on a.fkrepresentante = r.raAluno;

select a.raAluno as 'RA Aluno',
a.nome as 'Nome Aluno',
r.nome as 'Nome representante',
p.nome as 'Nome Projeto'
from alunos as a
left join alunos as r
on a.fkrepresentante = r.raAluno
join projeto p
on a.fkprojeto = p.idProjeto
where p.nome = 'AquaTech';

-- Exercício 02

create table campanha(
idCampanha int primary key auto_increment,
categoria varchar(45),
instituicao varchar (45),
DataFinal date
);

create table organizadores (
idOrganizadores int primary key auto_increment,
nome varchar (45),
endereco varchar (70),
email varchar (45),
FkCampanha int,
constraint chfkCampanha foreign key (FkCampanha) references campanha (idCampanha),
FkExperiente int,
constraint chFkExperiente foreign key (FkExperiente) references organizadores (idOrganizadores)
);

alter table campanha auto_increment = 30;
alter table campanha auto_increment = 500;

alter table organizadores auto_increment = 30;

insert into campanha (categoria, instituicao, DataFinal) values
('Alimento','Escolar','2026-08-10');

insert into organizadores (nome, endereco,email,FkCampanha,FkExperiente) values
('Miranda','Rua geraldo freire da silva - Village São Luis','miranda@gmail.com',500,null);

insert into organizadores (nome, endereco, email, FKcampanha, FKExperiente) values
('Manu','Rua benicio da silva - vila dirce','manuela@gmail.com',500,11);

SELECT idOrganizadores, nome FROM organizadores;

select * from organizadores;
select * from campanha;

select * from 
organizadores as o
join campanha as m
on o.FkCampanha = m.idCampanha;

select o.nome as 'Organizador',
o.endereco as 'Endereço',
o.email as 'Email',
c.categoria as 'Categoria',
c.instituicao as 'Instituição'
from organizadores o
join campanha c
on o.FkCampanha = c.idCampanha
where o.nome = 'Miranda';

select novato.nome as 'Organizador Novato',
novato.endereco as 'Organizador Endereço',
novato.email as 'Email Novato',
orientador.nome as 'Nome Orientador',
orientador.endereco as 'Orientador endereço',
orientador.email as 'Orientador email'
from organizadores as novato 
join organizadores as orientador
on novato.FkExperiente = orientador.idOrganizadores;

select novato.nome as 'nome novato',
c.categoria as 'categoria campanha',
c.instituicao as 'instituicao',
orientador.nome as 'nome orientador'
from organizadores as novato
join campanha as c 
on novato.fkcampanha = c.idcampanha
join organizadores as orientador 
on novato.fkexperiente = orientador.idorganizadores;
    
select novato.nome as 'nome novato',
novato.email as 'email novato',
c.categoria as 'campanha',
c.datafinal as 'data final',
orientador.nome as 'orientador'
from organizadores as novato
join campanha as c 
on novato.fkcampanha = c.idcampanha
join organizadores as orientador 
on novato.fkexperiente = orientador.idorganizadores
where novato.nome = 'manu';
    
    












