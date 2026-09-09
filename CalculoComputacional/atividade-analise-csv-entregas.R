df_notas <- rbind(entregas.ccoa)

todas_as_notas <- rbind(entregas.ccoa$Entrega.01,entregas.ccoa$Entrega.02,entregas.ccoa$Entrega.03)

media_nota_entrega1 <- mean(df_notas$Entrega.01)
media_nota_entrega2 <- mean(df_notas$Entrega.02)
media_nota_entrega3 <- mean(df_notas$Entrega.03)
notas_entrega01 <- df_notas$Entrega.01

mediana_entrega1 <- median(df_notas$Entrega.01)
mediana_entrega2 <- median(df_notas$Entrega.02)
mediana_entrega3 <- median(df_notas$Entrega.03)

desvio_entrega01 <- sd(df_notas$Entrega.01)
sd(df_notas$Entrega.02)
sd(df_notas$Entrega.03)


#Respostas análise descritiva:

#As notas são parecidas entre os alunos ou muito diferentes?
# As notas conforme as entregas são parecidas entre si, havendo poucas variações.

#Existe alguma entrega com maior variação de notas?
# Sim, a entrega 3 há uma grande variação de notas.

#A média representa bem os dados em todos os casos?
#Neste caso sim, as médias representaram bem com base nas notas das entregas


#O desvio padrão ajuda a entender o comportamento das notas? Como?
#Neste caso o desvio padrão ajuda a compreender qual das atividades tem um maior indice de notas acima da média

#Existe alguma evidência de distribuição normal? Justifique com base nos gráficos.


#Atividade01
hist(notas_entrega01,
     main = "Histograma notas entrega 1",
     xlab= "notas",
     ylab= "Frequencia",
     col = "purple",
)

abline(v = media_nota_entrega1, col = "darkred", lty = 2)
abline(v = mediana_entrega1, col = "darkblue", lty = 2)


#Atividade02
hist(notas_entrega02,
     main = "Histograma notas entrega 1",
     xlab= "notas",
     ylab= "Frequencia",
     col = "purple",
)

abline(v = media_nota_entrega2, col = "darkred", lty = 2)
abline(v = mediana_entrega2, col = "darkblue", lty = 2)


#Atividade03
hist(notas_entrega03,
     main = "Histograma notas entrega 1",
     xlab= "notas",
     ylab= "Frequencia",
     col = "purple",
)

abline(v = media_nota_entrega2, col = "darkred", lty = 2)
abline(v = mediana_entrega2, col = "darkblue", lty = 2)

#Comparação entre entregas

#A entrega 2 teve maior média (8.84)
#A entrega 3 possui maior desvio padrão

#A atividade 2 foi onde os alunos tiveram maior desempenho
#A atividade 3 foi onde teve maior dificuldade e desigualdade de notas

df_notas$media_geral <- rowMeans(df_notas[, c("Entrega.01", "Entrega.02", "Entrega.03")])


#Aluno com maior média:
df_notas[which.max(df_notas$media_geral),]

#Aluno com menor média:
df_notas[which.min(df_notas$media_geral),]

#Gráfico médias finais

hist(df_notas$media_geral,
     main = "Histograma médias",
     xlab= "média",
     ylab= "Frequencia",
     col = "blue"
)



