public class Loja {
    private Integer id;
    private double salarioFuncionario = 1400.00;
    private Conta conta;
    private Banco banco;
    private Integer salarioPagoFuncionario1 = 0;
    private Integer salarioPagoFuncionario2 = 0;
    private Funcionario funcionario1;
    private Funcionario funcionario2;

    public Loja(Integer id){
        this.id = id;
        this.funcionario1 = new Funcionario( "Funcionario1");
        this.funcionario2 = new Funcionario("Funcionario2");
        try {
            this.conta = new Conta(2800.00, "Loja" + id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.banco = new Banco();
    }

    public void pagarFuncionario(){
        if (salarioPagoFuncionario1 > salarioPagoFuncionario2 && conta.getSaldo() >= 1400){
            banco.transferir(conta, funcionario2.getConta(), salarioFuncionario);
            funcionario2.investir();
            salarioPagoFuncionario2 += 1;

        }else if (salarioPagoFuncionario2 >= salarioPagoFuncionario1 && conta.getSaldo() >= 1400){
            banco.transferir(conta, funcionario1.getConta(), salarioFuncionario);
            funcionario1.investir();
            salarioPagoFuncionario1 += 1;
        }
    }
}
