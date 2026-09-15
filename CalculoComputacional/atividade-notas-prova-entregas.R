
#Análise nota prova Ac1

df_notas <- rbind(notas)

media_notas_pratica <- mean(df_notas$Pratica)

mediana_notas_pratica <- median(df_notas$Pratica)

desvio_padrao_pratica <- sd(df_notas$Pratica)


hist(df_notas$Pratica,
     main = "Histograma de notas Pratica Sprint 1",
     xlab= "notas",
     ylab= "Quantidade Alunos",
     col = "purple",
)


#Análise entregas Sprint 1


df_notas <- rbind(notas)

todas_as_notas <- rbind(df_notas$Entrega.01,df_notas$Entrega.02,df_notas$Entrega.03)

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


media_notas_integradinha <- mean(df_notas$Integrada)

mediana_integradinha <- median(df_notas$Integrada)

desvio_integradinha <- sd(df_notas$Integrada)



#Análise por aluno


ra <- df_notas$RA


#Atividade01
hist(df_notas$Entrega.01,
     main = "Histograma notas entrega 1",
     xlab= "notas",
     ylab= "Frequencia",
     col = "purple",
)

abline(v = media_nota_entrega1, col = "darkred", lty = 2)
abline(v = mediana_entrega1, col = "darkblue", lty = 2)

plot(df_notas$Entrega.01)


#Atividade02
hist(df_notas$Entrega.02,
     main = "Histograma notas entrega 2",
     xlab= "notas",
     ylab= "Frequencia",
     col = "purple",
)

abline(v = media_nota_entrega2, col = "darkred", lty = 2)
abline(v = mediana_entrega2, col = "darkblue", lty = 2)


plot(df_notas$Entrega.02)


#Atividade03
hist(df_notas$Entrega.03,
     main = "Histograma notas entrega 3",
     xlab= "notas",
     ylab= "Frequencia",
     col = "purple",
)

abline(v = media_nota_entrega2, col = "darkred", lty = 2)
abline(v = mediana_entrega2, col = "darkblue", lty = 2)

plot(df_notas$Entrega.03)


#Integradinha
hist(df_notas$Integrada,
     main = "Histograma notas Integradinha",
     xlab = "Notas",
     ylab = "Frequencia",
     col = "purple",
     )

plot(df_notas$Integrada)



#final


media_final_entregas <- (df_notas$Entrega.01 + df_notas$Entrega.02 + df_notas$Entrega.03)/3

#Perguntas
#As notas são próximas ou apresentam muita variação?
#As notas da prova AC1 são bem proximas com pouca dispersão.

#Qual entrega apresentou maior dispersão?
#As notas da entrega 3 é a que apresenta maior dispersão

#As distribuições parecem simétricas ou assimétricas?
#As distribuições das entregas e da prova AC1 e da prova Integrada são assimétricas, entretanto o histograma 
