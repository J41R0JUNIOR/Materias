function validateCPF() {
    var cpf = document.getElementById('cpfInput').value.replace(/[^0-9]/g, ''); // Remove non-numeric characters

    if (cpf.length !== 11 || cpf === cpf[0].repeat(11)) { // Checks if the CPF has 11 digits and is not a repeated sequence
        displayResult('Invalid CPF');
        return;
    }

    // Calculate the first verification digit
    var sum = 0;
    for (var i = 0; i < 9; i++) {
        sum += parseInt(cpf[i]) * (10 - i);
    }

    var remainder = (sum * 10) % 11;
    if (remainder === 10) {
        remainder = 0;
    }
    if (remainder !== parseInt(cpf[9])) {
        displayResult('Invalid CPF');
        return;
    }

    // Calculate the second verification digit
    sum = 0;
    for (var i = 0; i < 10; i++) {
        sum += parseInt(cpf[i]) * (11 - i);
    }

    remainder = (sum * 10) % 11;
    if (remainder === 10) {
        remainder = 0;
    }
    if (remainder !== parseInt(cpf[10])) {
        displayResult('Invalid CPF');
        return;
    }

    displayResult('Valid CPF');
}

function displayResult(message) {
    var resultDiv = document.getElementById('result');
    resultDiv.textContent = message;
}
