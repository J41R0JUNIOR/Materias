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

    public static boolean rentBook(String titulo, String clientName) {
        ArrayList<Book> books = loadBooksFromFile();
        ArrayList<ClientInDebt> clientsInDebt = loadCostumersInDebtFromFile();

        boolean isClientInDebt = clientInDebt(clientsInDebt, clientName);

        if (!isClientInDebt) {
            for (Book book : books) {
                if (book.getTittle().equalsIgnoreCase(titulo) && book.getCopies() > 0) {
                    book.setCopies(book.getCopies() - 1);
                    saveBooksToFile(books);
                    addRentRecord(clientName, titulo);
                    return true;
                }
            }
        }
        return false;
    }

    private static void addRentRecord(String clientName, String bookTitle) {
        ArrayList<ClientInDebt> rentRecords = loadRentRecordsFromFile();
        rentRecords.add(new ClientInDebt(clientName, bookTitle));
        saveRentRecordsToFile(rentRecords);
    }

    public static boolean clientInDebt(ArrayList<ClientInDebt> clients, String clientName) {
        for (ClientInDebt clientInDebt : clients) {
            System.out.println(clientName);
            if (clientInDebt.getClient().equalsIgnoreCase(clientName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean returnBook(String titulo) {
        ArrayList<Book> books = loadBooksFromFile();
        for (Book book : books) {
            if (book.getTittle().equalsIgnoreCase(titulo)) {
                book.setCopies(book.getCopies() + 1);
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

            books = gson.fromJson(jsonObject.get("books"), new TypeToken<ArrayList<Book>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private static ArrayList<ClientInDebt> loadCostumersInDebtFromFile() {
        ArrayList<ClientInDebt> clientsInDebt = new ArrayList<>();
        try {
            File file = new File(RENT_BOOKS_FILE_PATH);

            if (!file.exists()) {
                System.out.println("File alugueis.json not found at the path: " + file.getAbsolutePath());
                return clientsInDebt;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            System.out.println("JSON Content: " + jsonContent.toString()); // Debug statement

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonContent.toString(), JsonObject.class);
            System.out.println("Parsed JSON Object: " + jsonObject); // Debug statement

            clientsInDebt = gson.fromJson(jsonObject.get("rent"), new TypeToken<ArrayList<ClientInDebt>>() {}.getType());
            System.out.println("Clients in debt loaded: " + clientsInDebt); // Debug statement
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientsInDebt;
    }

    private static ArrayList<ClientInDebt> loadRentRecordsFromFile() {
        ArrayList<ClientInDebt> rentRecords = new ArrayList<>();
        try {
            File file = new File(RENT_BOOKS_FILE_PATH);

            if (!file.exists()) {
                System.out.println("File alugueis.json not found at the path: " + file.getAbsolutePath());
                return rentRecords;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            System.out.println("JSON Content: " + jsonContent.toString()); // Debug statement

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonContent.toString(), JsonObject.class);
            System.out.println("Parsed JSON Object: " + jsonObject); // Debug statement

            rentRecords = gson.fromJson(jsonObject.get("rent"), new TypeToken<ArrayList<ClientInDebt>>() {}.getType());
            System.out.println("Rent records loaded: " + rentRecords); // Debug statement
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rentRecords;
    }

    private static void saveRentRecordsToFile(ArrayList<ClientInDebt> rentRecords) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("rent", gson.toJsonTree(rentRecords));

            BufferedWriter writer = new BufferedWriter(new FileWriter(RENT_BOOKS_FILE_PATH));
            writer.write(gson.toJson(jsonObject));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveBooksToFile(ArrayList<Book> books) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("books", gson.toJsonTree(books));

            BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE_PATH));
            writer.write(gson.toJson(jsonObject));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
