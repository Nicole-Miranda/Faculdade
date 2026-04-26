function calcular_media(lista){
    let soma = 0
    for (let i = 0; i < lista.length; i++) {
        soma += lista[i]
    }
    let media = soma / lista.length;

    return media;
}