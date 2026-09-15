data("mtcars")

min(mtcars$hp)
max(mtcars$)


mtcars$PotenciaOrdenada <- factor(
  cut(mtcars$hp, c(51,90,110,190,380)),
  labels = c("Muito fraco","Razoavél","Potente","Muito Potente"),
  #levels = c("Muito fraco","Razoavél","Potente","Muito Potente"),
  ordered = TRUE
)

#mpg -> quantitativa contínua
#cyl -> quantitativa discreta
#disp -> quantitativa contínua
#hp -> quantitativa discreta
#drat -> quantitativa contínua
#wt -> quantitativa contínua
#qsec -> quantitativa contínua
#vs -> qualitativa nominal
#am -> qualitativa nominal
#gear -> qualitativa nominal
#carb -> quantitativa discreta

hist(mtcars$mpg,
     main = "Consumo de combustível em milhas MPG",
     xlab = "Milhas",
     ylab = "Litros gasolina",
     col = "green"
     )

hist(mtcars$disp,
     main = "Cilindrada do motor DISP",
     xlab = "Polegadas cúbicas",
     ylab = "Cilindrada",
     col = "blue"
     )

hist(mtcars$drat,
     main = "Relação eixo traseiro DRAT",
      xlab = "Relação eixo traseiro",
      ylab = "Frequência (quantidade de carros)",
      col = "pink"
)

hist(mtcars$qsec,
     main = "histograma QSEC",
     xlab = "Tempo no 1/4 de Milhas (segundos)",
     ylab = "Frequeência (quantidade de carros)",
     col = "yellow"
     )

hist(mtcars$wt,
     main = "Histograma WT",
     xlab = "Peso do veículo (milhares de Libras)",
     ylab = "Frequência",
     col = "purple"
     )



barplot(table(mtcars$cyl), 
        main="Cilindros (cyl)", 
        col="skyblue"
        )

barplot(table(mtcars$vs), 
        main="Formato Motor (vs)", 
        col="lightgreen")

barplot(table(mtcars$am), 
        main="Transmissão (am)", 
        col="coral")

barplot(table(mtcars$gear), 
        main="Marchas (gear)", 
        col="gold")

barplot(table(mtcars$carb), 
        main="Carburadores (carb)", 
        col="pink")
