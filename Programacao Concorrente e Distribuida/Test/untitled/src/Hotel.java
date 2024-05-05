import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Hotel {
    public static final int NUMERO_MAXIMO_HOSPEDES = 4;
    private List<Quarto> quartos;
    private BlockingQueue<List<Hospede>> filaEspera;
    private int maxTentativasAluguel = 2; // Máximo de tentativas de aluguel permitidas
    private List<Hospede> hospedesComReclamacao = new ArrayList<>(); // Lista de hóspedes que deixaram reclamação

    public Hotel(int numQuartos) {
        quartos = new ArrayList<>();
        for (int i = 1; i <= numQuartos; i++) {
            Quarto quarto = new Quarto(i);
            quartos.add(quarto);
            System.out.println("Quarto número " + i + " foi criado.");
        }
        filaEspera = new ArrayBlockingQueue<>(10);
    }

    public synchronized Quarto alocaQuarto(List<Hospede> grupoHospedes) throws InterruptedException {
        for (int tentativa = 1; tentativa <= maxTentativasAluguel; tentativa++) {
            for (Quarto quarto : quartos) {
                if (quarto.estaVago()) {
                    quarto.adicionarHospedes(grupoHospedes);
                    return quarto; // Return the allocated room
                }
            }
            if (tentativa == maxTentativasAluguel) {
                System.out.println("Hóspede " + grupoHospedes.get(0).getNome() +
                        " não conseguiu alugar um quarto após " + maxTentativasAluguel + " tentativas.");
                if (!hospedesComReclamacao.contains(grupoHospedes.get(0))) {
                    grupoHospedes.get(0).adicionarReclamacao("Não conseguiu alugar um quarto após " + maxTentativasAluguel + " tentativas.");
                    hospedesComReclamacao.add(grupoHospedes.get(0));
                }
                return null; // or throw an exception indicating no room is available after max attempts
            }
            System.out.println("Todos os quartos estão ocupados. O grupo " + grupoHospedes.get(0).getNumeroGrupo() +
                    " será colocado na fila de espera.");
            filaEspera.put(grupoHospedes);
            wait(); // Espera até que um quarto seja liberado
        }
        return null;
    }

    public synchronized void liberarQuarto(List<Hospede> grupoHospedes) {
        notifyAll(); // Notifica os hóspedes em espera que um quarto foi liberado
        for (Quarto quarto : quartos) {
            if (quarto.containsAllHospedes(grupoHospedes)) {
                quarto.removerHospedes(grupoHospedes);
                // If the room becomes vacant, check if there's a group waiting to occupy it
                if (quarto.estaVago()) {
                    List<Hospede> proximoGrupo = filaEspera.poll();
                    if (proximoGrupo != null) {
                        try {
                            alocaQuarto(proximoGrupo); // Allocate the room to the next group in the waiting list
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return;
            }
        }
    }

    public synchronized List<Quarto> getQuartos() {
        return quartos;
    }

    public synchronized List<Hospede> getProximoGrupoFilaEspera() {
        return filaEspera.poll();
    }

    // Método para registrar reclamação de um hóspede
    public synchronized void registrarReclamacao(Hospede hospede, String reclamacao) {
        System.out.println("Reclamação registrada: " + reclamacao);
        hospede.adicionarReclamacao(reclamacao);
    }
}

