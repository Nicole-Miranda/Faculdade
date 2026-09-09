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

        if agora ^ ativa ^ elite ^ easynvest:
         acoes_unicas = agora ^ ativa ^ elite ^ easynvest
    print(f"A(s) ação(ões) única(s) das 4 corretoras escolhidas são: {acoes_unicas}!")
else:
    print("Não há nenhuma ação única nas 4 corretoras escolhidas.")

print(agora.issubset(ativa))
print(agora.issubset(elite))
print(agora.issubset(easynvest))
print(agora.issuperset(ativa))
print(agora.issuperset(elite))
print(agora.issuperset(easynvest))

print(ativa.issubset(agora))
print(ativa.issubset(elite))
print(ativa.issubset(easynvest))
print(ativa.issuperset(agora))
print(ativa.issuperset(elite))
print(ativa.issuperset(easynvest))

print(elite.issubset(agora))
print(elite.issubset(ativa))
print(elite.issubset(easynvest))
print(elite.issuperset(agora))
print(elite.issuperset(ativa))
print(elite.issuperset(easynvest))

print(easynvest.issubset(agora))
print(easynvest.issubset(ativa))
print(easynvest.issubset(elite))
print(easynvest.issuperset(agora))
print(easynvest.issuperset(ativa))
print(easynvest.issuperset(elite))

print("Não há subsets e nem supersets entre as 4 corretoras escolhidas.")

print(f"Ação(ões) única(s) da Easynvest: {easynvest ^ (agora.union(ativa, elite))}")
print(f"Ação(ões) única(s) da Elite: {elite ^ (agora.union(ativa, easynvest))}")
print(f"Ação(ões) única(s) da Ativa: {ativa ^ (agora.union(elite, easynvest))}")
print(f"Ação(ões) única(s) da Ágora: {agora ^ (ativa.union(elite, easynvest))}")






