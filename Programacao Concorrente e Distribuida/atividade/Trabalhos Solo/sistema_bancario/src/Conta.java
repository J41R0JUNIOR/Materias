public class Conta {
    
    private Integer id;
    private Double saldo;

    public Conta(Integer id, Double saldo) throws Exception {
        setId(id);
        this.saldo = saldo;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer n) throws Exception{
        if(n > 0){
            this.id = n;
        }else{
            throw new Exception("ID inválido");
        }
    }

     public Double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(Double s) throws Exception{
        this.saldo = s;
    }

    public synchronized void transferir(Conta contaDestino, Double valorTransferencia) throws Exception{
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

    public static void transferir(Conta cOrigem, Conta cDestino, Double valorTransferencia) throws Exception{
        cOrigem.transferir(cDestino, valorTransferencia);
    }



    @Override
    public String toString() {
        return "{" +
            " numero='" + getId() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

}
