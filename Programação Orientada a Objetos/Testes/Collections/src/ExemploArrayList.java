import java.util.ArrayList;
import java.util.HashMap;

public class ExemploArrayList {
    public static void main(String[] args) {
//        ArrayList<String> listaDeNomes = new ArrayList<>();
//
//        listaDeNomes.add("Jairo");
//        listaDeNomes.add("Joel");
//        listaDeNomes.add("Ítalo");
//
//        for (String n : listaDeNomes){
//            System.out.println(n);
//        }
//
//        if(listaDeNomes.contains("Jairo")){
//            System.out.println("Te achei");
//        }
//
//        listaDeNomes.remove("Jairo");
//        listaDeNomes.clear();
//
//        if(listaDeNomes.isEmpty()){
//            System.out.println("Is Empty");
//        }

        HashMap<String, String> capitais = new HashMap<>();
        capitais.put("Brasil", "Brasília");
        capitais.put("França", "Paris");
        capitais.put("Canadá", "Ottawa");
        capitais.put("Japão", "Tokyo");

        System.out.println(capitais.get("Brasil"));

        if(capitais.containsKey("França")){
            System.out.println(capitais.get("França"));
        }

        for(String chave : capitais.keySet()){
            System.out.println(chave + " - " + capitais.get(chave));
        }
    }
}
