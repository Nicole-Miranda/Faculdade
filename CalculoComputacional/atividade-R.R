#lista_tabelasGrupo <- list(dados,dadosenzo,dadosLucas,dadosGus)

#Unificando os dados do grupo5
df_grupo5 <- rbind(dados,dadosenzo,dadosGus,dadosLucas,dadosBia)


#média de uso de todos de CPU
mean(df_grupo5$CPU..percent.)

#média de consumo de um dos componentes de cada integrande
df_media <- aggregate(CPU..percent. ~ usuario, data = df_grupo5, FUN = mean)

#Maior media (usuário)
maior_consumo <- df_media[which.max(df_media$CPU..percent.),]

#Menor consumo (usuário)
menor_consumo <- df_media[which.min(df_media$CPU..percent.),]

#hist(main = "Histograma da média do uso CPU", maior_consumo$CPU..percent., ylab ="instancias",
     xlab = "% do uso", col="green")


barplot(
  height = df_media$CPU..percent.,
  names.arg = df_media$usuario,
  main = "Histograma média de uso de CPU",
  xlab = "Usuário",
  ylab = "CPU (%)",
  col = "purple"
  )

#plot com cor

plot(df_grupo5$CPU..percent., df_grupo5$RAM..percent.,
     xlab = "CPU(%)",
     ylab = "RAM(%)",
     col = as.factor(df_grupo5$usuario)
     )


