import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Thread{
    private String id;
    private Conta conta;

    private ArrayList<Loja> lojas;
    private Banco banco;
    private int ultimaLoja = 0;
    private Random random = new Random();
    private boolean terminou = false;


    public Cliente(String id, ArrayList<Loja> lojas, Banco banco){
        super();
        this.id = id;
        this.lojas = lojas;
        this.banco = banco;

        try {
            this.conta = new Conta(1000.00, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public void run(){
//        while(conta.getSaldo() > 0.00){
//            if(ultimaLoja == 1){
//                banco.transferir(getConta(), lojas.get(0).getConta(), 100.00);
//            }
//        }
//    }

    public void run() {
        while (conta.getSaldo() > 0.00) {
            int proximaLoja;
            do {
                proximaLoja = random.nextInt(lojas.size());
            } while (proximaLoja == ultimaLoja);

            ultimaLoja = proximaLoja;

            double valorCompra = random.nextInt(2) == 0 ? 100.00 : 200.00;

            banco.transferir(getConta(), lojas.get(proximaLoja).getConta(), valorCompra);

//            try {
//                Thread.sleep(random.nextInt(2000) + 500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        terminou = true;
    }


    @Override
    public long getId(){return Long.parseLong(id);}

    public boolean isTerminou() {
        return terminou;
    }


    public Conta getConta() {
        return conta;
    }

}
