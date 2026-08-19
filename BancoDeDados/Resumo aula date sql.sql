-- Função DATE_FORMAT() -> permite configurar a formatação da data conforme parametriação

SELECT DATE_FORMAT('2026-02-26', '%d/%m/%Y, %a,%H:%i') as dt_hora_atual;

-- Função para trazer somente o ano 

SELECT YEAR('2025-10-11');
SELECT YEAR(NOW());

-- Função apra trazer somente o horário

SELECT TIME('2026-02-26 10:28:58');

CREATE DATABASE aula4ccoa;
USE aula4ccoa;
CREATE TABLE pedido(
id INT PRIMARY KEY AUTO_INCREMENT,
dt_hora_pedido DATETIME DEFAULT CURRENT_TIMESTAMP(),
cliente VARCHAR(45)
);

INSERT INTO pedido (cliente) VALUES
('clara'),
('thiago');

INSERT INTO pedido (dt_hora_pedido, cliente)VALUES
('2025-02-26 10:30:00','Matheus');

select*from pedido;

SELECT cliente, DAY (dt_hora_pedido) FROM pedido;
SELECT cliente, MONTH (dt_hora_pedido) FROM pedido; 
SELECT cliente, DATE_FORMAT(dt_hora_pedido, '%b') FROM pedido;

SELECT 
CONCAT(
'Cliente', cliente, ' realizou o pedido neste mês,
na data ', DATE_FORMAT(dt_hora_pedido,'%d/%m')
) AS detalhamento 
FROM pedido
WHERE MONTH (dt_hora_pedido) > 1
AND YEAR (dt_hora_pedido) > 2025;

CREATE DATABASE biblioteca;
USE biblioteca;
CREATE TABLE livro(
codigo INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(50),
autor VARCHAR(50) DEFAULT 'Sem Autor',
dt_publicação DATE
);

INSERT INTO livro (titulo,autor,dt_publicação) VALUE
('Sem palavras','eu mesmo','2024-01-12'),
('No words','myself','2026-02-12');

SELECT*FROM livro;

UPDATE livro SET autor='Nicole Miranda' WHERE codigo=1;

SELECT titulo,autor FROM livro WHERE codigo=1;

DELETE FROM  livro WHERE codigo=2;

DESCRIBE livro;

ALTER TABLE livro ADD COLUMN  editoria VARCHAR(45);

SELECT*FROM livro WHERE autor LIKE '%a';

SELECT titulo, YEAR(dt_publicação) FROM livro;

SELECT titulo,DATE_FORMAT(dt_publicação, '%d/%m/%Y') AS dt FROM livro;

ALTER TABLE livro DROP COLUMN editoria;

CREATE TABLE usuario(
codigo int primary key auto_increment,
nome varchar(40) not null,
tipo varchar(40)
);

INSERT INTO usuario (nome) VALUES
('Fernanda'),
('Safraboy');

alter table usuario add constraint cTipo check(tipo in('docente','discente','visitante'));
 update usuario set tipo='docente' where codigo=1;
 
 update usuario set tipo='visitante' where codigo=2;
 
 select*from usuario where nome not like '%m_';
 
 alter table usuario add column telefone varchar(15);
 
 alter table usuario modify column nome varchar(60);
 
 select nome as 'nome_completo' from usuario;
 
 select concat('autor; ', autor, 'titulo', titulo) as 'detalhes' from livro;
 
 select titulo, dt_publicação, 
 case when year (dt_publicação) < 2000 then 'Antigo'
 else 'Moderno' end as classificação 
 from livro;
 select titulo,
 ifnull(autor, 'Autor desconhecido')
 from livro;
 






