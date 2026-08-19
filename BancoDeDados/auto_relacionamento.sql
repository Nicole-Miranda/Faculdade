create database auto_relacionamento;
use auto_relacionamento;

-- Ex1

create table area_empresa(
id_area_empresa int primary key auto_increment,
nome varchar(45)
);

create table funcionario (
id_funcionario int primary key auto_increment,
cpf char(11),
dt_nascimento date,
fk_supervisor int,
fk_area_empresa int,
constraint cfk_supervisor foreign key (fk_supervisor) references funcionario (id_funcionario),
constraint cfk_area_empresa foreign key (fk_area_empresa) references area_empresa (id_area_empresa)
);

insert into area_empresa (nome) values
('desenvolvimento'),
('infraestrutura'),
('design'),
('comunidade');

insert into funcionario (cpf, dt_nascimento, fk_supervisor, fk_area_empresa) values
('12345678901', '1985-10-20', null, 1),
('98765432109', '1992-04-15', 1, 1),
('45678912300', '1995-12-05', 1, 3),
('32165498711', '2000-01-30', 2, 1),
('15975345688', '1993-08-12', 2, 2),
('75315945622', '1997-03-25', 3, 3),
('85245675399', '1999-06-18', 3, 4);

select
    f.cpf as 'funcionário',
    s.cpf as 'supervisor'
from
    funcionario as f
join funcionario as s
    on s.id_funcionario = f.fk_supervisor;
    
select
    f.cpf as 'funcionário',
    s.cpf as 'supervisor',
    a.nome as 'área'
from
    funcionario as f
join funcionario as s
    on s.id_funcionario = f.fk_supervisor
join area_empresa as a
    on f.fk_area_empresa = a.id_area_empresa
where a.nome = 'desenvolvimento';

select
    f.cpf as 'funcionário',
    s.cpf as 'supervisor',
case
    when f.fk_supervisor is null then 'sem supervisor'
    else 'com supervisor'
end as statussupervisor
from
    funcionario as f
left join funcionario as s
    on s.id_funcionario = f.fk_supervisor;
    
    create table usuario (
    id_usuario int primary key auto_increment,
    nome varchar(45),
    dt_nascimento date,
    fk_gerente int,
    constraint cfk_gerente foreign key (fk_gerente) references usuario (id_usuario)
);

create table email (
    id_email int primary key auto_increment,
    assunto varchar(45),
    mensagem varchar(255),
    fk_usuario int,
    constraint cfk_usuario foreign key (fk_usuario) references usuario (id_usuario)
);

insert into usuario (nome, dt_nascimento, fk_gerente) values
('nicole miranda', '2000-05-10', null),
('lucas tech', '1998-11-15', 1),
('pedro escalador', '1995-07-20', 1),
('manu dev', '2002-01-25', 2),
('bia ux', '1997-03-12', 2),
('caio infra', '1994-11-05', 3);

insert into email (assunto, mensagem, fk_usuario) values
('reunião infoclimbing', 'ajustes no layout da home.', 1),
('relatório logidock', 'taxa de ocupação das docas atualizada.', 2),
('rota de escalada', 'nova via aberta no setor sul.', 3),
('revisão de código', 'pull request aprovado com sucesso.', 4),
('recurso visual', 'trocar ícone do mosquetão no header.', 5),
('reparo servidor', 'manutenção agendada para sexta.', 6),
('reunião feedback', 'pautas sobre o projeto individual.', 2),
('resultado quiz', 'usuário completou o teste de agarras.', 3);

select
    u.nome as 'usuário',
    g.nome as 'gerente'
from
    usuario as u
join usuario as g
    on u.fk_gerente = g.id_usuario;
    
select
    u.nome as 'usuário',
    g.nome as 'gerente',
    e.assunto as 'assunto'
from
    usuario as u
join usuario as g
    on u.fk_gerente = g.id_usuario
join email as e
    on e.fk_usuario = u.id_usuario
where 
    e.assunto like 'r%';

select
    u.nome as 'usuário',
    g.nome as 'gerente',
case
    when u.fk_gerente is null then 'sem gerente'
    else 'com gerente'
end as statusgerente
from
    usuario as u
left join usuario as g
    on u.fk_gerente = g.id_usuario;

