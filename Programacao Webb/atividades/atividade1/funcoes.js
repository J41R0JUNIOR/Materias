function imprimirOperacao(a, b, op){

    let c;

    switch(op){
        case '+':
            c = a + b
            break;
        case '-':
            c = a - b
            break;
        case '*':
            c = a * b
            break;
        case '/':
            c = a / b
            break;
    }
    console.log(`O resultado de ${a} ${op} ${b} = ${c}`)
}

imprimirOperacao(1, 2, '+')