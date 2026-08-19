nome = "Nicole"
sobrenome = " Miranda"
cidade = " São Paulo"
bairro = " Vila butantã"
idade = " 20"
anoNascimento = " 2006"
cadastro = nome + sobrenome + cidade + bairro + idade
print("Nome:",nome, " Sobrenome:",sobrenome, " Cidade:",cidade, " bairro:",bairro, " idade:",idade, " Ano de Nascimento:",anoNascimento)

listaNome = ["Nicole", "Miranda", "Martins"]
listaIdades = [2,15,20,30]
total = sum(listaIdades)

if nome == "Nicole":
    print(nome,":Esse é meu primero nome!.")
elif sobrenome == " Miranda":
    print(sobrenome,":Esse é meu sobrenome!")
else:
    print("Quem é você?")

for i in list(listaNome):
    print("nome que está na lista:", i)

def elogiar_nome():
    print("Lindos nomes que foram cadastrado na lista!")

elogiar_nome()

def media_idades():
    print("media idade:", total/4)

media_idades()