package org.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;
    private String clientState;


    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.clientState = String.valueOf(EstadoCliente.NORMAL.getDescricao());
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            System.out.println("New client username: " + clientUsername);
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        String listarLivro = String.valueOf(RespostaEsperada.LISTAR_LIVROS.getDescricao());
        String alugarLivro = String.valueOf(RespostaEsperada.ALUGAR_LIVRO.getDescricao());
        String devolverLivro = String.valueOf(RespostaEsperada.DEVOLVER_LIVRO.getDescricao());

        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();

                String[] partsOfMessage = messageFromClient.split(": ");
                String messageToAnalise = partsOfMessage[1];


                if (clientState.equals(EstadoCliente.NORMAL.getDescricao())) {
                    showOptionsToClient();
                }else if(clientState.equals(EstadoCliente.ALUGANDO_LIVRO.getDescricao())){
                    broadcastMessage("Digite o nome do livro");

                    boolean success = LivroHandler.alugarLivro(titulo);
                    messageFromClient = success ? clientUsername + " alugou o livro: " + titulo
                            : "Falha ao alugar o livro: " + titulo;
                    broadcastMessage(messageFromClient);
                }else{
                    broadcastMessage("Estado atual " + clientState);
                }




                if (messageToAnalise != null) {


                    if (messageToAnalise.equalsIgnoreCase(listarLivro) && Objects.equals(clientState, EstadoCliente.NORMAL.getDescricao())) {
                        clientState = EstadoCliente.NORMAL.getDescricao();
                        ArrayList<Livro> livros = LivroHandler.searchBooks();
                        LivroHandler.sendBooks(bufferedWriter, livros);
                        messageFromClient = clientUsername + " está listando os livros";
                        broadcastMessage(messageFromClient);

                    } else if (messageToAnalise.startsWith(alugarLivro)) {
                        clientState = EstadoCliente.ALUGANDO_LIVRO.getDescricao();

//                        String titulo = messageToAnalise.replace(alugarLivro, "").trim();
//                        boolean success = LivroHandler.alugarLivro(titulo);
//                        messageFromClient = success ? clientUsername + " alugou o livro: " + titulo
//                                : "Falha ao alugar o livro: " + titulo;
//                        broadcastMessage(messageFromClient);

                    } else if (messageToAnalise.startsWith(devolverLivro)) {
                        clientState = EstadoCliente.DEVOLVENDO_LIVRO.getDescricao();

                        String titulo = messageToAnalise.replace(devolverLivro, "").trim();
                        boolean success = LivroHandler.devolverLivro(titulo);
                        messageFromClient = success ? clientUsername + " devolveu o livro: " + titulo
                                : "Falha ao devolver o livro: " + titulo;
                        broadcastMessage(messageFromClient);
                    }
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void estadoAlugando(){

    }

    private void showOptionsToClient(){
        broadcastMessage("Opções Disponíveis\n1 - Listar livros\n2 - Alugar livro\n3 - Devolver livro");
    }

    public void broadcastMessage(String messageToSend) {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                if (clientHandler.clientUsername.equals(clientUsername)) {
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUsername + " has left the chat!");
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
