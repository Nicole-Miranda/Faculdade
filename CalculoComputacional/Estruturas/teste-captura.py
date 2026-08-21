import psutil
import csv
import time

time.sleep(2)
with open('./teste.csv', 'w') as csvfile:
    csv.writer(csvfile, delimiter=',').writerow(['João','30'])
    csv.writer(csvfile,  delimiter=',').writerow(['Nicole','40'])
    csv.writer(csvfile,  delimiter=',').writerow(['Miranda','30'])

with open('./teste.csv', 'r') as csvfile:
    reader = csv.reader(csvfile)
    for x in reader:
        print(x)


cpu_p = (psutil.cpu_percent(interval=1))
print("Valor em porcentagem de uso da CPU:", cpu_p)
testando = psutil.cpu_times(percpu=False)
print(testando)

teste = psutil. disk_partitions (all = False)
print(teste)
#teste2 = psutil.virtual_ memory()
