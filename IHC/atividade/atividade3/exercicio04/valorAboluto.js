function calcularValorAbsoluto() {
    var inputNumber = document.getElementById("number").value.trim(); // Remove espaços em branco do início e do fim
    var absoluteValue = Math.abs(parseFloat(inputNumber)); // Calcula o valor absoluto

    // Verifica se o valor inserido é válido antes de exibir o resultado
    if (!isNaN(absoluteValue)) {
        document.getElementById("result").innerText = "O valor absoluto é: " + absoluteValue;
    } else {
        document.getElementById("result").innerText = "Por favor, insira um número válido.";
    }
}
