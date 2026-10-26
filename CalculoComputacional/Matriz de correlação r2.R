library(ggplot2)


# Student Performance (Multiple Linear Regression) - Kaggle
# https://www.kaggle.com/datasets/nikhil7280/student-performance-multiple-linear-regression/data
# Objetivo: entender quais fatores influenciam o Índice de Performance (nota) de um aluno.


head(Student_Performance)
str(Student_Performance)

df <- na.omit(Student_Performance)

df$Boolean.Extracurricular.Activities <- ifelse(df$Extracurricular.Activities == "Yes", 1, 0)

summary(df)

matriz_cor <- cor(df[, c("Hours.Studied", "Previous.Scores",
                         "Boolean.Extracurricular.Activities", "Sleep.Hours",
                         "Sample.Question.Papers.Practiced", "Performance.Index")])
round(matriz_cor, 2)




modelo1 <- lm(Performance.Index ~ Previous.Scores, data = df)
summary(modelo1)

ggplot(df, aes(Previous.Scores, Performance.Index)) +
  geom_point(color = "black", alpha = 0.4) +
  geom_smooth(formula = y ~ x, method = "lm", color = "red", linewidth = 1.2) +
  labs(title = "Notas Anteriores x Índice de Performance",
       subtitle = "Forte relação (R² = 83.8%)",
       x = "Notas Anteriores", y = "Índice de Performance") +
  theme(plot.title = element_text(face = "bold", color = "black", hjust = 0.5),
        plot.subtitle = element_text(hjust = 0.5, color = "gray30"))

modelo2 <- lm(Performance.Index ~ Hours.Studied, data = df)
summary(modelo2)

ggplot(df, aes(Hours.Studied, Performance.Index)) +
  geom_point(color = "black", alpha = 0.4) +
  geom_smooth(formula = y ~ x, method = "lm", color = "red", linewidth = 1.2) +
  labs(title = "Horas de Estudo x Índice de Performance",
       subtitle = "Relação baixa (R² = 14.0%)",
       x = "Quantidade de Horas Estudadas", y = "Índice de Performance") +
  theme(plot.title = element_text(face = "bold", color = "black", hjust = 0.5),
        plot.subtitle = element_text(hjust = 0.5, color = "gray30"))

summary(lm(Performance.Index ~ Sleep.Hours, data = df))
summary(lm(Performance.Index ~ Sample.Question.Papers.Practiced, data = df))
summary(lm(Performance.Index ~ Boolean.Extracurricular.Activities, data = df))

modelo_multiplo <- lm(Performance.Index ~ Hours.Studied + Previous.Scores +
                        Sleep.Hours + Sample.Question.Papers.Practiced +
                        Boolean.Extracurricular.Activities, data = df)
summary(modelo_multiplo)


# EXPLICAÇÃO DOS RESULTADOS
#
# Matriz de correlação: mostra a força da relação linear entre cada par de
# variáveis (de -1 a 1). Previous.Scores tem correlação de 0.92 com a
# Performance.Index, a mais forte da base. Hours.Studied tem 0.37 (fraca/moderada).
# As demais variáveis têm correlação próxima de zero.
#
# Regressão simples (Previous.Scores): o coeficiente é cerca de 1.01, ou seja,
# a cada 1 ponto a mais na nota anterior, o índice de performance aumenta,
# em média, cerca de 1 ponto. O p-valor é muito menor que 0.05 (relação
# significativa) e o R² = 0.838: as notas anteriores explicam 83.8% da
# variação do desempenho.
#
# Regressão simples (Hours.Studied): o coeficiente é positivo (cada hora a
# mais de estudo eleva o índice em alguns pontos), com p-valor significativo,
# mas o R² = 0.140: as horas de estudo sozinhas explicam só 14% da variação.
#
# Regressão múltipla: todos os coeficientes são positivos e significativos
# (p < 0.05). O R² sobe para 0.989: juntas, as variáveis explicam 98.9% da
# variação do desempenho. O R² ajustado (Adjusted R-squared) é praticamente
# igual, o que mostra que o modelo não está inflado pelo número de variáveis.
#
# CONCLUSÃO:

# O principal indicador do desempenho de um aluno é o seu histórico (notas
# anteriores): quem foi bem tende a continuar bem. As horas de estudo, sozinhas,
# explicam pouco, mas ao combiná-las com as notas anteriores o modelo chega a
# R² de 98.9%, o que mostra que o desempenho depende do histórico somado ao
# esforço atual. Sono, simulados e atividades extras contribuem pouco,
# mas de forma positiva.
#
# Decisões possíveis: (1) identificar alunos com notas anteriores baixas e
# oferecer reforço desde o início; (2) incentivar mais horas de estudo e
# prática de simulados, já que são fatores que o aluno pode controlar;
# (3) manter hábitos saudáveis (sono), que também têm efeito positivo.
#
# Limitações: correlação não é causalidade, e a base é de apenas um conjunto
# de alunos, então os resultados podem não valer para outros contextos. 
