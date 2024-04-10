const express = require('express')
const estoque = require('./src/estoque')
const app = express()

const PORT = 8080
app.listen(PORT, function(){
    console.log("app rodndo na porta " + PORT);
})

app.get('/adicionar/:id/:nome/:qtd', function(req, res){
    let id = req.params.id
    let nome = req.params.nome;
    let qtd = req.params.qtd;


    let p = estoque.criarProduto(id, nome, qtd);
    estoque.setProdutos(p);
    res.send(p);
})


app.get('/listar', function(req, res){
    res.send(estoque.getProdutos());
})

app.get('/remover/:id', function(req, res){
    let id = req.params.id;
    estoque.deleteProdutos(id);
    res.send(id);
})