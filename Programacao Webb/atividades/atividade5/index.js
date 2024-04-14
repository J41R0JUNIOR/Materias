const express = require('express');
const app = express();
const PORT = 8080;
const estoque = require("./src/estoque")

app.listen(PORT, function(){
    console.log("App running at port " + PORT);
});

app.get("/", function(req, res){
    res.send("Home Page");
})

app.get("/adicionar/:id/:name/:qtd", function(req, res){
    let product = estoque.createProduct(req.params.id, req.params.name, req.params.qtd);
    estoque.setProducts(product);
    res.send("opa")
})

app.get("/listar", function(req, res){
    res.send(estoque.getProducts());
})

app.get("/remover/:id", function(req, res){
    estoque.removeProduct(req.params.id);
    res.send(estoque.getProducts());
})

app.get("/editar/:id/:qtd", function(req, res){
    estoque.editProduct(req.params.id, req.params.qtd);
    res.send(estoque.getProducts());
})