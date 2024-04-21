public class Conta {
    private Double saldo;

    public Conta(Double saldo) throws Exception {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor){
        this.saldo += valor;
    }

    public void debitar(Double valor){
        this.saldo -= valor;
    }
}
