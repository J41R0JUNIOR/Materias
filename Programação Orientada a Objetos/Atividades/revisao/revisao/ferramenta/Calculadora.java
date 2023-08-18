package revisao.ferramenta;

public class Calculadora {

    public int a,b;
    private String operador;
    

    public String getOperador(){
        return this.operador;
    }

    public void setOperador(String op) throws Exception{
        Boolean erro = true;

        switch (op) {
            case "+":
                erro = false;
                break;
            case "-":
                erro = false;
                break;
            case "*":
                erro = false;
                break;
            case "/":
                erro = false;
                break;
            default:
            erro = true;
                break;
        }

        if(erro){
            throw new Exception("Operador Inválido!");
        }
        this.operador = op;
    }

    public int operar(){

        int ret = 0;

        switch (this.operador) {
            case "+":
                ret = this.a + this.b;
                break;
            case "-":
                ret = this.a - this.b;
                break;
            case "*":
                ret = this.a * this.b;
                break;
            case "/":
                ret = this.a / this.b;
                break;
            default:
                break;
        }
        return ret;
    }
    

}
