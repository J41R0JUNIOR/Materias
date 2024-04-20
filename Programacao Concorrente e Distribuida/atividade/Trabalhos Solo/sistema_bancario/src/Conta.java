public class Conta {
    
    private Integer numero;
    private Double saldo;

    public ContaCorrente(Integer numero, Double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero(){
        return this.numero;
    }

    public void setNumero(Integer n) throws Exception{
        if(n > 0){
            this.numero = n;
        }else{
            throw new Exception("Número inválido");
        }
    }

     public Double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(Double s) throws Exception{
        this.saldo = s;
    }

    public void transferir(ContaCorrente contaDestino, Double valorTransferencia) throws Exception{
        if(getSaldo() >= valorTransferencia){
            this.saldo = getSaldo() - valorTransferencia;
            contaDestino.depositar(valorTransferencia);
        }
    }

    public void depositar(Double valorDeposito) throws Exception{
        if (valorDeposito > 0) {
            this.saldo = getSaldo() + valorDeposito;
        }else{
            throw new Exception("Valor de saldo inválido!");
        }
    }

    public static void transferir(ContaCorrente cOrigem, ContaCorrente cDestino, Double valorTransferencia) throws Exception{
        cOrigem.transferir(cDestino, valorTransferencia);
    }



    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

}
