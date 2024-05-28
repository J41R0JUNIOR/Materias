const calculadora = require('../calculadora/calculadora');

exports.renderIndex = (req, res) => {
    res.render('index.html');
};

exports.calcular = (req, res) => {
    const { fNumber, sNumber, operacao } = req.body;

    if (isNaN(fNumber) || isNaN(sNumber)) {
        res.render('index.html', { errorMessage: 'Valores inválidos. Por favor, insira números válidos.' });
    } else {
        const resultado = calculadora.calcular(Number(fNumber), Number(sNumber), operacao);
        res.render('resultado.html', { fNumber, sNumber, result: resultado });
    }
};
