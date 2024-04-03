function verificarNumeroPrimo(n){
    let qtd = 0

    for (let i = 0; i <=  n; i++) {
        if(i > 2){
            return false
            // break;
        }else if(n % i == 0){
            qtd += 1
        }  
    }

    if(qtd <= 2 && n != 1 && n != 0){
       return true
    }else{
        return false
    }
}

module.exports = {
    verificarNumeroPrimo,
}