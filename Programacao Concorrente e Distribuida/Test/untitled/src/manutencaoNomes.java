import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class manutencaoNomes {
    private static final List<String> nomes = new ArrayList<>();

    static {
        nomes.add("Joao Silva");
        nomes.add("Pedro Santos");
        nomes.add("Lucas Oliveira");
        nomes.add("Mateus Pereira");
        nomes.add("Gabriel Souza");
        nomes.add("Rafael Costa");
        nomes.add("Leonardo Martins");
        nomes.add("Bruno Almeida");
        nomes.add("Thiago Ferreira");
        nomes.add("Gustavo Barbosa");
        nomes.add("Eduardo Gomes");
        nomes.add("Carlos Rodrigues");
        nomes.add("Andre Nunes");
        nomes.add("Diego Lima");
        nomes.add("Felipe Castro");
        nomes.add("Marcos Ribeiro");
        nomes.add("Alexandre Goncalves");
        nomes.add("Vinicius Miranda");
        nomes.add("Antonio Rocha");
        nomes.add("Marcelo Fernandes");
        nomes.add("Ana Oliveira");
        nomes.add("Maria Santos");
        nomes.add("Julia Silva");
        nomes.add("Beatriz Costa");
        nomes.add("Giovanna Pereira");
        nomes.add("Luiza Souza");
        nomes.add("Isabella Rodrigues");
        nomes.add("Mariana Almeida");
        nomes.add("Laura Ferreira");
        nomes.add("Fernanda Barbosa");
        nomes.add("Clara Gomes");
        nomes.add("Camila Martins");
        nomes.add("Carolina Lima");
        nomes.add("Amanda Castro");
        nomes.add("Bruna Ribeiro");
        nomes.add("Vitoria Goncalves");
        nomes.add("Leticia Miranda");
        nomes.add("Larissa Rocha");
        nomes.add("Heloisa Fernandes");
        nomes.add("Manuela Carvalho");
    }

    public static String getRandomNome() {
        Random random = new Random();
        return nomes.get(random.nextInt(nomes.size()));
    }
}

