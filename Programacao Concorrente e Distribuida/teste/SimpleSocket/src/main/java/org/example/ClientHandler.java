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
            System.out.println("New client called: " + clientUsername);
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String message;

        String listarLivro = String.valueOf(RespostaEsperada.LISTAR_LIVROS.getDescricao());
        String alugarLivro = String.valueOf(RespostaEsperada.ALUGAR_LIVRO.getDescricao());
        String devolverLivro = String.valueOf(RespostaEsperada.DEVOLVER_LIVRO.getDescricao());

        while (socket.isConnected()) {
            try {

                if (clientState.equals(EstadoCliente.NORMAL.getDescricao())) {
                    showOptionsToClient();
                }else if(clientState.equals(EstadoCliente.ALUGANDO_LIVRO.getDescricao())){
                    message = bufferedReader.readLine();
                    if(message != null) {

                        boolean success = LivroHandler.alugarLivro(message);
                        message = success ? clientUsername + " alugou o livro: " + message
                                : "Falha ao alugar o livro: " + message;
                        broadcastMessage(message);
                        this.clientState = String.valueOf(EstadoCliente.NORMAL.getDescricao());
                        continue;
                    }
                }else{
                    broadcastMessage("Estado atual " + clientState);
                }

                message = bufferedReader.readLine();



                if (message != null) {

                    if (message.equalsIgnoreCase(listarLivro) && Objects.equals(clientState, EstadoCliente.NORMAL.getDescricao())) {
                        ArrayList<Livro> livros = LivroHandler.searchBooks();
                        LivroHandler.sendBooks(bufferedWriter, livros);
//                        message = clientUsername + " está listando os livros";
//                        broadcastMessage(message);

                    } else if (message.startsWith(alugarLivro)) {
                        clientState = EstadoCliente.ALUGANDO_LIVRO.getDescricao();
                        broadcastMessage("Digite o nome do livro");
//                        String titulo = messageToAnalise.replace(alugarLivro, "").trim();
//                        boolean success = LivroHandler.alugarLivro(titulo);
//                        messageFromClient = success ? clientUsername + " alugou o livro: " + titulo
//                                : "Falha ao alugar o livro: " + titulo;
//                        broadcastMessage(messageFromClient);

                    } else if (message.startsWith(devolverLivro)) {
                        clientState = EstadoCliente.DEVOLVENDO_LIVRO.getDescricao();

                        String titulo = message.replace(devolverLivro, "").trim();
                        boolean success = LivroHandler.devolverLivro(titulo);
                        message = success ? clientUsername + " devolveu o livro: " + titulo
                                : "Falha ao devolver o livro: " + titulo;
                        broadcastMessage(message);
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
