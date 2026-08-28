#primeiro dataframe em R

df_teste <- data.frame(
  nome = c("Tom","bob","mel","ana","dan"),
  idade = c (20,54,81,21,61),
  salario = c(1000.1,1400.7,1050.7,1800.3,50000.2)
)

#primero registros
head(df_teste)

#linahs e colunas
dim(df_teste)

#acessando colunas com $
df_teste$idade
df_teste$salario
df_teste$nome


#Cuidado! Mèdia e Mediana
mean(df_teste$salario) #mèdia
median(df_teste$salario)#mediana

#acesso linha e coluna
#df[linha,coluna]
df_teste[2,2]
df_teste[2,]
df_teste[,2]
df_teste[df_teste$idade>30,]

min(df_teste$idade)
max(df_teste$idade)

summary(df_teste)
df_teste$ganha_bem <- "sim"
df_teste$ganha_bem <- df_teste$salario > 1500
df_teste$ganha_bem <- ifelse(df_teste$salario > 1500, "MUITO BOM", "GANHA POUCO")


#df_teste$empresa <- c("A", "B", "C","E")


#df_teste$ganha_bem <- NULL

# remover: rm