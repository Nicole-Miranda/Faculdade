-- Questionário 
	create database questionario;
    use questionario;
    
    CREATE TABLE funcionario(
    id_funcionario int primary key auto_increment,
    nome varchar(45),
    cpf char(11) UNIQUE NOT NULL
);

CREATE TABLE Tipo_funcionario(
id_tipoFuncionario int primary key auto_increment,
nome VARCHAR(45),
tipo_funcionario VARCHAR(45),
fk_funcionario int,
CONSTRAINT chFkFuncionario
FOREIGN KEY (fk_funcionario) REFERENCES funcionario (id_funcionario)
);

CREATE TABLE areaFuncionario(
id_area INT AUTO_INCREMENT,
nomeArea VARCHAR(45),
fk_funcionario int,
PRIMARY KEY (id_area,fk_funcionario),
FOREIGN KEY (fk_funcionario) REFERENCES funcionario (id_funcionario)
);

-- Exercícios Questionário 




