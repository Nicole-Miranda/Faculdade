create database ccoasp02;
use ccoasp02;

create table cliente (
id_cliente int primary key auto_increment,
nome varchar (45),
cpf char(11)
);

create table pedido (
id_pedido int primary key auto_increment,
dt_pedido datetime,
valor decimal(7,2),
fk_cliente int,
constraint fk_cliente foreign key (fk_cliente) references cliente (id_cliente) 
);

insert into cliente (nome, cpf) values 
('Clara','11111111111'),
('Marina','22222222222');

-- SUM()


-- AVG()

-- ROUND()

-- TRUNCATE()

-- MAX()

-- MIN()

-- COUNT()

-- HAVING

insert into pedido (dt_pedido, valor,fk_cliente) values 
(now(), 2500.00,1),
('2026-04-22 10:00:00', 1220.00,1),
(now(),9600.00,2),
(now(), 7400, 1);

select 
c.nome,
SUM(p.valor) as valor_total
from cliente c
join pedido p
on p.fk_cliente = c.id_cliente
group by c.nome;

select 
c.nome as maiores_compradores,
SUM(p.valor) 
from cliente c
join pedido p
on p.fk_cliente = c.id_cliente
where p.valor > 3000
group by c.nome;

select 
c.nome as maiores_compradores,
SUM(p.valor) 
from cliente c
join pedido p
on p.fk_cliente = c.id_cliente
group by c.nome
having sum(p.valor) > 3000;

select 
c.nome as maiores_compradores,
c.cpf,
SUM(p.valor) 
from cliente c
join pedido p
on p.fk_cliente = c.id_cliente
group by c.nome, c.cpf
having sum(p.valor) > 3000;

select 
c.nome
from cliente c
join pedido p 
on p.fk_cliente = c.id_cliente
group by c.nome;

select 
c.nome as maiores_compradores,
c.cpf,
SUM(p.valor) 
from cliente c
join pedido p
on p.fk_cliente = c.id_cliente
group by c.nome, c.cpf
having avg(p.valor) > 10;

insert into cliente (nome,cpf) values
('Clara','44444444444');

insert into pedido(dt_pedido, valor, fk_cliente) values
(now(), 9999.00,3);

select
c.nome as maiores_compradores
from cliente c
join pedido p
on p.fk_cliente = c.id_cliente
group by c.nome;


/*
select...
from...
join...
where...
group by...
having...
order by...
*/

