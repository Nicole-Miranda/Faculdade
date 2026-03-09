CREATE DATABASE projeto_pi;
USE projeto_pi;
CREATE TABLE rota(
id_rota INT PRIMARY KEY AUTO_INCREMENT,
cidade_saida VARCHAR(40),
cidade_chegada VARCHAR(40),
TempMedia VARCHAR(10),
placa_veiculo CHAR(7)
);

CREATE TABLE produto(
id_produto INT PRIMARY KEY AUTO_INCREMENT,
nome_produto VARCHAR(40),
tipo_produto VARCHAR(40),
temp_ideial VARCHAR(10)
);

CREATE TABLE documentação_financeira(
id_documentação INT PRIMARY KEY AUTO_INCREMENT,
documento_pgt VARCHAR(40),
documento_fiscal VARCHAR(40),
tipo_mercadoria VARCHAR(40),
nome_comprador VARCHAR(40),
cnpj_comprador CHAR(14)
); 

