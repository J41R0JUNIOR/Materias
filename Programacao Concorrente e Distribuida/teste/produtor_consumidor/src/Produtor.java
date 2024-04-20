import java.util.Random;

public class Produtor extends Thread{
    private Armazem armazem;

    public Produtor(Armazem armazem, String name){
        super(name);
        this.armazem = armazem;
    }

    public void run(){

        int numProduto = new Random().nextInt(5) + 1;
        System.out.println(this.getName() + " produziu " + numProduto);

        for(int i = 0; i < numProduto; i++) {
            this.produzir();
        }
        System.out.println(this.getName() + " terminou de produzir " + numProduto);
    }
    public void produzir(){
        try {
            Thread.sleep((2000));
        }catch (InterruptedException e){
            System.out.println("Thread Interrompida");
        }
        int produto = new Random().nextInt(1000);
        this.armazem.adicionar(produto);
    }


}
