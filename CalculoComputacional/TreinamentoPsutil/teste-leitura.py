import csv
import psutil
import time
from datetime import datetime

with open('./teste-coleta.csv', 'r', newline='') as csvfille:
    leitor = csv.reader(csvfille)

    for linha in leitor:
           
     with open('./teste-leitura.csv', 'a', newline='') as csvfile:
                csv.writer(csvfile, delimiter=',').writerow(linha)
        
                print(linha)