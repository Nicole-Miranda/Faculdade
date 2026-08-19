use projeto_individual;


create table usuario(
id_usuario int primary key auto_increment,
nome varchar (50),
email varchar(45),
senha varchar(45)
);

create table pergunta (
id_pergunta int primary key auto_increment,
pergunta varchar (200)
);

create table resposta (
id_resposta int primary key auto_increment,
fk_pergunta int, 
foreign key (fk_pergunta) references pergunta (id_pergunta),
resposta varchar(45),
valor_resposta varchar(45)
constraint ChResposta check (valor_resposta in ('Boulder','Indoor','Tradicional','Boulder Outdoor'))
);

alter table resposta modify column resposta varchar (255);

create table resultado (
id_resultado int primary key auto_increment,
fk_usuario int,
foreign key (fk_usuario) references usuario (id_usuario),
resultado varchar(45),
dt_resultado date);



create table resposta_usuario (
id_resposta_usuario int primary key auto_increment,
fk_resultado int, 
foreign key (fk_resultado) references resultado (id_resultado),
fk_resposta int,
foreign key (fk_resposta) references resposta (id_resposta)
);
select * from pergunta;

insert into usuario (nome, email, senha) values 
('Nicole Miranda', 'nicole@gmail.com','12345');

insert into pergunta (pergunta) values

('Você se sente confortavél subindo a alturas maiores de 5 metros usando cordas e equipamentos de segurança?'),

('você prefere treinar em um lugar com infraestrutura( banheiros, lanchonetes e música) em vez de ir para a natureza?'),

('Você prefere desafios curtos que exigem muita força explosiva do que subir uma parede longa que exige resistência?'),

('Você gosta da ideia de manusear muitos equipamentos tècnicos e aprender a colocar sua própria segurança na rocha?'),

('Para você cair em um colchão no chão é mais tranquilo do que ficar pendurado por uma corda no alto?'),

('você sente que a experiência só é completa se você escalar até o topo da pedra e ficar em pé em cima dela?');

-- Respostas para a Pergunta 1 (Alturas/Cordas)
insert into resposta (fk_pergunta, resposta, valor_resposta) values 
(1, 'Sim, me sinto totalmente seguro.', 'Indoor'),
(1, 'Sim, mas prefiro a rocha do que o ginásio.', 'Tradicional'),
(1, 'Não, prefiro ficar mais perto do chão.', 'Boulder'),
(1, 'Prefiro subir blocos ao ar livre.', 'Boulder Outdoor');

-- Respostas para a Pergunta 2 (Infraestrutura vs Natureza)
insert into resposta (fk_pergunta, resposta, valor_resposta) values 
(2, 'Sim, prefiro o conforto e a música.', 'Indoor'),
(2, 'Gosto de infraestrutura, mas para treinar força.', 'Boulder'),
(2, 'Não, prefiro o isolamento da montanha.', 'Tradicional'),
(2, 'Não, prefiro escalar pedras na natureza.', 'Boulder Outdoor');

-- Respostas para a Pergunta 3 (Explosão vs Resistência)
insert into resposta (fk_pergunta, resposta, valor_resposta) values 
(3, 'Com certeza, foco em força máxima.', 'Boulder'),
(3, 'Sim, se for em blocos na natureza.', 'Boulder Outdoor'),
(3, 'Não, prefiro resistência em vias guiadas.', 'Indoor'),
(3, 'Prefiro a resistência de vias longas na rocha.', 'Tradicional');

-- Respostas para a Pergunta 4 (Equipamentos Técnicos)
insert into resposta (fk_pergunta, resposta, valor_resposta) values 
(4, 'Sim, amo a complexidade técnica.', 'Tradicional'),
(4, 'Gosto de usar o básico no ginásio.', 'Indoor'),
(4, 'Não, prefiro usar apenas o magnésio e a sapatilha.', 'Boulder'),
(4, 'Não, prefiro a simplicidade do crashpad.', 'Boulder Outdoor');

-- Respostas para a Pergunta 5 (Colchão vs Corda)
insert into resposta (fk_pergunta, resposta, valor_resposta) values 
(5, 'Sim, o colchão me deixa mais livre.', 'Boulder'),
(5, 'Sim, especialmente se for o crashpad na grama.', 'Boulder Outdoor'),
(5, 'Não, confio muito mais na corda.', 'Indoor'),
(5, 'Não, a corda me traz a segurança necessária.', 'Tradicional');

-- Respostas para a Pergunta 6 (Chegar no topo/ficar em pé)
insert into resposta (fk_pergunta, resposta, valor_resposta) values 
(6, 'Sim, o cume é o objetivo final.', 'Tradicional'),
(6, 'Sim, o "top out" é a melhor parte.', 'Boulder Outdoor'),
(6, 'Não, bater no "top" do ginásio já basta.', 'Indoor'),
(6, 'Não, o foco é o movimento técnico do problema.', 'Boulder');

insert into resultado (fk_usuario, resultado, dt_resultado) 
values (1, 'Boulder', '2026-05-06');

-- Assumindo que o id_resultado gerado acima foi 1
insert into resposta_usuario (fk_resultado, fk_resposta) values 
(1, 3),  -- Resposta da Pergunta 1
(1, 6),  -- Resposta da Pergunta 2
(1, 9),  -- Resposta da Pergunta 3
(1, 15), -- Resposta da Pergunta 4
(1, 17), -- Resposta da Pergunta 5
(1, 22); -- Resposta da Pergunta 6



SELECT valor_resposta, COUNT(*) as total
FROM resposta_usuario
JOIN resposta ON fk_resposta = id_resposta
WHERE fk_resultado = 1
GROUP BY valor_resposta
ORDER BY total DESC
LIMIT 1;


