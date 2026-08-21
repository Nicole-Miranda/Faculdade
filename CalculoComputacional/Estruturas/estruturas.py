#lista: È mutável, é ordenada, é indexada (0...n)
lista = [10,20,30]
lista[0] = 11

#tupla: È imutável, é ordenada, é indexada (0..n)
tupla = (10,20,30)
#tupla[0] = 11 Não pode
tuplaA = (10,20,30)
tuplaB = (40,50,60)
tuplaA = tuplaB #Pode


#Dicionário: é mutavél, é ordenado a partir da v3.7.x, é acessando por chave
dicionario = {"num1" : 10, "num2": 20, "num3":30}
d = [[10,20,30],
     [40,50,60],
     [70,80,90]]

print(type(lista))
print(type(tupla))
print(type(dicionario))
print(type(d))

