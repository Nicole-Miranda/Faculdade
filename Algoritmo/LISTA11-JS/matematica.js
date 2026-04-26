function somar(numero1, numero2) {

    let soma = 0;
  
    
    if(numero1 < 0 || numero2 < 0){
        console.log(`Parâmetros ${numero1} e ${numero2} não pode ser nulo ou indefinido  `)
       
    }else if(numero1 != Number(numero1) || numero2 != Number(numero2)){
        console.log(`Tipo inválido para o argumento ${numero1} e ${numero2}`)
       
    }else{
        soma += numero1 + numero2
    }
    return soma 
}

function calcularDistancia (x1,x2,y1,y2){
   

    if(x1 < 0 || x2 < 0  || (y1 < 0 || y2 < 0)){
        console.log(`Parâmetro ${x1,x2,y1,y2} não pode ser nulo ou indefino`)
    }else if(x1 != Number(x1))
}