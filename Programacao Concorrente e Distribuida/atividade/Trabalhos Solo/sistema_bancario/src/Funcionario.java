public class Funcionario extends Thread{
    private Double salario = 700.0;
    private Integer id;
    private Conta conta;
    private Conta contaInvestimento;
    private Banco banco;

    public Funcionario(Integer id){
        this.id = id;
        try {
            this.conta = new Conta(0.00);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            this.contaInvestimento = new Conta(0.00);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.banco = new Banco();
    }

    public void investir(){
        banco.transferir(conta, contaInvestimento, salario * 0.2);
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(Conta contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }
}
