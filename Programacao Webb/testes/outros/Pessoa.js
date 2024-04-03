let pessoa  = {
    nome: "Nome da Pessoa",
    cpf: 123456789,
    telefone: 61999999999
}

for(const key in pessoa){
    console.log(key + ': ' + pessoa[key]);
}

let arr = [0,1,"Dois",11,56, 60]
for(const key in arr){
    console.log(key + ' - ' + arr[key]);
}
