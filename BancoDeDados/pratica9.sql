create database pratica9;
use pratica9;

create table grupo(
id_grupo int primary key auto_increment,
nome varchar(45),
descricao varchar(45)
);

create table aluno(
ra_aluno int primary key auto_increment,
nome varchar (45),
email varchar(45),
fk_grupo int,
constraint chfkGrupo foreign key (fk_grupo) references grupo (id_grupo)
);

create table professor (
id_professor int primary key auto_increment,
nome varchar(45),
disciplina varchar(45)
) auto_increment = 10000;

create table avaliacao (
dataHora_apresentacao datetime,
nota_grupo decimal(4,2),
fk_grupo int,
fk_professor int,
primary key(fk_grupo, fk_Professor, dataHora_apresentacao),
foreign key (fk_grupo) references grupo (id_grupo),
foreign key (fk_professor) references professor(id_professor)
);

insert into grupo (nome, descricao) values 
('aquatech', 'monitoramento de temperatura em aquários'),
('logidock', 'controle logístico de cargas portuárias');

insert into aluno (ra_aluno, nome, email, fk_grupo) values 
(01261001, 'nicole miranda', 'nicole.miranda@sptech.com', 1),
(01261002, 'aluno sptech', 'aluno.exemplo@sptech.com', 2),
(01261003, 'beatriz silva', 'beatriz.silva@sptech.com', 1);

insert into professor (nome, disciplina) values 
('vivian', 'banco de dados'),
('caio', 'algoritmos'),
('fernando', 'arquitetura computacional');

insert into avaliacao (fk_grupo, fk_professor, dataHora_apresentacao, nota_grupo) values 
(1, 10000, '2026-04-26 14:00:00', 9.5),
(1, 10001, '2026-04-26 14:30:00', 8.0),
(2, 10000, '2026-04-26 15:00:00', 10.0),
(2, 10002, '2026-04-26 15:45:00', 7.5);

select * from grupo;
select * from aluno;
select * from professor;
select * from avaliacao;

select g.nome as grupo,
g.descricao as projeto,
a.ra_aluno,
a.nome as aluno
from grupo as g
join aluno as a
on a.fk_grupo = g.id_grupo
where g.nome = 'aquatech'; 

select avg(nota_grupo)
from avaliacao 
group by fk_grupo;

select min(nota_grupo) as nota_minima
from avaliacao  
group by fk_grupo;

select max(nota_grupo) as nota_maxima
from avaliacao
group by fk_grupo;

select sum(nota_grupo) as soma_notas
from avaliacao;

select p.nome as professor,
p.disciplina,
g.nome as grupo,
g.descricao as projeto,
av.dataHora_apresentacao as 'Data e hora',
av.nota_grupo
from professor as p
join avaliacao as av
on p.id_professor = av.fk_professor
join grupo as g 
on g.id_grupo = av.fk_grupo;

select p.nome as professor,
p.disciplina,
g.nome as grupo,
g.descricao as projeto,
av.dataHora_apresentacao as 'Data e hora',
av.nota_grupo
from professor as p
join avaliacao as av
on p.id_professor = av.fk_professor
join grupo as g 
on g.id_grupo = av.fk_grupo
where g.nome = 'aquatech';

select p.nome as professor,
p.disciplina,
g.nome as grupo,
g.descricao as projeto,
av.dataHora_apresentacao as 'Data e hora',
av.nota_grupo
from professor as p
join avaliacao as av
on p.id_professor = av.fk_professor
join grupo as g 
on g.id_grupo = av.fk_grupo
where p.nome = 'vivian';

select g.nome as grupo,
g.descricao as projeto,
a.nome as aluno,
a.email,
p.nome as professor,
p.disciplina,
av.dataHora_apresentacao as 'Data e hora',
av.nota_grupo
from grupo as g
join aluno as a 
on g.id_grupo = a.fk_grupo
join avaliacao as av
on g.id_grupo = av.fk_grupo
join professor as p
on p.id_professor = av.fk_professor;

select count(distinct nota_grupo) as 'quantidade de notas distintas'
from avaliacao;

select a.fk_professor as id_professor,
avg(nota_grupo) as media_notas,
sum(nota_grupo) as soma_notas
from avaliacao as a 
group by fk_professor;

select a.fk_grupo as id_grupo,
avg(nota_grupo) as media_notas,
sum(nota_grupo) as soma_notas
from avaliacao as a 
group by fk_grupo;

select a.fk_professor as id_professor,
min(nota_grupo) as menores_notas,
max(nota_grupo) as soma_notas
from avaliacao as a 
group by fk_professor;

select a.fk_grupo as id_grupo,
min(nota_grupo) as menor_notas,
max(nota_grupo) as maior_notas
from avaliacao as a 
group by fk_grupo;

-- FIMM!!



