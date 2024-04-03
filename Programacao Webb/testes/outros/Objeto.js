let calculadora = {
    numeroA: 0,
    numeroB: 0,
    somar: function(){
        return this.numeroA + this.numeroB
    },
    subtrair: function(){
        return this.numeroA - this.numeroB
    }
};

calculadora.numeroA = 2;
calculadora.numeroB = 3;

console.log(calculadora.somar())
console.log(calculadora.subtrair())