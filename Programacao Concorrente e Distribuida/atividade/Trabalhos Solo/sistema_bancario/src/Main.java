import java.lang.ref.Cleaner;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        Loja loja1 = new Loja("Loja1", banco);
        Loja loja2 = new Loja("Loja2", banco);

        ArrayList<Loja> lojas = new ArrayList<>();
        lojas.add(loja1);
        lojas.add(loja2);


        for(int i = 1; i < 6; i++){

            Cliente cliente = new Cliente("Cliente" + i , lojas, banco);
            cliente.start();

        }


    }
}