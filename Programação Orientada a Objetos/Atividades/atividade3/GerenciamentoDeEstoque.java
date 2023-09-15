package atividade3;
import java.util.Scanner;
import java.util.Random;

public class GerenciamentoDeEstoque {
    public static void main(String args[]){

        int opcao = 0;
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while(opcao != 5){
            System.out.println("1- adicionar objeto");
            System.out.println("2- remover objeto");
            System.out.println("3- listar objetos");
            System.out.println("4- atualizar objeto");
            System.out.println("5- sair do programa");
            System.out.println("Sua escolha:");

            opcao = scanner.nextInt();
            scanner.nextLine();
            acao(opcao, scanner, estoque, random);
        }
        scanner.close();
    }



    public static void acao(int opcao, Scanner scanner, Estoque estoque, Random random){
        
        switch (opcao) {
            case 1:
                int idObj = random.nextInt();
                System.out.println("Adicionando objeto");
                System.out.println("Id do objeto " + idObj);
                System.out.println("Digite o nome do objeto:");
                String nomeObj = scanner.nextLine();

                System.out.println("Digite a quantidade desse objeto:");
                int qtdObj = scanner.nextInt();

                Objeto obj = new Objeto(idObj, nomeObj, qtdObj);
                estoque.adicionarObjeto(obj);
                break;
            case 2:
                System.out.println("Digite o ID do objeto:");
                int id = scanner.nextInt();
                estoque.removerObjeto(id);
                break;
            case 3:
                System.out.println("Lista de objetos");
                System.out.println(estoque.listarObjetos());
                break;
            case 4:
                System.out.println("Digite o ID do objeto:");
                int idEditar = scanner.nextInt();
                estoque.editarObjeto(idEditar);
                break;
        }
    }
   
}

