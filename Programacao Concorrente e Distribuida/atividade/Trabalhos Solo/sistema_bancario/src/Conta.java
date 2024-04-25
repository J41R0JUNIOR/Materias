import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Conta {
    private String nome;
    private Double saldo;
    private PropertyChangeSupport propertyChangeSupport;

    public Conta(Double saldo, String nome) throws Exception {
        this.saldo = saldo;
        this.nome = nome;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public void depositar(Double valor) {
        Double saldoAnterior = saldo;
        this.saldo += valor;
        propertyChangeSupport.firePropertyChange("saldo", saldoAnterior, saldo);
    }

    public void debitar(Double valor) {
        Double saldoAnterior = saldo;
        this.saldo -= valor;
        propertyChangeSupport.firePropertyChange("saldo", saldoAnterior, saldo);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

//    public void removePropertyChangeListener(PropertyChangeListener listener) {
//        propertyChangeSupport.removePropertyChangeListener(listener);
//    }
}
