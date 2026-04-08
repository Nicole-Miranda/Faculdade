CREATE DATABASE praticar_praticar;
USE praticar_praticar;

CREATE TABLE dono (
    id_dono INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE pet (
    id_pet INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    fk_dono INT NOT NULL,
    fk_mae INT,
    CONSTRAINT fk_pet_dono FOREIGN KEY (fk_dono) REFERENCES dono(id_dono),
    CONSTRAINT fk_pet_mae FOREIGN KEY (fk_mae) REFERENCES pet(id_pet)
);

INSERT INTO dono (nome) VALUES 
('Ricardo Silva'), 
('Beatriz Oliveira'), 
('Fernando Costa');

INSERT INTO pet (nome, fk_dono, fk_mae) VALUES 
('Gaia', 1, NULL), 
('Bela', 2, NULL), 
('Princesa', 3, NULL);

INSERT INTO pet (nome, fk_dono, fk_mae) VALUES 
('Apolo', 1, 1), 
('Pipoca', 2, 2), 
('Max', 3, 3);

SELECT 
    p.nome AS Pet, 
    d.nome AS Dono, 
    IFNULL(m.nome, 'Sem mãe') AS Mae
FROM pet p
JOIN dono d ON p.fk_dono = d.id_dono
LEFT JOIN pet m ON p.fk_mae = m.id_pet;

CREATE TABLE empresa (
    id_empresa INT PRIMARY KEY AUTO_INCREMENT,
    razao_social VARCHAR(45) NOT NULL
);

CREATE TABLE funcionario (
    id_funcionario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    fk_supervisor INT,
    fk_empresa INT NOT NULL,
    CONSTRAINT fk_funcionario_supervisor FOREIGN KEY (fk_supervisor) REFERENCES funcionario(id_funcionario),
    CONSTRAINT fk_funcionario_empresa FOREIGN KEY (fk_empresa) REFERENCES empresa(id_empresa)
);

INSERT INTO empresa (razao_social) VALUES 
('Logística Express'), 
('Global Marketing'), 
('Health Care S.A.');

INSERT INTO funcionario (nome, fk_supervisor, fk_empresa) VALUES 
('Roberto Justos', NULL, 3), 
('Luiza Trajano', NULL, 1), 
('Eduardo Saverin', NULL, 2);

INSERT INTO funcionario (nome, fk_supervisor, fk_empresa) VALUES 
('Marcos Pontes', 1, 3), 
('Fernanda Gentil', 2, 1), 
('Tiago Leifert', 3, 2);

SELECT 
    f.nome AS Funcionario, 
    s.nome AS Supervisor, 
    e.razao_social AS Empresa
FROM funcionario f
JOIN empresa e ON f.fk_empresa = e.id_empresa
LEFT JOIN funcionario s ON f.fk_supervisor = s.id_funcionario;

CREATE TABLE endereco (
    id_endereco INT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(45),
    bairro VARCHAR(45)
);

CREATE TABLE pessoa (
    id_pessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    fk_endereco INT UNIQUE,
    fk_sombra INT UNIQUE,
    CONSTRAINT fk_pessoa_endereco FOREIGN KEY (fk_endereco) REFERENCES endereco(id_endereco),
    CONSTRAINT fk_pessoa_sombra FOREIGN KEY (fk_sombra) REFERENCES pessoa(id_pessoa)
);

INSERT INTO endereco (rua, bairro) VALUES 
('Av. Paulista', 'Bela Vista'), 
('Rua das Flores', 'Cunha'), 
('Al. Santos', 'Cerqueira César');

INSERT INTO pessoa (nome, fk_endereco, fk_sombra) VALUES 
('Gabriel Khronos', 1, NULL), 
('Alice Wonderland', 2, 1), 
('Victor Hugo', 3, 2);

SELECT 
    p.nome AS Pessoa, 
    e.rua, 
    e.bairro, 
    s.nome AS Sombra
FROM pessoa p
LEFT JOIN endereco e ON p.fk_endereco = e.id_endereco
LEFT JOIN pessoa s ON p.fk_sombra = s.id_pessoa;

CREATE TABLE cliente (
    codCli INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cnh VARCHAR(11) NOT NULL,
    endereco VARCHAR(100)
);

CREATE TABLE telefone (
    telefone_pk INT PRIMARY KEY AUTO_INCREMENT,
    telefone VARCHAR(15) NOT NULL,
    codCli_fk INT NOT NULL,
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (codCli_fk) REFERENCES cliente(codCli)
);

CREATE TABLE carro (
    codCar INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(8) NOT NULL,
    cor VARCHAR(15),
    modelo VARCHAR(20),
    ano INT,
    diaria DOUBLE
);

CREATE TABLE aluga (
    codAlu INT PRIMARY KEY AUTO_INCREMENT,
    data_inicial DATE NOT NULL,
    data_final DATE NOT NULL,
    codCar INT NOT NULL,
    codCli INT NOT NULL,
    CONSTRAINT fk_aluga_carro FOREIGN KEY (codCar) REFERENCES carro(codCar),
    CONSTRAINT fk_aluga_cliente FOREIGN KEY (codCli) REFERENCES cliente(codCli)
);

CREATE TABLE esportivo (
    especialidade DOUBLE,
    codCar INT PRIMARY KEY,
    CONSTRAINT fk_esportivo_carro FOREIGN KEY (codCar) REFERENCES carro(codCar)
);

CREATE TABLE seda (
    passageiros INT,
    codCar INT PRIMARY KEY,
    CONSTRAINT fk_seda_carro FOREIGN KEY (codCar) REFERENCES carro(codCar)
);

INSERT INTO cliente (nome, cnh, endereco) VALUES 
('Douglas Souza', '11223344556', 'Rua das Olimpíadas, 10'), 
('Marta Vieira', '99887766554', 'Av. das Nações, 500');

INSERT INTO telefone (telefone, codCli_fk) VALUES 
('11912345678', 1), 
('11987654321', 2);

INSERT INTO carro (placa, cor, modelo, ano, diaria) VALUES 
('RHK2E12', 'Azul', 'BMW M3', 2024, 850.00), 
('LOU5T44', 'Cinza', 'Jetta GLI', 2023, 350.00),
('TRK9J88', 'Preto', 'Audi A4', 2022, 400.00);

INSERT INTO aluga (data_inicial, data_final, codCar, codCli) VALUES 
('2026-05-01', '2026-05-10', 1, 1), 
('2026-06-12', '2026-06-15', 2, 2);

INSERT INTO esportivo (especialidade, codCar) VALUES (3.5, 1);
INSERT INTO seda (passageiros, codCar) VALUES (5, 2), (5, 3);

SELECT 
    c.nome AS Cliente, 
    ca.modelo AS Carro, 
    ca.placa AS Placa, 
    a.data_inicial AS DataInicial, 
    a.data_final AS DataFinal
FROM aluga a
JOIN cliente c ON a.codCli = c.codCli
JOIN carro ca ON a.codCar = ca.codCar;

CREATE TABLE cliente2 (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    endereco VARCHAR(45),
    bairro VARCHAR(45),
    cidade VARCHAR(45),
    uf VARCHAR(2),
    telefone VARCHAR(45)
);

CREATE TABLE titulo (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    tipo VARCHAR(45),
    locado BIT
);

CREATE TABLE locacoes (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    codigoCliente INT,
    codigoTitulo INT,
    dataSaida DATETIME,
    dataRetorno DATETIME,
    CONSTRAINT fk_loc_cliente FOREIGN KEY (codigoCliente) REFERENCES cliente2(codigo),
    CONSTRAINT fk_loc_titulo FOREIGN KEY (codigoTitulo) REFERENCES titulo(codigo)
);

INSERT INTO cliente2 (nome, endereco, bairro, cidade, uf, telefone) VALUES 
('Lucas Neto', 'Rua dos Aventureiros', 'Recreio', 'Rio de Janeiro', 'RJ', '21900000000'), 
('Larissa Manoela', 'Av. Disney', 'Orlando', 'São Paulo', 'SP', '11911111111');

INSERT INTO titulo (nome, tipo, locado) VALUES 
('Inception', 'Ficção', 1), 
('O Poderoso Chefão', 'Drama', 1), 
('Super Mario Movie', 'Animação', 0);

INSERT INTO locacoes (codigoCliente, codigoTitulo, dataSaida, dataRetorno) VALUES 
(1, 1, '2026-04-20 14:00:00', '2026-04-23 18:00:00'), 
(2, 2, '2026-04-21 09:00:00', '2026-04-24 10:00:00');

SELECT 
    c.nome AS Cliente, 
    t.nome AS Titulo, 
    t.tipo, 
    l.dataSaida, 
    l.dataRetorno
FROM locacoes l
JOIN cliente2 c ON l.codigoCliente = c.codigo
JOIN titulo t ON l.codigoTitulo = t.codigo;

CREATE TABLE motorista (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    fone VARCHAR(45)
);

CREATE TABLE cliente3 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    fone VARCHAR(45),
    endereco VARCHAR(45)
);

CREATE TABLE veiculo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(45),
    modelo VARCHAR(45),
    cor VARCHAR(45),
    ano INT,
    motorista_id INT,
    CONSTRAINT fk_veiculo_motorista FOREIGN KEY (motorista_id) REFERENCES motorista(id)
);

CREATE TABLE viagem (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    time TIME,
    valor FLOAT,
    origem VARCHAR(45),
    destino VARCHAR(45),
    cliente_id INT,
    motorista_id INT,
    CONSTRAINT fk_viagem_cliente FOREIGN KEY (cliente_id) REFERENCES cliente3(id),
    CONSTRAINT fk_viagem_motorista FOREIGN KEY (motorista_id) REFERENCES motorista(id)
);

INSERT INTO motorista (nome, fone) VALUES 
('Lewis Hamilton', '11944445555'), 
('Ayrton Senna', '11922223333');

INSERT INTO cliente3 (nome, fone, endereco) VALUES 
('Pedro Pascal', '11977778888', 'Hotel Continental'), 
('Zendaya Coleman', '11966665555', 'Apartamento Central');

INSERT INTO veiculo (placa, modelo, cor, ano, motorista_id) VALUES 
('SPD001', 'Mercedes-AMG', 'Prata', 2025, 1), 
('BRA001', 'McLaren', 'Amarelo', 1991, 2);

INSERT INTO viagem (data, time, valor, origem, destino, cliente_id, motorista_id) VALUES 
('2026-04-10', '22:00:00', 150.00, 'Aeroporto', 'Interlagos', 1, 1), 
('2026-04-11', '08:30:00', 45.00, 'Oscar Freire', 'Vila Madalena', 2, 2);

SELECT 
    v.id AS Viagem, 
    c.nome AS Cliente, 
    m.nome AS Motorista, 
    ve.modelo AS Veiculo, 
    ve.placa, 
    v.origem, 
    v.destino, 
    v.valor
FROM viagem v
JOIN cliente3 c ON v.cliente_id = c.id
JOIN motorista m ON v.motorista_id = m.id
LEFT JOIN veiculo ve ON ve.motorista_id = m.id;