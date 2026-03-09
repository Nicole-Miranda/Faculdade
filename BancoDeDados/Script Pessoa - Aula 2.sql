-- Aula 2
-- Mais comandos

USE sprint1;

SHOW TABLES;

/*
TIPOS DE DADOS
TEXTO - VARCHAR() - VARIÁVEL
	- CHAR() - FIXO

NÚMEROS - INT 
	NÚMEROS DECIMAIS
    - FLOAT - 7 CARACTERES
    - DOUBLE - 15 CARACTERES
    - DECIMAL() - (5,2) = 765,43
				- (7,3) = 5678,909
	- TINYINT - NÚMERO DE -128 até 127 (NÚMEROS PEQUENOS)
    
    - DATE - 'YYYY-MM-DD'
    - DATETIME - 'YYYY-MM-DD HH:MM:SS'
*/

-- O AUTO_INCREMENT incrementa automáticamente o meu campo (chave primária)
-- Por padrão, o número inicial é o 1
-- Mas é possível parametrizar o número ao final da criação da tabela
CREATE TABLE pessoa (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(40),
dtNasc DATE
) AUTO_INCREMENT=1000;

INSERT INTO pessoa VALUES
	(1, 'Cooper', '1984-12-31'),
	(2, 'Bruce', '1985-03-14'),
	(3, 'Lucifer', '1900-01-01');
    
SELECT * FROM pessoa;

INSERT INTO pessoa (nome, dtNasc) VALUES
('Vivian', '1983-10-03'),
('Thiago', '2006-11-27');

-- Exibir somente o nome e data de nascimento
-- em que o nome começa com a letra 'T'
SELECT nome, dtNasc FROM pessoa
	WHERE nome LIKE 'T%';
    
-- Exibir somente os nomes que 
-- NÃO começam com a letra T
SELECT nome FROM pessoa 
	WHERE nome NOT LIKE 'T%';
    
-- Exibir somente os nomes que 
-- NÃO são 'Vivian'
SELECT nome FROM pessoa
	WHERE nome <> 'Vivian';

SELECT nome FROM pessoa
	WHERE nome != 'Vivian';
    
-- Exibindo os nomes em ordem decrescente
	SELECT nome FROM pessoa
		ORDER BY nome DESC;
        
-- Exibindo os nomes em ordem crescente
	SELECT nome FROM pessoa
		ORDER BY nome;
        

-- ALTERAR A TABELA - ADICIONAR COLUNA ALTURA
ALTER TABLE pessoa ADD COLUMN altura DECIMAL(3,2);

DESCRIBE pessoa;

SELECT * FROM pessoa;

-- ALTERAR A QUANTIDADE DE CARACTERES DO CAMPO NOME
ALTER TABLE pessoa MODIFY COLUMN nome VARCHAR(10);

DESCRIBE pessoa;

-- ALTERAR A TABELA RENOMEAR O CAMPO DTNASC
ALTER TABLE pessoa RENAME COLUMN dtNasc TO dtNascimento;

SELECT * FROM pessoa;

-- ATUALIZAR UM CAMPO DE UMA LINHA/TUPLA
UPDATE pessoa SET altura = 1.83
	WHERE id = 1;

SELECT * FROM pessoa;

-- EXCLUIR A LINHA 2 e 3
DELETE FROM pessoa	
	WHERE id = 2;

DELETE FROM pessoa	
	WHERE id = 3;

-- DELETE FROM pessoa WHERE id = 2 OR id = 3;
-- DELETE FROM pessoa WHERE id IN (2,3);
-- DELETE FROM pessoa WHERE id > 1;

-- AUTO-INCREMENT, CASO NÃO TIVESSE SIDO FEITO NA CRIAÇÃO DA TABELA
ALTER TABLE pessoa MODIFY COLUMN id INT AUTO_INCREMENT;

INSERT INTO pessoa VALUES
	(default, 'Batman', '1963-10-10', 1.91);
    
SELECT * FROM pessoa;

DELETE FROM pessoa WHERE id = 2;

INSERT INTO pessoa (nome, altura) VALUES
	('Robbin', 1.54);
    
SELECT * FROM pessoa;

-- ALTERAR A TABELA, EXCLUINDO UM CAMPO
ALTER TABLE pessoa DROP COLUMN altura;

DESCRIBE pessoa;

SELECT * FROM pessoa;

-- LIMPAR OS DADOS DA TABELA - AS LINHAS E O AUTO-INCREMENT
TRUNCATE TABLE pessoa;

SELECT * FROM pessoa;

INSERT INTO pessoa (nome, dtNascimento) VALUES
	('Steve', '1999-01-01');
    
-- DROP TABLE pessoa;