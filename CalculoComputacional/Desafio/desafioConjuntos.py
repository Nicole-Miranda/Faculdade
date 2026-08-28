import csv

# 1. Crie os portfólios para cada corretora
agora = set()
ativa = set()
genial = set()
easynvest = set()
elite = set()
guide = set()
nova_futura = set()
orama = set()

with open('./Desafio/dados.csv', newline='', encoding="UTF-8") as f:
    leitor = csv.reader(f, delimiter=';')

    next(leitor, None)

    for linha in leitor:

        if len(linha) > 1:



            if linha[0] == 'Àgora':
                agora.add(linha[2])

            elif linha[0] == 'Ativa':
                ativa.add(linha[2])

            elif linha[0] == 'Genial':
                genial.add(linha[2])

            elif linha[0] == 'Easynvest':
                easynvest.add(linha[2])

            elif linha[0] == 'Elite':
                elite.add(linha[2])

            elif linha[0] == 'Guide':
                guide.add(linha[2])

            elif linha[0] == 'Nova Futura':
                nova_futura.add(linha[2])

            else:
                orama.add(linha[2])

acoesEmComum = easynvest.intersection(elite)
print("Açoes em comum entre Easynvest e Elite", acoesEmComum)     

acoesComum = guide.intersection(nova_futura)
print("Acoes "acoesComum)


corretoras_dict = {
    'Àgora': agora,
    'Ativa': ativa,
    'Genial': genial,
    'Easynvest': easynvest,
    'Elite': elite,
    'Guide': guide,
    'Nova Futura': nova_futura,
    'Orama': orama,
}

for nome, conjunto in corretoras_dict.items():
    outras = set()
    for outro_nome, outro_conjunto in corretoras_dict.items():
        if outro_nome != nome:
            outras |= outro_conjunto  

    unicas = conjunto - outras

    if unicas:
        print(f'{nome} tem ações únicas: {unicas}')
    else:
        print(f'{nome} não tem ações exclusivas.')






