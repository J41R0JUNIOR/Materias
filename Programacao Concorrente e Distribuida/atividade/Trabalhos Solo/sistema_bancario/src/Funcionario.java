public class Funcionario extends Thread{
    private Double salario = 1400.00;
    private String id;
    private String idInvestimento;
    private Conta conta;
    private Conta contaInvestimento;
    private Banco banco;

    public Funcionario(String  id, Banco banco){
        this.id = "Funcionario" + id;
        this.idInvestimento = id + "Investimento";
        try {
            this.conta = new Conta(0.00, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            this.contaInvestimento = new Conta(0.00, idInvestimento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.banco = banco;
    }

    public void investir(){
        banco.transferir(conta, contaInvestimento, salario * 0.2);
    }

    public Conta getConta() {
        return conta;
    }
}
