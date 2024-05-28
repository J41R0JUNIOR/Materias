exports.calcular = (num1, num2, operacao) => {
    let resultado;
    switch (operacao) {
        case '+':
            resultado = num1 + num2;
            break;
        case '-':
            resultado = num1 - num2;
            break;
        case '*':
            resultado = num1 * num2;
            break;
        case '/':
            resultado = num1 / num2;
            break;
        default:
            throw new Error('Operação inválida');
    }
    return resultado;
};
