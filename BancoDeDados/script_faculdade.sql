CREATE DATABASE faculdade;
USE faculdade;

-- ===================================================
-- CRIAÇÃO DAS TABELAS
-- ===================================================

CREATE TABLE curso (
    idCurso INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    dtInicio DATE
);

CREATE TABLE aluno (
    idAluno INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    fkCurso INT,
    FOREIGN KEY (fkCurso) REFERENCES curso(idCurso)
);

CREATE TABLE materia (
    idMateria INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100)
);

CREATE TABLE sprint(
    idSprint INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    peso DECIMAL(4,2)
);

CREATE TABLE avaliacao(
    idAvaliacao INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    fkSprint INT,
    FOREIGN KEY(fkSprint) REFERENCES sprint(idSprint)
);

CREATE TABLE sprint_curso_materia(
    fkSprint INT,
    fkCurso INT,
    fkMateria INT,
    PRIMARY KEY(fkSprint,fkCurso,fkMateria),
    FOREIGN KEY(fkSprint) REFERENCES sprint(idSprint),
    FOREIGN KEY(fkCurso) REFERENCES curso(idCurso),
    FOREIGN KEY(fkMateria) REFERENCES materia(idMateria)
);

CREATE TABLE nota(
    idNota INT PRIMARY KEY AUTO_INCREMENT,
    valor DECIMAL(4,2),
    fkAluno INT,
    fkMateria INT,
    FOREIGN KEY(fkAluno) REFERENCES aluno(idAluno),
    FOREIGN KEY(fkMateria) REFERENCES materia(idMateria)
);

-- ===================================================
-- INSERTS
-- ===================================================

INSERT INTO curso(nome,dtInicio) VALUES
('1CCOA','2024-01-15'),
('ADS','2024-01-15'),
('SIS','2024-07-01'),
('BD','2024-07-01'),
('Engenharia','2025-02-01'),
('Arquitetura','2025-02-01'),
('Jogos','2023-08-10');

INSERT INTO aluno(nome,fkCurso) VALUES
('Ana Silva',1),
('Pedro Souza',1),
('Carlos Lima',2),
('Julia Mendes',2),
('Fernanda Rocha',3),
('Lucas Costa',1),
('Ricardo Alves',5),
('Mariana Lopes',5),
('Beatriz Silva',2);

INSERT INTO materia(nome) VALUES
('Banco de Dados'),
('Algoritmos'),
('Java'),
('Redes'),
('UX'),
('Matematica'),
('Seguranca'),
('Cloud');

INSERT INTO sprint(nome,peso) VALUES
('Sprint1',2),
('Sprint2',3),
('Sprint3',5),
('Sprint4',8);

INSERT INTO avaliacao(nome,fkSprint) VALUES
('Prova',1),
('PI',1),

('Quiz',2),
('Entrega',2),
('Seminario',2),

('Checkpoint',3),
('Desafio',3),
('Projeto',3),
('Apresentacao',3),

('Teste',4);

INSERT INTO sprint_curso_materia VALUES
(1,1,1),
(1,1,2),
(2,1,3),
(2,2,1),
(2,2,4),
(3,3,2),
(3,3,5),
(4,5,1),
(4,5,6),
(1,6,7),
(2,7,3),
(2,7,4);

INSERT INTO nota(valor,fkAluno,fkMateria) VALUES
(9,1,1),
(8,1,2),
(10,1,3),

(8.5,2,1),
(9,2,2),
(6,2,3),

(5,3,1),
(6,3,4),

(8,4,1),
(7,4,4),

(9,5,2),

(10,6,1),
(8,6,2),
(9,6,3),

(6,7,1),
(9,7,6),

(10,8,1),

(8,9,4);

-- ===================================================
-- QUESTÕES
-- ===================================================

-- 1. Liste as matérias que têm mais de 3 notas registradas.

-- 2. Quais cursos não têm nenhum aluno matriculado? Utilize NOT IN ou NOT EXISTS.

-- 3. Encontre os alunos que possuem mais de uma nota com valor superior a 7.

-- 4. Calcule o número de matérias distintas associadas a cada curso.

-- 5. Descubra os períodos de início de curso que têm mais de um curso começando naquele período.

-- 6. Liste o número total de alunos matriculados em cada curso.

-- 7. Quais alunos possuem o mesmo número de notas lançadas que a aluna 'Ana Silva'?

-- 8. Para cada matéria, liste o número de vezes que ela aparece na tabela sprint_curso_materia.

-- 9. Liste os nomes dos alunos matriculados no curso '1CCOA'.

-- 10. Determine quantas avaliações diferentes cada sprint possui.

-- 11. Liste os cursos que possuem pelo menos 2 matérias associadas.

-- 12. Encontre os alunos matriculados no mesmo curso que 'Pedro Souza'.

-- 13. Encontre as sprints que possuem mais de duas avaliações associadas.

-- 14. Conte quantos alunos estão registrados em cada período de início de curso.

-- 15. Encontre os cursos iniciados antes de todos os cursos que possuem a letra 'A' no nome.

-- 16. Liste o número de alunos por curso em ordem decrescente.

-- 17. Encontre o número de notas lançadas para cada aluno.

-- 18. Quais matérias não possuem nenhuma nota atribuída?

-- 19. Encontre os cursos cuja quantidade de alunos seja superior a 2.

-- 20. Encontre os períodos cujo número de cursos seja maior que o número de cursos iniciados em '2024-07-01'.

-- 21. Liste as matérias associadas ao curso cujo ID é igual a 3.

-- 22. Descubra quantos cursos diferentes estão associados a cada sprint.

-- 23. Encontre os alunos que possuem nota acima da média geral das notas.

-- 24. Liste as sprints que possuem peso maior que a média de peso das sprints.

-- 25. Para cada período de início, determine quantos cursos foram iniciados.

-- 26. Calcule o número de notas atribuídas a cada matéria.