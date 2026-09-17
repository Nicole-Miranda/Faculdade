
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

amostra_peso <- rnorm(n = peso_tamanho_amostra, mean = peso_media, sd = desvio_padrao_peso)
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


#--------------------------



