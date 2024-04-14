var products = [];

function createProduct(id, name, qtd){
    let product = {
        id: id,
        name: name,
        qtd: qtd
    }
    return product
}

function getProducts(){
    return products;
}

function setProducts(product){
    products.push(product);
}

function removeProduct(id){
    products = products.filter(function(products){
        return products.id != id;
    })
}

function editProduct(id, qtd){
   products.forEach(value => {
        if(value.id == id){
            value.qtd = qtd
        }
   });
}

module.exports = {
    createProduct, getProducts, setProducts, removeProduct, editProduct
}