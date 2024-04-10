var produtos = [];
function criarProduto(id, nome, qtd){
    let p = {
        id: id,
        nome: nome,
        qtd: qtd
    }
    return p
}

function getProdutos(){
    return produtos;
}

function setProdutos(p){
    produtos.push(p);
}

function deleteProdutos(id){
    produtos = produtos.filter((p) => {
        return p.id != id
    });
}

module.exports = {
    criarProduto,setProdutos,getProdutos,deleteProdutos,
};