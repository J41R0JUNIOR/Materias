import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Loja {
    // Variáveis de instância
    private String id;
    private double salarioFuncionario = 1400.00;
    private Conta conta;
    private Banco banco;
    private Integer salarioPagoFuncionario1 = 0;
    private Integer salarioPagoFuncionario2 = 0;
    private Funcionario funcionario1;
    private Funcionario funcionario2;

    // Construtor da classe Loja
    public Loja(String id, Banco banco){
        // Inicialização das variáveis no construtor
        this.id = id;
        this.banco = banco;
        // Criação dos funcionários com base no ID da loja
        this.funcionario1 = new Funcionario( "Funcionario1" + id, banco);
        this.funcionario2 = new Funcionario("Funcionario2" + id, banco);
        try {
            // Inicialização da conta com um saldo inicial de 0.00
            this.conta = new Conta(00.00, id);
        } catch (Exception e) {
            // Lança uma exceção em caso de erro na criação da conta
            throw new RuntimeException(e);
        }

        // Adiciona um listener à conta para monitorar alterações no saldo
        this.conta.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("saldo")) {
                // Verifica se o saldo é suficiente para pagar os funcionários
                if (conta.getSaldo() >= 1400) {
                    pagarFuncionario();
                }
            }
        });
    }

    // Métodos getter e setter para a conta
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    // Métodos getter para os funcionários
    public Funcionario getFuncionario1() {
        return funcionario1;
    }

    public Funcionario getFuncionario2() {
        return funcionario2;
    }

    // Método para pagar os funcionários
    public void pagarFuncionario() {
        // Verifica se o saldo é suficiente para pagar os funcionários
        if (conta.getSaldo() >= 1400.00) {
            // Verifica qual funcionário deve ser pago primeiro com base no número de salários pagos
            if (salarioPagoFuncionario1 > salarioPagoFuncionario2 && conta.getSaldo() >= 1400) {
                // Transfere o salário para a conta do segundo funcionário e registra o pagamento
                banco.transferir(conta, funcionario2.getConta(), salarioFuncionario);
                funcionario2.investir();
                salarioPagoFuncionario2 += 1;

            } else if (salarioPagoFuncionario2 >= salarioPagoFuncionario1 && conta.getSaldo() >= 1400) {
                // Transfere o salário para a conta do primeiro funcionário e registra o pagamento
                banco.transferir(conta, funcionario1.getConta(), salarioFuncionario);
                funcionario1.investir();
                salarioPagoFuncionario1 += 1;
            } else {
                // Caso não seja possível pagar os salários
                System.out.println("Não foi possível pagar salarios");
            }
        }
    }
}
