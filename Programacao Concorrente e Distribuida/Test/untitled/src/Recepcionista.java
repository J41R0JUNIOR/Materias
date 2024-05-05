
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Recepcionista extends Thread {
    private String nome;
    private Hotel hotel;
    private List<Hospede> grupoHospedes;
    private BlockingQueue<List<Hospede>> filaEspera;

    public Recepcionista(String nome, Hotel hotel, List<Hospede> grupoHospedes,
                         BlockingQueue<List<Hospede>> filaEspera) {
        this.nome = nome;
        this.hotel = hotel;
        this.grupoHospedes = grupoHospedes;
        this.filaEspera = filaEspera;
    }

    @Override
    public void run() {
        try {
            int numMembros = grupoHospedes.size();
            System.out.println(nome + " está realizando o check-in para o grupo de hóspedes "
                    + grupoHospedes.get(0).getNumeroGrupo() +
                    ", que possui " + numMembros + " membros.");

            // Verifica se o número de membros é maior que o número máximo de membros por
            // quarto
            if (numMembros > Hotel.NUMERO_MAXIMO_HOSPEDES) { // Use hotel.NUMERO_MAXIMO_HOSPEDES
                System.out.println("O grupo " + grupoHospedes.get(0).getNumeroGrupo()
                        + " é grande demais para um quarto. Vários quartos serão alocados.");

                // Divide o grupo em subgrupos que podem caber em quartos individuais
                List<List<Hospede>> subgrupos = dividirGrupoEmSubgrupos(grupoHospedes);

                // Aloca cada subgrupo em um quarto
                for (List<Hospede> subgrupo : subgrupos) {
                    alocaSubgrupo(subgrupo);
                }
            } else {
                // Se o número de membros não exceder o número máximo de membros por quarto,
                // aloca o grupo inteiro em um único quarto
                alocaSubgrupo(grupoHospedes);
            }

            // Aqui podemos permitir que os hóspedes registrem suas reclamações no momento do check-out
            for (Hospede hospede : grupoHospedes) {
                // Simulando o registro de reclamação pelo hóspede
                String reclamacao = "Reclamação do hóspede " + hospede.getNome();
                hotel.registrarReclamacao(hospede, reclamacao);
            }

            hotel.liberarQuarto(grupoHospedes); // Libera o quarto quando o grupo sai
            if (!filaEspera.isEmpty()) {
                List<Hospede> proximoGrupo = filaEspera.poll();
                if (proximoGrupo != null && !proximoGrupo.isEmpty()) {
                    System.out.println("O grupo " + proximoGrupo.get(0).getNumeroGrupo() +
                            " foi retirado da fila de espera.");
                    hotel.alocaQuarto(proximoGrupo); // Aloca o próximo grupo da fila de espera
                } else {
                    System.out.println("Não há grupo de hóspedes para retirar da fila de espera.");
                }
            } else {
                System.out.println("A fila de espera está vazia.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para dividir o grupo em subgrupos que podem caber em quartos
    // individuais
    private List<List<Hospede>> dividirGrupoEmSubgrupos(List<Hospede> grupo) {
        List<List<Hospede>> subgrupos = new ArrayList<>();
        int numMembros = grupo.size();
        int numQuartosNecessarios = (int) Math.ceil((double) numMembros / Hotel.NUMERO_MAXIMO_HOSPEDES); // Use
        // hotel.NUMERO_MAXIMO_HOSPEDES

        int index = 0;
        for (int i = 0; i < numQuartosNecessarios; i++) {
            int startIndex = index;
            int endIndex = Math.min(index + Hotel.NUMERO_MAXIMO_HOSPEDES, numMembros); // Use
            // hotel.NUMERO_MAXIMO_HOSPEDES
            List<Hospede> subgrupo = grupo.subList(startIndex, endIndex);
            subgrupos.add(subgrupo);
            index = endIndex;
        }

        return subgrupos;
    }

    // Método para alocar um subgrupo em um quarto
    private void alocaSubgrupo(List<Hospede> subgrupo) throws InterruptedException {
        Quarto quarto = hotel.alocaQuarto(subgrupo);
        if (quarto != null) {
            System.out.println("Alocando " + subgrupo.size() + " membros para o quarto " + quarto.getNumero());
            for (Hospede hospede : subgrupo) {
                System.out.println("Quarto " + quarto.getNumero() + " alocado para o grupo " + hospede.getNumeroGrupo()
                        + " com o hóspede: " + hospede.getNome());
            }
        }
    }
}
