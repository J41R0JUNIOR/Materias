import java.util.List;

public class Camareira extends Thread {
    private String nome;
    private volatile boolean ativo = true;

    private List<Quarto> quartosResponsaveis;

    public Camareira(String nome, List<Quarto> quartosResponsaveis) {
        this.nome = nome;

        this.quartosResponsaveis = quartosResponsaveis;
    }

    public String getNome() {
        return nome;
    }

    public void pausar() {
        ativo = false;
    }

    public void retomar() {
        ativo = true;
    }

    @Override
    public void run() {
        try {
            while (ativo) {
                for (Quarto quarto : quartosResponsaveis) {
                    if (quarto.estaProntoParaLimpeza()) {
                        System.out.println(nome + " está limpando o quarto " + quarto.getNumero() + ".");
                        quarto.limpar();
                        Thread.sleep(2000); // Sleep for 2 seconds
                    }
                }
            }
        } catch (InterruptedException e) {
            // Handle interruption if needed
            e.printStackTrace();
        }
    }
}
