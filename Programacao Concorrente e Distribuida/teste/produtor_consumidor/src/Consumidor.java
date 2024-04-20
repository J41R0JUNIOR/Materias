import java.util.Random;

public class Consumidor extends Thread{
    private Armazem armazem;

    public Consumidor(Armazem armazem, String name){
        super(name);
        this.armazem = armazem;
    }
    public void run(){

        int numProduto = new Random().nextInt(5) + 1;
        System.out.println(this.getName() + " consumiu " + numProduto);

        for(int i = 0; i < numProduto; i++) {
            this.consumir();
        }
        System.out.println(this.getName() + " terminou consumo " + numProduto);
    }

    public int consumir(){
        try {
            Thread.sleep((2000));
        }catch (InterruptedException e){
            System.out.println("Thread Interrompida");
        }
        int produto = new Random().nextInt(1000);

        this.armazem.remover(produto);
        return produto;
    }
}
