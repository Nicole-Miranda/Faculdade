import psutil
import csv
import time
from datetime import datetime

with open('./teste-coleta.csv', 'w', newline='') as csvfile:
    csv.writer(csvfile, delimiter=',').writerow(['timestamp', 'cpu', 'ram', 'disco'])


print("Iniciando a captura a cada 10 segundos.")
   
while True:  
    agora = datetime.now()
    agora_formatado = agora.strftime("%Y-%m-%d %H:%M:%S")

    cpu_p = psutil.cpu_percent(interval=1)
    memoria = psutil.virtual_memory().percent
    disco = psutil.disk_usage('/').percent


    print(agora_formatado)
    print("Uso da CPU", cpu_p)
    print("Uso memória RAM", memoria)
    print("Uso do disco", disco)

    with open('./teste-coleta.csv', 'a', newline='') as csvfile:
        csv.writer(csvfile, delimiter=',').writerow([agora_formatado, cpu_p, memoria, disco])


    time.sleep(9)