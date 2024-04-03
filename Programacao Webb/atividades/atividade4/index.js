const express = require('express');
const verificarNumeroPrimo = require('./util/verificarNumeroPrimo')
const app = express();

app.get('/', function(req, res){
    res.send('página inicial');
})

app.get('/ola', function(req, res){
    res.send('Olá Mundo');
})

app.get('/ola/:nome', function(req, res){
    let nome = req.params.nome
    res.send('Olá ' + nome);
})

app.get('/verificar-numero-primo/:n', function(req, res){
    let n = req.params.n;
    res.send(`O número ${n} é primo? `+ verificarNumeroPrimo.verificarNumeroPrimo(n));
  
})

const PORT = 8080;


app.listen(PORT, function(){
    console.log("app rodndo na porta " + PORT);
})