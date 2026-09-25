#---------------------------------GRUPO 7--------------------

n <- 21000 #pessoas que usam 
                          
set.seed(123)

probabilidades <- numeric(80)

# PROBILIDADE DAS IDADES
# Fontes: 
probabilidades[1:17] <- 0.23 / 17
probabilidades[18:58] <- 0.62 / 41
probabilidades[59:80] <- 0.15 / 22

# SORTEANDO IDADES
taxa_idades <- sample(c(1:80), size = n, replace = TRUE, prob = probabilidades)

# SEPARANDO AS TAXAS DE IDADE
taxa_jovens <- taxa_idades[taxa_idades <= 17]
taxa_adultos <- taxa_idades[taxa_idades > 17 & taxa_idades <= 58]
taxa_idosos <- taxa_idades[taxa_idades >= 59]

# CRIANDO DATA FRAME PARA ANÁLISE
df_personas <- data.frame(
  taxa_idades
)

df_personas$faixa_etaria <- ifelse(df_personas$taxa_idades <= 17, 'Jovem', ifelse(df_personas$taxa_idades >= 59, 'Idoso', 'Adulto'))

hist(
  df_personas$taxa_idades,
  col = c('red', 'red')
)

barplot(
  table(df_personas$faixa_etaria),
  col = c('red', 'red')  
)

# ASSOCIANDO FAIXAS DE IDADE Á DOENÇAS RESPIRATÓRIAS
# Fonte: https://www.hospitalpaulista.com.br/30-da-populacao-brasileira-sofre-de-doencas-respiratorias-afirmam-especialistas-do-hospital-paulista/
df_personas$doenca_respiratoria <- sample(
  x = c('Não', 'Sim'),
  size = nrow(df_personas),
  replace = TRUE,
  prob = c(0.3, 0.7)
)

# COLOCANDO PRIORIDADE DE ACORDO COM A FAIXA ETÁRIA
# Fonte: 
df_personas$prioridade <- cut(
  x = df_personas$taxa_idades,
  breaks = c(1, 14, 24, 34, 44, 54, 64, 80),
  labels = c(1, 0, 2, 3, 4, 5, 10)
)

prioridades <- as.numeric(levels(df_personas$prioridade))[df_personas$prioridade]

df_prioridade <- data.frame(
  faixa_etaria = c('0 a 14', '15 a 24', '25 a 34', '35 a 44', '45 a 54', '55 a 64', '65 a 80'),
  total_prioridade = c(
    sum(prioridades[prioridades == 1], na.rm = TRUE),
    sum(prioridades[prioridades == 0], na.rm = TRUE),
    sum(prioridades[prioridades == 2], na.rm = TRUE),
    sum(prioridades[prioridades == 3], na.rm = TRUE),
    sum(prioridades[prioridades == 4], na.rm = TRUE),
    sum(prioridades[prioridades == 5], na.rm = TRUE),
    sum(prioridades[prioridades == 10], na.rm = TRUE)
  )
)

barplot(
  height = df_prioridade$total_prioridade,
  names.arg = df_prioridade$faixa_etaria,
  col = "steelblue",
  main = "Total de Prioridade por Faixa Etária",
  xlab = "Faixa Etária",
  ylab = "Total de Prioridade"
)

total <- sum(df_prioridade$total_prioridade)
porcentagem <- (21730 * 100) / total