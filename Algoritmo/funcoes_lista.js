function adicionarNofinal(lista, elemento ){

    console.log(`FUI PRO JS - Lista: ${lista}`)
    let nova_lista = [];
    
    for(let i = 0; i < lista.length; i ++){
        nova_lista[i] = lista[i]
    }
    
    nova_lista[lista.length] = elemento;
    
    console.log(`Nova Lista: ${nova_lista}`)
    return nova_lista;
}
function removerDoFinal(lista){

    let nova_lista = [];

    for (let i = 0; i < lista.length - 1; i++) {
        nova_lista[i] = lista[i]
        }
        return nova_lista;
}

function removerPrimeiroElemento(lista){
    
    let nova_lista = [];

    for (let i = 1; i < lista.length; i++) {
         nova_lista[i - 1] = lista[i]
    }

    return nova_lista;
}

function adicionarNoInicio(lista, elemento){

    let nova_lista = []

    nova_lista[lista.length] = elemento;

    for (let i = 0; i < lista.length; i++) {
       nova_lista[i] = lista[i - 1];
    }

    return nova_lista
}