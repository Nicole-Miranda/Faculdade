-- ================================================ Dinâmica ================================================

/*
- Lista de 28 exercícios

- Sorteio para cada 1 dos exercícios. 
	-- Cada pessoa sorteada resolve 1 exercício, logo abaixo do enunciado.
    
- Se a pessoa sorteada tiver dificuldade, outra pessoa pode ser escolhida para ir ajudar. 
	-- Após a ajuda, a 1ª pessoa tem que escrever o comando na lousa, para fixar o conceito.
*/

-- ================================================ Lista de Desafios ================================================

-- 1. Criar e usar um banco de dados chamado biblioteca.
CREATE DATABASE biblioteca;
USE biblioteca;

-- 2. Criar uma tabela chamada livro com os campos: codigo (chave primária), titulo, autor e data de publicação. 
-- O campo autor deve ter o valor padrão definido como 'Sem Autor'.
CREATE TABLE livro (
	codigo INT PRIMARY KEY,
	titulo VARCHAR(100),
	autor VARCHAR(100) DEFAULT 'Sem Autor',
	data_publicacao DATE
);

-- 3. Adicionar dois registros na tabela livro.
INSERT INTO livro (codigo, titulo, autor, data_publicacao) VALUES
(1, 'Dom Casmurro', 'Machado de Assis', '1899-01-01'),
(2, 'Livro Teste', NULL, '2020-05-10');

-- 4. Exibir todos os registros existentes na tabela livro.
SELECT * FROM livro;

-- 5. Alterar o nome do autor de um dos livros já cadastrados.
UPDATE livro
SET autor = 'Autor Atualizado'
WHERE codigo = 2;

-- 6. Exibir o titulo e nome do registro alterado.
SELECT titulo, autor
FROM livro
WHERE codigo = 2;

-- 7. Remover um registro da tabela livro.
DELETE FROM livro
WHERE codigo = 2;

-- 8. Mostrar a estrutura (colunas e tipos de dados) da tabela livro.
DESCRIBE livro;

-- 9. Acrescentar uma nova coluna chamada editora na tabela livro.
ALTER TABLE livro
ADD COLUMN editora VARCHAR(100);

-- 10. Exiba todos os registros que contém a letra 'a' na coluna autor
SELECT *
FROM livro
WHERE autor LIKE '%a%';

-- 11. Exibe apenas o ano de publicação e o titulo do livro de todos os registros
SELECT titulo,
YEAR(data_publicacao) AS ano_publicacao
FROM livro;

-- 12. Exiba a data formatada, no formato brasileiro (exemplo: 26/02/2026) e
-- o titulo do livro de todos os registros
SELECT titulo,
DATE_FORMAT(data_publicacao, '%d/%m/%Y') AS data_formatada
FROM livro;

-- 13. Excluir a coluna editora da tabela livro.
ALTER TABLE livro
DROP COLUMN editora;

-- 14. Criar uma tabela chamada usuario com os campos: codigo, nome e tipo
-- A coluna nome deve ser inserida obrigatoriamente.
CREATE TABLE usuario (
	codigo INT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	tipo VARCHAR(50)
);

-- 15. Adicionar dois usuários à tabela criada.
INSERT INTO usuario (codigo, nome) VALUES
(1, 'João Silva'),
(2, 'Maria Lima');

-- 16. Alterar o campo tipo, para que aceite apenas determinados valores 
-- (ex.: docente, discente, visitante).
ALTER TABLE usuario
ADD CONSTRAINT chk_tipo
CHECK (tipo IN ('docente', 'discente', 'visitante'));

-- 17. Atualizar os dois registros de usuario, inserindo o valor do campo tipo.
UPDATE usuario SET tipo = 'docente' WHERE codigo = 1;
UPDATE usuario SET tipo = 'discente' WHERE codigo = 2;

-- 18. Exibir todos os registros da tabela usuario em que a penúltima letra 
-- do nome não é 'm'.
SELECT *
FROM usuario
WHERE nome NOT LIKE '%m_';

-- 19. Acrescentar uma nova coluna chamada telefone na tabela usuario.
ALTER TABLE usuario
ADD COLUMN telefone VARCHAR(20);

-- 20. Alterar a tabela usuario, aumentando a quantidade de caracteres 
-- na coluna nome
ALTER TABLE usuario
MODIFY COLUMN nome VARCHAR(150);

-- 21. Criar uma consulta na tabela usuario, renomeando a coluna nome 
-- para nome_completo.
SELECT nome AS nome_completo
FROM usuario;

-- 22. Criar uma consulta na tabela livro, mostrando titulo e autor 
-- juntos em uma única coluna chamada detalhes
-- no formato "Autor: X - Titulo: Y"
SELECT CONCAT('Autor: ', autor, ' - Titulo: ', titulo) AS detalhes
FROM livro;

-- 23. Criar uma consulta na tabela livro, mostrando titulo, ano_publicacao 
-- e uma coluna classificacao, que classifica livros publicados antes 
-- do ano 2000 como “Antigo” e os demais como “Moderno”.
SELECT titulo,
YEAR(data_publicacao) AS ano_publicacao,
CASE
	WHEN YEAR(data_publicacao) < 2000 THEN 'Antigo'
	ELSE 'Moderno'
END AS classificacao
FROM livro;

-- 24. Criar uma consulta na tabela livro que mostre o título e o autor.
-- Caso o autor esteja nulo, exibir “Autor desconhecido”.
SELECT titulo,
IFNULL(autor, 'Autor desconhecido') AS autor
FROM livro;

-- 25. Criar uma consulta na tabela livro, mostrando todos os dados, 
-- em ordem decrescente pelo nome
SELECT *
FROM livro
ORDER BY titulo DESC;

-- 26. Criar uma consulta na tabela usuario, mostrando todos os dados 
-- em que o dado na coluna tipo seja diferente de docente
SELECT *
FROM usuario
WHERE tipo <> 'docente';

-- 27. Esvaziar todos os registros da tabela livro, mantendo sua estrutura.
TRUNCATE TABLE livro;

-- 28. Apagar o banco de dados biblioteca.
DROP DATABASE biblioteca;