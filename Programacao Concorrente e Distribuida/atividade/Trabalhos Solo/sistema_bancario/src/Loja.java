import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Loja {
    private String id;
    private double salarioFuncionario = 1400.00;
    private Conta conta;
    private Banco banco;
    private Integer salarioPagoFuncionario1 = 0;
    private Integer salarioPagoFuncionario2 = 0;
    private Funcionario funcionario1;
    private Funcionario funcionario2;

    public Loja(String id, Banco banco){
        this.id = id;
        this.banco = banco;
        this.funcionario1 = new Funcionario( "Funcionario1", banco);
        this.funcionario2 = new Funcionario("Funcionario2", banco);
        try {
            this.conta = new Conta(00.00, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.conta.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("saldo")) {
                    if (conta.getSaldo() >= 1400) {
                        pagarFuncionario();
                    }
                }
            }
        });
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void pagarFuncionario() {
        if (conta.getSaldo() > 1400.00) {
            if (salarioPagoFuncionario1 > salarioPagoFuncionario2 && conta.getSaldo() >= 1400) {
                banco.transferir(conta, funcionario2.getConta(), salarioFuncionario);
                funcionario2.investir();
                salarioPagoFuncionario2 += 1;

            } else if (salarioPagoFuncionario2 >= salarioPagoFuncionario1 && conta.getSaldo() >= 1400) {
                banco.transferir(conta, funcionario1.getConta(), salarioFuncionario);
                funcionario1.investir();
                salarioPagoFuncionario1 += 1;
            } else {
                System.out.println("Não foi possível pagar salarios");
            }
        }
    }


}
