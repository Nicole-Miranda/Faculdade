-- É um comentário

/*
Bloco 
de 
Comentário
*/

-- Modelo de Dados do tipo Relacional
-- Tabelas que se relacionam entre elas
-- Tabelas são compostas por colunas, linhas

-- Todos os comandos são em inglês
-- Todos os comandos terminam com ;

-- CRIAR O BANCO DE DADOS ccoa
CREATE DATABASE ccoa;

-- UTILIZAR/SELECIONAR/USAR O BD CRIADO
USE ccoa;

-- Toda tabela tem que ter uma coluna que torna aquela linha única
-- Essa coluna é chamada de CHAVE PRIMÁRIA - PRIMARY KEY - PK

-- CRIAR A TABELA EMPRESA
CREATE TABLE empresa (
id INT PRIMARY KEY,
nome VARCHAR(30),
responsavel VARCHAR(25)
);

-- DESCREVER OS CAMPOS DA TABELA
DESCRIBE empresa;
DESC empresa;

-- INSERIR AS EMPRESAS
INSERT INTO empresa VALUES
	(1, 'Accenture', 'Wilian');
    
-- EXIBIR OS DADOS DAS EMPRESAS
SELECT id, nome, responsavel FROM empresa;
SELECT nome, responsavel FROM empresa;
SELECT responsavel, nome FROM empresa;

SELECT * FROM empresa;

-- INSERIR AS OUTRAS EMPRESAS
INSERT INTO empresa VALUES
	(2, 'Minsait', 'Yasmin'),
	(3, 'Stefanini', 'Ariel');
    
SELECT * FROM empresa;

-- EXIBIR APENAS OS DADOS DA EMPRESA STEFANINI
SELECT * FROM empresa
	WHERE nome = 'Stefanini';

-- EXIBIR AS EMPRESAS DIFERENTES DE STEFANINI
SELECT * FROM empresa
	WHERE nome != 'Stefanini';

SELECT * FROM empresa
	WHERE nome <> 'Stefanini';

-- EXIBIR AS EMPRESAS QUE COMEÇAM COM A LETRA S
SELECT nome FROM empresa
	WHERE nome LIKE 'S%';

-- EXIBIR AS EMPRESAS QUE TERMINAM COM A LETRA I
SELECT nome FROM empresa
	WHERE nome LIKE '%i';

-- EXIBIR AS EMPRESAS QUE CONTEM A LETRA I
SELECT nome FROM empresa
	WHERE nome LIKE '%i%';

-- EXIBIR AS EMPRESAS ONDE A SEGUNDA LETRA É T
SELECT nome FROM empresa  
	WHERE nome LIKE '_t%';

-- EXIBIR AS EMPRESAS ONDE A PENULTIMA LETRA É N
SELECT nome FROM empresa
	WHERE nome LIKE '%n_';

SELECT * FROM empresa;
-- EXIBIR AS EMPRESAS EM ORDEM CRESCENTE PELO NOME
SELECT * FROM empresa ORDER BY nome;
SELECT * FROM empresa ORDER BY nome ASC;

-- DECRESCENTE
SELECT * FROM empresa ORDER BY nome DESC;
SELECT * FROM empresa ORDER BY responsavel DESC;

-- ELIMINANDO A TABELA
DROP TABLE empresa;
-- Exercício 1:

No MySQL Workbench, utilizando o banco de dados ‘sprint1’:
Escreva e execute os comandos para:
• Criar a tabela chamada Atleta para conter os dados: idAtleta (int e chave primária da
tabela), nome (varchar, tamanho 40), modalidade (varchar, tamanho 40), qtdMedalha
(int, representando a quantidade de medalhas que o atleta possui)
• Inserir dados na tabela, procurando colocar mais de um atleta para cada modalidade
Escreva e execute os comandos para:
• Exibir todos os dados da tabela.
• Exibir apenas os nomes e quantidade de medalhas dos atletas.
• Exibir apenas os dados dos atletas de uma determinada modalidade.
• Exibir os dados da tabela ordenados pela modalidade.
• Exibir os dados da tabela, ordenados pela quantidade de medalhas, em ordem decrescente.
• Exibir os dados da tabela, dos atletas cujo nome contenha a letra s
• Exibir os dados da tabela, dos atletas cujo nome comece com uma determinada letra.
• Exibir os dados da tabela, dos atletas cujo nome termine com a letra o.
• Exibir os dados da tabela, dos atletas cujo nome tenha a penúltima letra r.
• Eliminar a tabela.

Exercício 2:

No MySQL Workbench, utilizando o banco de dados ‘sprint1’:
Criar a tabela chamada Musica para conter os dados: idMusica, titulo (tamanho 40), artista
(tamanho 40), genero (tamanho 40), sendo que idMusica é a chave primária da tabela.
Inserir dados na tabela, procurando colocar um gênero de música que tenha mais de uma
música, e um artista, que tenha mais de uma música cadastrada. Procure inserir pelo
menos umas 7 músicas.
Execute os comandos para:
a) Exibir todos os dados da tabela.
b) Exibir apenas os títulos e os artistas das músicas.
c) Exibir apenas os dados das músicas de um determinado gênero.
d) Exibir apenas os dados das músicas de um determinado artista.
e) Exibir os dados da tabela ordenados pelo título da música.
f) Exibir os dados da tabela ordenados pelo artista em ordem decrescente.
g) Exibir os dados da tabela, das músicas cujo título comece com uma determinada letra.
h) Exibir os dados da tabela, das músicas cujo artista termine com uma determinada letra.
i) Exibir os dados da tabela, das músicas cujo gênero tenha como segunda letra uma
determinada letra.
j) Exibir os dados da tabela, das músicas cujo título tenha como penúltima letra uma
determinada letra.
k) Elimine a tabela.

Exercício 3:

No MySQL Workbench, utilizando o banco de dados ‘sprint1’:
Criar a tabela chamada Filme para conter os dados: idFilme, título (tamanho 50), genero
(tamanho 40), diretor (tamanho 40), sendo que idFilme é a chave primária da tabela.
Inserir dados na tabela, procurando colocar um gênero de filme que tenha mais de um
filme, e um diretor, que tenha mais de um filme cadastrado. Procure inserir pelo menos
uns 7 filmes.
Execute os comandos para:
• Exibir todos os dados da tabela.
• Exibir apenas os títulos e os diretores dos filmes.
• Exibir apenas os dados dos filmes de um determinado gênero.
• Exibir apenas os dados dos filmes de um determinado diretor.
• Exibir os dados da tabela ordenados pelo título do filme.
• Exibir os dados da tabela ordenados pelo diretor em ordem decrescente.
• Exibir os dados da tabela, dos filmes cujo título comece com uma determinada letra.
• Exibir os dados da tabela, dos filmes cujo diretor termine com uma determinada letra.
• Exibir os dados da tabela, dos filmes cujo gênero tenha como segunda letra uma
determinada letra.
• Exibir os dados da tabela, dos filmes cujo título tenha como penúltima letra uma
determinada letra.
• Elimine a tabela.

Exercício 4:

No MySQL Workbench, utilizando o banco de dados ‘sprint1’:
Criar a tabela chamada Professor para conter os dados: idProfessor, nome (tamanho 50),
especialidade (tamanho 40), dtNasc (date), sendo que idProfessor é a chave primária da
tabela.
Exemplo do campo data: ‘AAAA-MM-DD’ - ‘1983-10-13’.
Inserir dados na tabela, procurando colocar uma especialista para mais de um professor.
Procure inserir pelo menos uns 6 professores.
Execute os comandos para:
a) Exibir todos os dados da tabela.
b) Exibir apenas as especialidades dos professores.
c) Exibir apenas os dados dos professores de uma determinada especialidade.
d) Exibir os dados da tabela ordenados pelo nome do professor.
e) Exibir os dados da tabela ordenados pela data de nascimento do professor em ordem
decrescente.
f) Exibir os dados da tabela, dos professores cujo nome comece com uma determinada
letra.
g) Exibir os dados da tabela, dos professores cujo nome termine com uma determinada
letra.
h) Exibir os dados da tabela, dos professores cujo nome tenha como segunda letra uma
determinada letra.
i) Exibir os dados da tabela, dos professores cujo nome tenha como penúltima letra uma
determinada letra.
j) Elimine a tabela.

Exercício 5:

No MySQL Workbench, utilizando o banco de dados ‘sprint1’:
Criar a tabela chamada Jogo para conter os dados: idJogo, nome (tamanho 50), comentario (tamanho 200), ranking (número inteiro), sendo que idJogo é a chave primária da tabela.

Inserir dados na tabela.
Procure inserir pelo menos 5 jogos.
Execute os comandos para:
a) Exibir todos os dados da tabela.
b) Exibir apenas os nomes dos jogos.
c) Exibir apenas o comentário de um determinado jogo.
d) Exibir os dados da tabela ordenados pelo nome do jogo.
e) Exibir os dados da tabela ordenados pelo ranking em ordem decrescente.
f) Exibir os dados da tabela, dos jogos cujo nome comece com uma determinada letra.
g) Exibir os dados da tabela, dos jogos cujo nome termine com uma determinada letra.
h) Exibir os dados da tabela, dos jogos cujo nome tenha como segunda letra uma determinada letra.
i) Exibir os dados da tabela, dos jogos cujo nome tenha como penúltima letra uma determinada letra.

j) Exibir os dados da tabela, dos jogos cujo nome seja diferente de Minecraft.
k) Elimine a tabela.