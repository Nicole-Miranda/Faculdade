-- Revisão Sprint2
 -- Atributo Atômico: menor forma de um atributo
 -- Atributo Composto: composto por vários elementos
 
 Create database 1ccoasprint2;
 use 1ccoasprint2;
 
 create table pessoa (
 id_pessoa int primary key auto_increment,
 nome varchar (60),
 cpf char(11) unique not null
 );
 
 -- Atributo Multivalorado (possui mais de um valor)
 -- è diferente de um atributo composto -> este possui os valores 
 -- dentro do mesmo campo
 create table telefone(
 id_telefone int primary key auto_increment,
 numero varchar (11),
 fk_pessoa int,
 constraint chFkPessoa 
 foreign key(fk_pessoa) references pessoa (id_pessoa)
 );
 
 create table dependente(
 id_dependente int auto_increment,
 nome varchar(60),
 cpf char(11) unique not null,
 fk_pessoa int,
 primary key (id_dependente, fk_pessoa),
 foreign key (fk_pessoa) references pessoa (id_pessoa)
 );
 
 insert into pessoa (nome, cpf) values
 ('Clara Faria', '11111111111'),
 ('Fernando Brandão','22222222222'),
 ('Julia Araripe', '33333333333');
 
 SELECT * FROM pessoa;
 
 insert into telefone (numero, fk_pessoa) values
 ('11888888888',1),
 ('11999999999',1),
 ('11777777777',2);
 
 insert into dependente (nome, cpf, fk_pessoa) values
 ('Pedro silva','33333333333', 1);
 
 insert into telefone (numero, fk_pessoa) values
 ('35666666666', null);
 
 select * from pessoa
 join telefone
 on fk_pessoa = id_pessoa;
 
 select * from telefone as t right join pessoa p on t.fk_pessoa = p.id_pessoa;
 
 select * from 
 pessoa as p
 join telefone tel
 on tel.fk_pessoa = p.id_pessoa
 join dependente d
 on p.id_pessoa = d.fk_pessoa;
 
 alter table pessoa add column fk_chefe int;
 alter table pessoa add constraint chFkChefe
 foreign key (fk_chefe) references pessoa (id_pessoa);
 
update pessoa set fk_chefe=2
where id_pessoa=3;

select * from pessoa;
select * from pessoa p
join pessoa chefe
on p.fk_chefe = chefe.id_pessoa;

select 
ifnull(chefe.nome, 'Sem chefe') as 'Nome Chefe',
p.nome as 'Nome pessoa'
from pessoa p
left join pessoa chefe
on p.fk_chefe = chefe.id_pessoa;

select 
ifnull(chefe.nome, 'Sem chefe') as 'Nome Chefe',
p.nome as 'Nome pessoa'
from pessoa p
left join pessoa chefe
on p.fk_chefe = chefe.id_pessoa
where 
p.nome like '%a' or p.nome like '%e%'
order by p.nome asc
;
 
 
 
 
 
 