arquivos <- c("bia-sistema(in).csv", "enzo-sistema(in).csv", "gus-sistema(in).csv",
              "lucas-sistema(in).csv", "nicole_sistema(in).csv", "pedro-sistema(in).csv")
nomes <- c("bia", "enzo", "gus", "lucas", "nicole", "pedro")

dados <- data.frame()
for (i in 1:6) {
  d <- read.csv2(arquivos[i])
  d$maquina <- nomes[i]
  d$cpu_percent <- as.numeric(d$cpu_percent)
  d$ram_percent <- as.numeric(d$ram_percent)
  dados <- rbind(dados, d[, c("maquina", "cpu_percent", "ram_percent")])
}

cairo_pdf("boxplots_metricas.pdf", width = 10, height = 7, onefile = TRUE)

boxplot(cpu_percent ~ maquina, data = dados,
        main = "Uso de CPU (%) por máquina",
        xlab = "Máquina", ylab = "CPU (%)",
        ylim = c(0, 100), col = "lightblue")
abline(h = 80, lty = 2, col = "red")

# ANÁLISE DO GRÁFICO 1 (CPU):
# - "pedro" é a única máquina com CPU realmente alta: mediana de ~34%, caixa muito larga
#   (metade dos registros entre ~15% e ~56%) e máximo de 99,7%. Teve 23 registros acima
#   de 80%. A caixa larga mostra que a carga oscila muito, com picos frequentes.
# - "bia" vem em seguida (mediana ~15,5%, pico de ~53%), mas nunca chegou perto de 80%.
# - "nicole" (~6%), "enzo" (~3%) e "gus" (~3%) trabalham com folga.
# - "lucas" tem a menor mediana (~1%), mas muitos pontos acima da caixa (picos de até
#   ~40%): máquina quase parada, com picos curtos e esporádicos.
# - Atenção: cada máquina tem uma quantidade diferente de registros (de 45 a 361) e
#   períodos diferentes, então o gráfico mostra o perfil de cada uma, não um ranking.

boxplot(ram_percent ~ maquina, data = dados,
        main = "Uso de RAM (%) por máquina",
        xlab = "Máquina", ylab = "RAM (%)",
        ylim = c(0, 100), col = "lightgreen")
abline(h = 85, lty = 2, col = "red")

# ANÁLISE DO GRÁFICO 2 (RAM):
# - "bia" é o caso mais crítico: mediana de ~90,5% e caixa muito estreita, ou seja, a
#   RAM (~8 GB) fica quase saturada o tempo todo, e não só em picos. Todos os registros
#   ficaram acima de 85% e ela ainda usou ~12% de swap, o que tende a deixá-la lenta.
# - "pedro" e "nicole" ficam perto de 78-79%. Em "pedro" a caixa é mais larga e chegou a
#   ~88%, com swap médio de ~73%, mostrando pressão real de memória. Junto com a CPU
#   alta do gráfico 1, é a máquina que mais precisa de atenção.
# - "nicole" é alta (~78%) mas estável, com swap de ~14%: não é crítica, mas tem pouca
#   margem para crescer.
# - "gus" (~41%), "lucas" (~27%) e "enzo" (~24%) têm bastante folga. Em "gus" há pontos
#   bem abaixo da caixa (até ~19%): o uso caiu em parte do período.
# - Conclusão: CPU e RAM não andam juntas. "bia" tem CPU tranquila e RAM no limite;
#   "pedro" tem os dois recursos pressionados; as demais estão saudáveis.

dev.off()
