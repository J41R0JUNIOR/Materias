// module.exports = {
//     verificarNumeroPrimo,
// }

function somar(a, b){
    a = parseFloat(a)
    b = parseFloat(b)
    return a + b
}

function subtrair(a, b){
    a = parseFloat(a)
    b = parseFloat(b)
    return a - b
}

function multiplicar(a, b){
    a = parseFloat(a)
    b = parseFloat(b)
    return a * b
}

function dividir(a, b){
    a = parseFloat(a)
    b = parseFloat(b)
    return a / b
}

module.exports = {
    somar, subtrair, multiplicar, dividir
}