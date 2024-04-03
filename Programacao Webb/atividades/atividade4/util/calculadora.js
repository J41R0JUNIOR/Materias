// module.exports = {
//     verificarNumeroPrimo,
// }

function somar(a, b){
    a = parseInt(a)
    b = parseInt(b)
    return a + b
}

function subtrair(a, b){
    a = parseInt(a)
    b = parseInt(b)
    return a - b
}

function multiplicar(a, b){
    a = parseInt(a)
    b = parseInt(b)
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