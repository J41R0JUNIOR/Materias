
import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int numero;
    private List<Hospede> hospedes;
    private boolean prontoParaLimpeza = false;

    public Quarto(int numero) {
        this.numero = numero;
        this.hospedes = new ArrayList<>();

    }

    public void devolverChave() {
        System.out.println("Hóspedes do quarto " + numero + " devolveram a chave na recepção.");
        prontoParaLimpeza = true;
    }

    public boolean estaProntoParaLimpeza() {
        return prontoParaLimpeza;
    }

    public void limpar() {
        System.out.println("O quarto " + numero + " foi limpo.");
        prontoParaLimpeza = false;
    }

    public int getNumero() {
        return numero;
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public boolean estaVago() {
        return hospedes.isEmpty();
    }

    public void adicionarHospedes(List<Hospede> novosHospedes) {
        hospedes.addAll(novosHospedes);
    }

    public void removerHospedes(List<Hospede> hospedesARemover) {
        hospedes.removeAll(hospedesARemover);
    }

    public boolean containsAllHospedes(List<Hospede> hospedes) {
        List<Hospede> quartoHospedes = getHospedes();
        return quartoHospedes.containsAll(hospedes);
    }
}
