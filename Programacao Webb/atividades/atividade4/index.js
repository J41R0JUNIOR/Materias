const calculadora = require('./util/calculadora');
const express = require('express');
const app = express();

app.get('/', function(req, res){
    res.send('Página Inicial')
})

app.get('/somar/:a/:b', function(req, res){
    res.send('= ' + calculadora.somar(req.params.a, req.params.b));
})

app.get('/subtrair/:a/:b', function(req, res){
    res.send('= ' + calculadora.subtrair(req.params.a, req.params.b));
})

app.get('/multiplicar/:a/:b', function(req, res){
    res.send('= ' + calculadora.multiplicar(req.params.a, req.params.b));
})

app.get('/dividir/:a/:b', function(req, res){
    res.send('= ' + calculadora.dividir(req.params.a, req.params.b));
})

const PORT = 8080;

app.listen(PORT, function(){
    console.log("app rodndo na porta " + PORT);
})