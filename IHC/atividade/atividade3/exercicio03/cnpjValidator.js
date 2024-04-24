function validarCNPJ() {
    var cnpj = document.getElementById('cnpjInput').value.replace(/[^0-9]/g, ''); // Remove caracteres não numéricos

    if (!cnpj || cnpj.length !== 14 || cnpj === cnpj[0].repeat(14)) { // Verifica se o CNPJ está vazio, tem 14 dígitos e se não é uma sequência repetida
        exibirResultado('CNPJ inválido');
        return;
    }

    var digitoVerificador = calcularDigitoVerificador(cnpj, 12, 5);
    if (digitoVerificador !== parseInt(cnpj[12])) {
        exibirResultado('CNPJ inválido');
        return;
    }

    digitoVerificador = calcularDigitoVerificador(cnpj, 13, 6);
    if (digitoVerificador !== parseInt(cnpj[13])) {
        exibirResultado('CNPJ inválido');
        return;
    }

    exibirResultado('CNPJ válido');
}

function calcularDigitoVerificador(cnpj, posicaoDigito, pesoInicial) {
    var soma = 0;
    var peso = pesoInicial;
    for (var i = 0; i < posicaoDigito; i++) {
        soma += parseInt(cnpj[i]) * peso;
        peso = (peso === 2) ? 9 : peso - 1;
    }

    var digitoVerificador = 11 - (soma % 11);
    return (digitoVerificador > 9) ? 0 : digitoVerificador;
}

function exibirResultado(mensagem) {
    var resultadoDiv = document.getElementById('resultado');
    resultadoDiv.textContent = mensagem;
}
