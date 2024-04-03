const MatrizTransposta = require('./MatrizTransposta');
const express = require('express');
const app = express();

const PORT = 8080;

app.get('/ola', function(req, res){
     // res.send("ola mundo!");
     res.send(M);
});

app.listen(PORT, function(){
     console.log('app rodando na porta' + PORT);
});

const M = [
    [0, 1, 2, 2],
    [3, 4, 0, 9],
    [5, 3, 4, 3]
];

MatrizTransposta.transporMatriz(M);
console.log("\n")
console.log("Print")
MatrizTransposta.print(M, 3);

