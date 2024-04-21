public class Loja {
    private Integer id;
    private double salarioFuncionario = 700.00;
    private Conta conta;
    private Banco banco;

    private Funcionario funcionario1;
    private Funcionario funcionario2;

    public Loja(Integer id){
        this.id = id;
        this.funcionario1 = new Funcionario(1);
        this.funcionario2 = new Funcionario(2);
        try {
            this.conta = new Conta(1400.00);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.banco = new Banco();
    }

    public void pagarFuncionario(){
        if(conta.getSaldo() >= 1400) {
            banco.transferir(conta, funcionario1.getConta(), salarioFuncionario);
            banco.transferir(conta, funcionario2.getConta(), salarioFuncionario);

            funcionario1.investir();
            System.out.println("conta " + funcionario1.getConta().getSaldo());
            System.out.println("conta investimento " + funcionario1.getContaInvestimento().getSaldo());

            System.out.println("conta " + funcionario2.getConta().getSaldo());
            System.out.println("conta investimento " + funcionario2.getContaInvestimento().getSaldo());
        }
    }
}
