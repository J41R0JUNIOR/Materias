function verificarNumeroPrimo(n){
    
    let qtd = 0

    for (let i = 0; i <= n; i++) {
            if(i > 2){
                console.log('opa')
                break;
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
console.log(verificarNumeroPrimo(0)); // false
console.log(verificarNumeroPrimo(1)); // false
console.log(verificarNumeroPrimo(2)); // true
console.log(verificarNumeroPrimo(3)); // true
console.log(verificarNumeroPrimo(7)); // true
console.log(verificarNumeroPrimo(83)); // true
console.log(verificarNumeroPrimo(100)); // false
console.log(verificarNumeroPrimo(991)); // true
console.log(verificarNumeroPrimo(104729)); // true
console.log(verificarNumeroPrimo(14348907)); // false
