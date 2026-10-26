install.packages("tidyverse")
install.packages("ggplot2")
library(ggplot2)

library(tidyverse)


dados <- read_csv("insurance.csv")
head(dados)
str(dados)
summary(dados)


dados <- na.omit(dados)       
dados <- unique(dados)       
dados$sex <- as.factor(dados$sex)
dados$smoker <- as.factor(dados$smoker)
dados$region <- as.factor(dados$region)


dados_final <- dados


ggplot(dados_final, aes(x = charges)) +
  geom_histogram(bins = 30, fill = "steelblue", color = "white") +
  labs(title = "Distribuição dos custos")

ggplot(dados_final, aes(x = smoker, y = charges)) +
  geom_boxplot(fill = "orange") +
  labs(title = "Custo por fumante")

ggplot(dados_final, aes(x = age, y = charges)) +
  geom_point(alpha = 0.5) +
  geom_smooth(method = "lm", color = "red") +
  labs(title = "Idade x Custo")


modelo <- lm(charges ~ age, data = dados_final)
summary(modelo)