CREATE DATABASE aula3BD;

USE aula3BD;

-- DECIMAL (8, 3) 
-- INT - inteiro ; integer
-- FLOAT 
-- DOUBLE
-- TINYINT

-- VARCHAR(255)
-- CHAR(8)

-- DATE 
-- DATETIME YYYY--MM-DD HH:mm:SS
-- TIME

-- CONSTRAINT é uma restrição
-- PRIMARY KEY é um tipo de constraint - CHAVE PRIMÁRIA
-- CHECK é outro tipo constraint - VERIFICA UMA REGRA
CREATE TABLE professor (
id INT, 
nome VARCHAR(45),
cpf CHAR(11),
salario DECIMAL(6, 2),
tipo VARCHAR(20),
dtCadastro DATETIME,
CONSTRAINT PKid PRIMARY KEY (id),
CONSTRAINT cTipo CHECK (tipo IN('Assistente', 'Titular'
'Monitor'))
);


ALTER TABLE professor MODIFY COLUMN 
id INT AUTO_INCREMENT;

-- CURDATE() -> PEGA A DATA ATUAL
-- CURRENT_TIMESTAMP() OU NOW() -> PEGA A DATA E HORA ATUAL
INSERT INTO professor (nome, cpf, salario, tipo,
dtCadastro) VALUES
('Clara', '11111111111', 1.99, 'Assistente', CURRENT_TIMESTAMP());

-- ALTERANDO A CONSTRAINT CRIADA ANTERIORMENTE, QUE ESTÁ COM UM ERRO 
-- FALTA A VIRGULA (,) ENTRE 'Titular' e 'Monitor'
ALTER TABLE professor DROP CONSTRAINT cTipo;
ALTER TABLE professor ADD CONSTRAINT 
cTipo CHECK (tipo IN('Assistente', 'Titular',
'Monitor'));

INSERT INTO professor (nome, cpf, salario, tipo,
dtCadastro) VALUES
('Nicole', '11111111111', 6000.75, 'Titular', CURRENT_TIMESTAMP());


-- UNIQUE É UM TIPO DE CONSTRAINT, QUE RESTRINGE O CAMPO PARA QUE O VALOR SEJA ÚNICO
-- O REGISTRO PRECISA SER ÚNICO NA TABELA (NÃO POSSO INSERIR OUTRO IGUAL)

-- DEFAULT DEFINE UM VALOR PADRÃO 
-- POSSO DEFINIR QUALQUER VALOR DESEJADO, DESDE QUE SEJA DO MESMO TIPO QUE O CAMPO
-- EXEMPLO: SE O CAMPO FOR INT, TENHO QUE TER UM NÚMERO COMO DEFAULT
CREATE TABLE aluno (
id INT PRIMARY KEY AUTO_INCREMENT,
ra CHAR(8) UNIQUE,
nome VARCHAR(45) DEFAULT 'Sem Nome',
dtCadastro DATETIME DEFAULT CURRENT_TIMESTAMP()
);

INSERT INTO aluno (ra) Values
('04261077'),
('04261099'),
('04261000');

SELECT * FROM aluno;

UPDATE aluno SET nome='Nicole' WHERE id=1;
UPDATE aluno SET nome='Thiago' WHERE id=2;
UPDATE aluno SET nome='Clara' WHERE id=3;

SELECT * FROM aluno;

-- ALIAS -> Apelido
-- SIGNIFICA QUE ESTOU RENOMEANDO A COLUNA APENAS PARA A VISUALIZAÇÃO/EXIBIÇÃO DO SELECT
-- DANDO UM "APELIDO"
SELECT 
nome AS 'Primeiro Nome',
ra AS 'Registro Acadêmico'
FROM aluno;

-- ALIAS - Apelido
SELECT 
nome 'Nome 1',
ra Registro
FROM aluno;

-- CASE -> PERMITE CRIAR UMA LÓGICA CONDICIONAL
-- A CONDICIONAL INICIA COM A PALAVRA WHEN
-- DEPOIS DO WHEN, SEMPRE TEM O THEN -> DEFINIR O QUE ACONTECE DADA DETERMINADA CONDIÇÃO
-- CASO EU QUEIRA UMA CONDIÇÃO QUE SIGNIFIQUE "TUDO QUE NÃO ESTÁ NAS OUTRAS CONDIÇÕES",
-- OU SEJA, AS EXCEÇÕES, POSSO COLOCAR O ELSE
-- TODO CASE TERMINA COM O END
-- GERALMENTE, APELIDAMOS O CASE, PARA O NOME DA COLUNA NÃO FICAR CONFUSO/ENORME
-- ASSIM COMO TODO SELECT, O CASE NÃO MODIFICA A TABELA, APENAS A VISUALIZAÇÃO (ESSE SELECT APENAS)
SELECT
	CASE 
    WHEN tipo='Monitor' THEN 3000.00
    WHEN tipo='Assistente' THEN 5000.00
	WHEN tipo='Titular' THEN 9000.00
    ELSE 0.00
    END AS salario_teste
    FROM professor;
    
    
	CREATE TABLE atleta(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    modalidade VARCHAR(30),
    cpf CHAR(11) UNIQUE NOT NULL,
    dtCadastro DATETIME DEFAULT CURRENT_TIMESTAMP(),
    qtdMedalhas INT,
    CONSTRAINT cModalidade CHECK(modalidade IN(
    'Atletismo', 'Natação', 'Futebol de Botão'
    ))
    );
    
    INSERT INTO atleta (nome, modalidade, cpf, qtdMedalhas)
    VALUES
    ('Phelps', 'Natação', '12211122211', 28),
    ('Guilherme', 'Natação', '33333333333', 20),
    ('Raphael', 'Futebol de Botão', '44444444444', 10),
    ('Rafael', 'Futebol de Botão', '99999999999', 9);
    
	-- IFNULL() -> TRATAMENTO QUANDO NULO - TRAZ O CAMPO, SE FOR NULO, TRAZ OUTRO VALOR
    -- CONCAT() -> CONCATENAÇÃO - JUNTAR
    SELECT 
    CONCAT('Hello ', 'World');
    
    INSERT INTO atleta (cpf) VALUES
    ('12456111111');
    
    SELECT * FROM atleta;
    
    SELECT
    IFNULL(nome, 'Sem nome')
    FROM atleta;
    
    -- CONCAT juntando  os valores
    -- IFNULL tratando os valores nulos, dentro do concat
    SELECT 
    CONCAT( IFNULL(nome, 'Sem Nome'), ' ', 
    IFNULL(modalidade, 'Sem Modalidade'))
    AS nome_mod
    FROM atleta;
    
    
    SELECT * FROM atleta;
    
    -- SELECT COM CASE, IFNULL, CONCAT, ALIAS
    SELECT
    CASE
    WHEN qtdMedalhas > 20 THEN 'Muito bom!'
    WHEN qtdMedalhas < 1 THEN 'Vixe! Sem medalha!'
    ELSE 'Tá no caminho! Continua!'
    END AS performance,
	CASE 
    WHEN modalidade='Futebol de Botão' THEN 'Diferenciado'
    ELSE 'Padrão'
    END AS descricao_modalidade,
    IFNULL(nome, 'Sem Nome'),
    CONCAT('CPF: ', cpf, ' / Cadastrado na data: '
    , dtCadastro) AS info_registro
    FROM atleta
    WHERE nome LIKE 'R%'
    AND nome LIKE '%l'
    OR nome NOT LIKE 'P%';
    
    -- AND -> E (ADICIONANDO)
    -- OR -> OU (ALTERNANDO)
    -- BETWEEN -> ENTRE - EXEMPLO: BETWEEN 20 AND 40 (ENTRE 20 E 40)
    SELECT 
    nome,
    qtdMedalhas
    FROM atleta
    WHERE 
    qtdMedalhas BETWEEN 20 AND 40
    AND nome LIKE 'P%'
    ORDER BY nome DESC;
    
    SELECT * FROM atleta ORDER BY dtCadastro;
    

