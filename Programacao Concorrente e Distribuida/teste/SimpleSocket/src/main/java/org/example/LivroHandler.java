package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class LivroHandler {

    private static final String LIVROS_FILE_PATH = "livros.json";
    private static final String LIVROS_ALUGADOS_FILE_PATH = "alugueis.json";


    public static ArrayList<Livro> searchBooks() {
        return loadBooksFromFile();
    }

    public static void sendBooks(BufferedWriter bufferedWriter, ArrayList<Livro> livros) {
        try {
            for (Livro livro : livros) {
                bufferedWriter.write(livro.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean alugarLivro(String titulo) {
        ArrayList<Livro> livros = loadBooksFromFile();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.getExemplares() > 0) {
                livro.setExemplares(livro.getExemplares() - 1);
                saveBooksToFile(livros);
                return true;
            }
        }
        return false;
    }

    public static boolean devolverLivro(String titulo) {
        ArrayList<Livro> livros = loadBooksFromFile();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setExemplares(livro.getExemplares() + 1);
                saveBooksToFile(livros);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Livro> loadBooksFromFile() {
        ArrayList<Livro> livros = new ArrayList<>();
        try {
            File file = new File(LIVROS_FILE_PATH);

            if (!file.exists()) {
                System.out.println("Arquivo livros.json não encontrado no caminho: " + file.getAbsolutePath());
                return livros;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonContent.toString(), JsonObject.class);
            livros = gson.fromJson(jsonObject.get("livros"), new TypeToken<ArrayList<Livro>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return livros;
    }

    private static void saveBooksToFile(ArrayList<Livro> livros) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("livros", gson.toJsonTree(livros));

            BufferedWriter writer = new BufferedWriter(new FileWriter(LIVROS_FILE_PATH));
            writer.write(gson.toJson(jsonObject));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
