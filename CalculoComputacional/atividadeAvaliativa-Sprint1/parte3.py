
peso = float(input("Insira seu peso: "))
altura = float(input("Insira sua altura: "))
imc = (round (peso/(altura**2), 2))


if imc < 18.5:
    print(f'Seu IMC é {imc} - Abaixo do peso normal')
elif imc <= 24.9:
    print(f'Seu IMC é {imc} - Peso normal')
elif imc <= 29.9:   
    print(f'Seu IMC é {imc} - Excesso de peso')
elif imc <= 34.9:
    print(f'Seu IMC é {imc} - Obesidade classe I')
elif imc <= 39.9:
    print(f'Seu IMC é {imc} - Obesidade classe II')
elif imc >= 40:
    print(f'Seu IMC é {imc} - Obesidade classe III')




while True:

    outraPessoa = input('Deseja calcular o IMC de outra pessoa? (s/n)')

    if outraPessoa == 's':
        peso = float(input("Insira seu peso: "))
        altura = float(input("Insira sua altura: "))
        imc = (round (peso/(altura**2), 2))

        if imc < 18.5:
            print(f'Seu IMC é {imc} - Abaixo do peso normal')
        elif imc <= 24.9:
            print(f'Seu IMC é {imc} - Peso normal')
        elif imc <= 29.9:   
            print(f'Seu IMC é {imc} - Excesso de peso')
        elif imc <= 34.9:
            print(f'Seu IMC é {imc} - Obesidade classe I')
        elif imc <= 39.9:
            print(f'Seu IMC é {imc} - Obesidade classe II')
        elif imc >= 40:
            print(f'Seu IMC é {imc} - Obesidade classe III')
    else:
        print('Encerrando calculadora...')
        break

