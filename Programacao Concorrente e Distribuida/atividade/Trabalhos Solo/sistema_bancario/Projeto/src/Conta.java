import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Conta {
    private String nome;
    private Double saldo;
    private PropertyChangeSupport propertyChangeSupport;

    // Construtor da classe Conta
    public Conta(Double saldo, String nome) throws Exception {
        // Inicializa o saldo e o nome da conta
        this.saldo = saldo;
        this.nome = nome;
        // Inicializa o suporte para alteração de propriedades
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    // Método para obter o saldo da conta
    public Double getSaldo() {
        return saldo;
    }

    // Método para obter o nome da conta
    public String getNome() {
        return nome;
    }

    // Método para depositar dinheiro na conta
    public void depositar(Double valor) {
        // Armazena o saldo anterior antes de realizar o depósito
        Double saldoAnterior = saldo;
        // Realiza o depósito adicionando o valor ao saldo atual
        this.saldo += valor;
        // Notifica os ouvintes sobre a mudança no saldo
        propertyChangeSupport.firePropertyChange("saldo", saldoAnterior, saldo);
    }

    // Método para debitar dinheiro da conta
    public void debitar(Double valor) {
        // Armazena o saldo anterior antes de realizar o débito
        Double saldoAnterior = saldo;
        // Realiza o débito subtraindo o valor do saldo atual
        this.saldo -= valor;
        // Notifica os ouvintes sobre a mudança no saldo
        propertyChangeSupport.firePropertyChange("saldo", saldoAnterior, saldo);
    }

    // Método para adicionar um ouvinte de mudança de propriedade
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // Método para remover um ouvinte de mudança de propriedade (comentado para não ser utilizado)
//    public void removePropertyChangeListener(PropertyChangeListener listener) {
//        propertyChangeSupport.removePropertyChangeListener(listener);
//    }
}
