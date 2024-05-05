import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(10);

        List<Thread> threads = new ArrayList<>();
        BlockingQueue<List<Hospede>> filaEspera = new ArrayBlockingQueue<>(10);

        for (int i = 1; i <= 8; i++) {
            List<Hospede> grupoHospedes = criarGrupoHospedes(i);
            threads.addAll(grupoHospedes);

            Recepcionista recepcionista = new Recepcionista("Recepcionista " + i, hotel, grupoHospedes, filaEspera);
            recepcionista.start();
            threads.add(recepcionista);
        }

        List<Camareira> camareiras = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Quarto> quartosResponsaveis = hotel.getQuartos().subList(i * 2, (i + 1) * 2);
            Camareira camareira = new Camareira("Camareira " + (i + 1), quartosResponsaveis);
            camareira.start();
            camareiras.add(camareira);
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Aguarda a conclusão de cada thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Simula a saída para passear
        System.out.println("Hóspedes estão saindo para passear...");
        for (Quarto quarto : hotel.getQuartos()) {
            quarto.devolverChave(); // Devolve a chave na recepção ao sair
        }

        try {
            Thread.sleep(5000); // Simula o tempo que os hóspedes passam passeando (5 segundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simula o retorno dos hóspedes para os quartos
        System.out.println("Hóspedes estão retornando para os quartos...");
        for (Quarto quarto : hotel.getQuartos()) {
            List<Hospede> hospedes = quarto.getHospedes();
            if (!hospedes.isEmpty()) {
                System.out.println("Hóspedes do quarto " + quarto.getNumero() + " estão retornando.");
                for (Hospede hospede : hospedes) {
                    hospede.retornarParaQuarto(); // Método que simula o retorno para o quarto
                }
            }
        }

        System.out.println("Todos os grupos de hóspedes concluíram sua estadia.");

    }

    public static List<Hospede> criarGrupoHospedes(int numeroGrupo) {
        Random random = new Random();
        int numHospedes = random.nextInt(10) + 1; // De 1 a 10 hóspedes
        List<Hospede> grupoHospedes = new ArrayList<>();

        for (int i = 0; i < numHospedes; i++) {
            // Create an instance of Hospede without a specific name
            Hospede hospede = new Hospede(numeroGrupo);
            grupoHospedes.add(hospede);
        }

        return grupoHospedes;
    }
}
