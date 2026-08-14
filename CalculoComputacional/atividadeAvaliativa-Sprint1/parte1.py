#Calculadora IMC 


peso = float(input("Insira seu peso: "))
altura = float(input("Insira sua altura: "))

print(f'Seu IMC é: {round(peso/(altura**2), 2)}')
