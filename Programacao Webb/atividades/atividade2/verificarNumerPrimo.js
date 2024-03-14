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
       console.log(`${n} é primo ? true`)
    }else{
        console.log(`${n} é primo ? false`)
    }
}

verificarNumeroPrimo(0); //false
verificarNumeroPrimo(1); //false
verificarNumeroPrimo(2); //true
verificarNumeroPrimo(3); //true
verificarNumeroPrimo(7); //true
verificarNumeroPrimo(83); //true
verificarNumeroPrimo(100); //false
verificarNumeroPrimo(991); //true
verificarNumeroPrimo(104729); //true
verificarNumeroPrimo(14348907); //false