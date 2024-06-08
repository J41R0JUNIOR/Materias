package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class BookHandler {

    private static final String BOOKS_FILE_PATH = "livros.json";
    private static final String RENT_BOOKS_FILE_PATH = "alugueis.json";


    public static ArrayList<Book> searchBooks() {
        return loadBooksFromFile();
    }

    public static void sendBooks(BufferedWriter bufferedWriter, ArrayList<Book> books) {
        try {
            for (Book book : books) {
                bufferedWriter.write(book.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean rentBook(String titulo) {
        ArrayList<Book> books = loadBooksFromFile();
        for (Book book : books) {
            if (book.getTitulo().equalsIgnoreCase(titulo) && book.getExemplares() > 0) {
                book.setExemplares(book.getExemplares() - 1);
                saveBooksToFile(books);
                return true;
            }
        }
        return false;
    }

    public static boolean returnBook(String titulo) {
        ArrayList<Book> books = loadBooksFromFile();
        for (Book book : books) {
            if (book.getTitulo().equalsIgnoreCase(titulo)) {
                book.setExemplares(book.getExemplares() + 1);
                saveBooksToFile(books);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Book> loadBooksFromFile() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            File file = new File(BOOKS_FILE_PATH);

            if (!file.exists()) {
                System.out.println("File livros.json not found at the path: " + file.getAbsolutePath());
                return books;
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
            books = gson.fromJson(jsonObject.get("livros"), new TypeToken<ArrayList<Book>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private static void saveBooksToFile(ArrayList<Book> livros) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("livros", gson.toJsonTree(livros));

            BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE_PATH));
            writer.write(gson.toJson(jsonObject));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
