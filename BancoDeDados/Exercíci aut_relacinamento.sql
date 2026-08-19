CREATE DATABASE auto_relacionamento;

USE auto_relacionamento;

-- Ex1
CREATE TABLE area_empresa (
	id_area_empresa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45)
);

CREATE TABLE funcionario (
	id_funcionario INT PRIMARY KEY AUTO_INCREMENT,
    cpf CHAR(11),
    dt_nascimento DATE,
    fk_supervisor INT,
    fk_area_empresa INT,
    CONSTRAINT cfk_supervisor FOREIGN KEY (fk_supervisor) REFERENCES funcionario (id_funcionario),
    CONSTRAINT cfk_area_empresa FOREIGN KEY (fk_area_empresa) REFERENCES area_empresa (id_area_empresa)
);

INSERT INTO area_empresa (nome) VALUES
('TI'),
('Financeiro'),
('social'),
('RH');

INSERT INTO funcionario (cpf, dt_nascimento, fk_supervisor, fk_area_empresa) VALUES
('11111111111', '1980-05-10', NULL, 1),
('22222222222', '1990-03-15', 1, 1),
('33333333333', '1995-07-22', 1, 2),
('44444444444', '1998-11-30', 2, 1),
('55555555555', '1992-01-18', 2, 3),
('66666666666', '1993-09-25', 3, 2),
('77777777777', '1997-06-12', 3, 4);

SELECT
	f.cpf AS 'Funcionário',
    s.cpf AS 'Supervisor'
FROM
	funcionario AS f
JOIN funcionario AS s
	ON s.id_funcionario = f.fk_supervisor;
    
SELECT
	f.cpf AS 'Funcionário',
    s.cpf AS 'Supervisor',
    a.nome AS 'Área'
FROM
	funcionario AS f
JOIN funcionario AS s
	ON s.id_funcionario = f.fk_supervisor
JOIN area_empresa AS a
	ON f.fk_area_empresa = a.id_area_empresa
WHERE a.nome = 'TI';

SELECT
	f.cpf AS 'Funcionário',
    s.cpf AS 'Supervisor'
CASE
	WHEN f.fk_supervisor IS NULL THEN 'Sem Supervisor'
    ELSE 'Com Supervisor'
END AS StatusSupervisor
FROM
	funcionario AS f
LEFT JOIN funcionario AS s
	ON s.id_funcionario = f.fk_supervisor;

-- Ex2
CREATE TABLE usuario (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    dt_nascimento DATE,
    fk_gerente INT,
    CONSTRAINT cfk_gerente FOREIGN KEY (fk_gerente) REFERENCES usuario (id_usuario)
);

CREATE TABLE email (
	id_email INT PRIMARY KEY AUTO_INCREMENT,
    assunto VARCHAR(45),
    mensagem VARCHAR(255),
    fk_usuario INT,
    CONSTRAINT cfk_usuario FOREIGN KEY (fk_usuario) REFERENCES usuario (id_usuario)
);

INSERT INTO usuario (nome, dt_nascimento, fk_gerente) VALUES
('Ricardo Silva', '1980-05-12', NULL),
('Patrícia Lima', '1994-02-28', 1),
('Gustavo Mendes', '1991-10-10', 1),
('Helena Costa', '1999-12-05', 2),
('Tiago Souza', '1996-07-22', 2),
('Beatriz Ramos', '1990-04-30', 3);
INSERT INTO email (assunto, mensagem, fk_usuario) VALUES
('Boas-vindas', 'Bem-vindo ao novo portal da empresa.', 1),
('Documentação', 'Favor anexar os documentos pendentes.', 2),
('Manutenção', 'O servidor ficará offline às 22h.', 3),
('Convite', 'Happy hour com o time na sexta!', 4),
('Urgente', 'Revisar o contrato do cliente X.', 5),
('Pesquisa', 'Responda ao formulário de clima mental.', 6),
('RH', 'Folha de pagamento disponível.', 2),
('Alerta', 'Tentativa de login suspeita detectada.', 3);

SELECT
	u.nome AS 'Usuário',
    g.nome AS 'Gerente'
FROM
	usuario AS u
JOIN usuario AS g
	ON u.fk_gerente = g.id_usuario;
    
SELECT
	u.nome AS 'Usuário',
    g.nome AS 'Gerente',
    e.assunto AS 'Assunto'
FROM
	usuario AS u
JOIN usuario AS g
	ON u.fk_gerente = g.id_usuario
JOIN email AS e
	ON e.fk_usuario = u.id_usuario
WHERE 
	e.assunto LIKE 'R%';

SELECT
	u.nome AS 'Usuário',
    g.nome AS 'Gerente',
CASE
	WHEN u.fk_gerente IS NULL THEN 'Sem Gerente'
    ELSE 'Com Gerente'
END AS StatusGerente
FROM
	usuario AS u
LEFT JOIN usuario AS g
	ON u.fk_gerente = g.id_usuario;