package atividade3;
import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    
    ArrayList<Objeto> objetos;
    Scanner scanner = new Scanner(System.in);

    Estoque(){
        this.objetos = new ArrayList<Objeto>();
    }



    public void adicionarObjeto(Objeto obj){
        this.objetos.add(obj);
    }



    public void removerObjeto(int id) {
        for (Objeto obj : objetos) {
            if (obj.id == id) {
                objetos.remove(obj);
                System.out.println("Objeto removido com sucesso.");
                return;
            }
        }
        System.out.println("Objeto com o ID " + id + " não encontrado no estoque.");
    }


    
    public String listarObjetos(){
        String listarObjetos = "";

        for(Objeto objeto: this.objetos){
            listarObjetos += objeto.imprimir();
        }

        return listarObjetos;
    }


    
    public void editarObjeto(int id) {
        for (Objeto obj : objetos) {
            if (obj.id == id) {
                System.out.println("Digite o novo nome do objeto:");
                obj.nome = scanner.nextLine();
                System.out.println("Digite a nova quantidade do objeto:");
                obj.qtd = scanner.nextInt();
                scanner.nextLine();

                return;
            }
        }
    }
}

