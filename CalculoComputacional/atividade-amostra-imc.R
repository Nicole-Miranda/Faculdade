
#--------------------------------IMC BASEADO EM DADOS BRASILEIROS-------------------------------------

media_imc <- 26.5
desvio_padrao_imc <- 4.5
tamanho_amostra <- 100

amostra_imc <- rnorm(n = tamanho_amostra, mean = media_imc, sd = desvio_padrao_imc)
head(amostra_imc)

hist(amostra_imc, 
     main = "Distribuição do IMC",
     xlab = "IMC (kg/m²)", 
     ylab = "Frequência", 
     col = "lightblue", 
     border = "white",
     breaks = 20) 

abline(v = media_imc, col = "red", lwd = 2, lty = 2)
set.seed(42)

data_frame_imc <- data.frame(
  main = "IMC baseados em dados dos brasileiros",
  amostra_imc,
  media_imc,
  desvio_padrao_imc
)



#----------------------------------------IDADE DE PESSOAS QUE TRABALHAM  ÀREA DE TECNOLOGIA---------------------------------------------------
  
idade_tamanho_amostra <- 200
idade_media <- 28
desvio_padrao_idade <- 7


amostra_idade <- round(rnorm(n = idade_tamanho_amostra, mean = idade_media, sd = desvio_padrao_idade)
head(amostra_idade)


hist(amostra_idade, 
     main = "Idade de pessoas na área de tecnologia",
     xlab = "Idade", 
     ylab = "Frequência(quantidade)", 
     col = "orange", 
     border = "white",
     breaks = 20) 

abline(v = idade_media, col = "red", lwd = 2, lty = 2)
set.seed(42)

data_frame_idade <- data.frame(
  main = "Idade de pessoas que trabalham na área de tecnologia",
  amostra_idade,
  idade_media,
  desvio_padrao_idade
)


#------------------------------------------ALTURA DE PESSOAS QUE FAZEM GINÁSTICA ARTÍSTICA-------------------------------------

altura_tamanho_amostra <- 200
altura_media <- 155
desvio_padrao_altura <- 5

amostra_altura <- rnorm(n = altura_tamanho_amostra, mean = altura_media, sd = desvio_padrao_altura)
head(amostra_idade)

hist(amostra_altura, 
     main = "Altura das pessoas que fazem ginástica artística",
     xlab = "Altura", 
     ylab = "Frequência(quantidade)", 
     col = "green", 
     border = "white",
     breaks = 20)

abline(v = altura_media, col = "red", lwd = 2, lty = 2)
set.seed(123)

data_frame_altura <- data.frame(
  main = "Altura de pessoas que fazem ginástica artística",
  amostra_altura,
  altura_media,
  desvio_padrao_altura
)


#----------------------------------------- PESO DE BEBÉS QUE NASCEM NA INDIA ---------------------------

peso_tamanho_amostra <- 200
peso_media <- 2.8
desvio_padrao_peso <- 0.42

amostra_idade <- round(rnorm(n = idade_tamanho_amostra, mean = idade_media, sd = desvio_padrao_idade))
head(amostra_peso)

hist(amostra_peso, 
     main = "Pesos dos bebès que nascem na India",
     xlab = "Peso", 
     ylab = "Frequência(quantidade)", 
     col = "purple", 
     border = "white",
     breaks = 20)

abline(v = peso_media, col = "red", lwd = 2, lty = 2)
set.seed(123)

data_frame_peso <- data.frame(
  main = "Peso de bebès que nascem na India",
  amostra_peso,
  peso_media,
  desvio_padrao_peso
)


#--------------------------------SEXO DOS PARTICIPANTES DA MARATONA DE SAO PAULO-------------------------------------

sexo_tamanho_amostra <- 200
set.seed(11)
amostra_sexo <- sample(x = c(1, 2), size = sexo_tamanho_amostra, replace = TRUE, prob = c(0.55, 0.45))
amostra_sexo <- factor(amostra_sexo, levels = c(1, 2), labels = c("Masculino", "Feminino"))
head(amostra_sexo)

barplot(table(amostra_sexo),
        main = "Sexo dos participantes da maratona de Sao Paulo",
        xlab = "Sexo",
        ylab = "Frequencia",
        col = c("steelblue", "salmon"),
        border = "white")

data_frame_sexo <- data.frame(
  main = "Sexo dos participantes da maratona de Sao Paulo",
  amostra_sexo
)


#----------------------------------------ESCOLARIDADE DE TRABALHADORES DE UMA FABRICA TEXTIL---------------------------------------

escolaridade_tamanho_amostra <- 200
set.seed(22)
amostra_escolaridade <- sample(x = 0:6, size = escolaridade_tamanho_amostra, replace = TRUE,
                               prob = c(0.05, 0.15, 0.30, 0.30, 0.12, 0.06, 0.02))
amostra_escolaridade <- factor(amostra_escolaridade, levels = 0:6, ordered = TRUE,
                               labels = c("Analfabeto", "1 grau completo", "2 grau completo",
                                          "3 grau completo", "Mestrado", "Doutorado", "Pos-doutorado"))
head(amostra_escolaridade)

barplot(table(amostra_escolaridade),
        main = "Escolaridade de trabalhadores de uma fabrica textil",
        xlab = "Escolaridade",
        ylab = "Frequencia(quantidade)",
        col = "darkgoldenrod2",
        border = "white",
        las = 2,
        cex.names = 0.7)

data_frame_escolaridade <- data.frame(
  main = "Escolaridade de trabalhadores de uma fabrica textil",
  amostra_escolaridade
)


#------------------------------------------AREA DE FORMACAO DE ALUNOS DE POS-GRADUACAO-------------------------

profissao_tamanho_amostra <- 200
set.seed(33)
amostra_profissao <- sample(x = c(1, 2, 3), size = profissao_tamanho_amostra, replace = TRUE,
                            prob = c(0.40, 0.35, 0.25))
amostra_profissao <- factor(amostra_profissao, levels = c(1, 2, 3), labels = c("Humanas", "Exatas", "Biologicas"))
head(amostra_profissao)

barplot(table(amostra_profissao),
        main = "Area de formacao de alunos de pos-graduacao",
        xlab = "Area",
        ylab = "Frequencia(quantidade)",
        col = "mediumseagreen",
        border = "white")

data_frame_profissao <- data.frame(
  main = "Area de formacao de alunos de pos-graduacao",
  amostra_profissao
)


#----------------------------------------- TABAGISMO ENTRE MOTORISTAS DE CAMINHAO DE LONGA DISTANCIA ---------------------

fumante_tamanho_amostra <- 200
set.seed(44)
amostra_fumante <- sample(x = c(0, 1), size = fumante_tamanho_amostra, replace = TRUE, prob = c(0.68, 0.32))
amostra_fumante <- factor(amostra_fumante, levels = c(0, 1), ordered = TRUE, labels = c("Nao", "Sim"))
head(amostra_fumante)

barplot(table(amostra_fumante),
        main = "Tabagismo entre motoristas de caminhao de longa distancia",
        xlab = "Fumante",
        ylab = "Frequencia(quantidade)",
        col = c("gray70", "firebrick"),
        border = "white")

data_frame_fumante <- data.frame(
  main = "Tabagismo entre motoristas de caminhao de longa distancia",
  amostra_fumante
)


#----------------------------------------- SALARIO DE DESENVOLVEDORES JUNIOR NO BRASIL ------------

salario_tamanho_amostra <- 200
salario_media <- 4200
desvio_padrao_salario <- 900

set.seed(55)
amostra_salario <- rnorm(n = salario_tamanho_amostra, mean = salario_media, sd = desvio_padrao_salario)
head(amostra_salario)

hist(amostra_salario,
     main = "Salario de desenvolvedores junior no Brasil",
     xlab = "Salario (R$)",
     ylab = "Frequencia",
     col = "cornflowerblue",
     border = "white",
     breaks = 20)

abline(v = salario_media, col = "red", lwd = 2, lty = 2)

data_frame_salario <- data.frame(
  main = "Salario de desenvolvedores junior no Brasil",
  amostra_salario,
  salario_media,
  desvio_padrao_salario
)


#------------------------------------- NUMERO DE CARROS POR FAMILIA EM CONDOMINIO DE ALTO PADRAO ---------------------------

carros_tamanho_amostra <- 200
carros_media <- 2.3

set.seed(66)
amostra_carros <- rpois(n = carros_tamanho_amostra, lambda = carros_media)
head(amostra_carros)

hist(amostra_carros,
     main = "Numero de carros por familia em condominio de alto padrao",
     xlab = "Numero de carros",
     ylab = "Frequencia(quantidade)",
     col = "slateblue",
     border = "white",
     breaks = seq(min(amostra_carros) - 0.5, max(amostra_carros) + 0.5, by = 1))

abline(v = carros_media, col = "red", lwd = 2, lty = 2)

data_frame_carros <- data.frame(
  main = "Numero de carros por familia em condominio de alto padrao",
  amostra_carros,
  carros_media
)


#------------------------------- NUMERO DE FILHOS EM FAMILIAS RURAIS DO NORDESTE ---------------------------

filhos_tamanho_amostra <- 200
filhos_media <- 3.1

set.seed(77)
amostra_filhos <- rpois(n = filhos_tamanho_amostra, lambda = filhos_media)
head(amostra_filhos)

hist(amostra_filhos,
     main = "Numero de filhos em familias rurais do Nordeste",
     xlab = "Numero de filhos",
     ylab = "Frequencia(quantidade)",
     col = "chocolate",
     border = "white",
     breaks = seq(min(amostra_filhos) - 0.5, max(amostra_filhos) + 0.5, by = 1))

abline(v = filhos_media, col = "red", lwd = 2, lty = 2)

data_frame_filhos <- data.frame(
  main = "Numero de filhos em familias rurais do Nordeste",
  amostra_filhos,
  filhos_media
)



