public class Conta {
    private String nome;
    private Double saldo;

    public Conta(Double saldo, String nome) throws Exception {
        this.saldo = saldo;
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getNome(){ return nome; }

    public void depositar(Double valor){
        this.saldo += valor;
    }

    public void debitar(Double valor){
        this.saldo -= valor;
    }
}
