import java.util.ArrayList;
import java.util.List;
public class Hospede extends Thread {
    private String nome;
    private int numeroGrupo;
    private List<String> reclamacoes;

    public Hospede(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
        this.nome = manutencaoNomes.getRandomNome();
        this.reclamacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void adicionarReclamacao(String reclamacao) {
        reclamacoes.add(reclamacao);
    }

    public List<String> getReclamacoes() {
        return reclamacoes;
    }

    public void retornarParaQuarto() {
        try {
            System.out.println(nome + " do grupo " + numeroGrupo + " está retornando para o quarto.");
            Thread.sleep(2000); // Simula o tempo que leva para retornar para o quarto (2 segundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(nome + " do grupo " + numeroGrupo + " entrou no hotel.");
            Thread.sleep(5000);
            System.out.println(nome + " do grupo " + numeroGrupo + " saiu do hotel.");
            System.out.println("Reclamações de " + nome + ": " + reclamacoes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
