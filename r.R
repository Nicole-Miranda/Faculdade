df_cliente <- data.frame(
  nome = c("bob","tom","ian","mel","dan"), #qualitativa nominal
  idade = c(20,30,25,17,50), #quantitativa dicreta,
  salario = c(3000.4,5000.1,4000.5,1500.7,8000.5), #quanti
  area = factor(
    c("humanas","exatas","biologicas","humanas","exatas"),
    labels = c("humanas","exatas","biologicas")
  ),
  plano = factor(
    c("prata","bronze","prata","ouro","bronze"),
    labels = c("prata","ouro","bronze"),
    ordered = TRUE
  )
)


df_cliente$plano
df_cliente$area


_

