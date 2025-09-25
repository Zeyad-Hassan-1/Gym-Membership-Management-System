package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database<T extends User> {
    protected final String fileName;
    protected ArrayList<T> records;

    protected Database(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<>();
        readFromFile();
    }

    public void readFromFile(){
        File file = new File(this.fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                T trainer = createRecord(scanner.nextLine());
                if (trainer != null) {  // Only add valid trainers
                    records.add(trainer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + this.fileName);
        }
    }

    public boolean contains(String searchKey) {
        for (T record : records) {
            if (record.getSearchKey().equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<T> returnAllRecords() {
        return new ArrayList<>(this.records);
    }

    public T getRecord(String searchKey) {
        for (T record : records) {
            if (record.getSearchKey().equals(searchKey)) {
                return record;
            }
        }
        return null;
    }

    public boolean insertRecord(T record) {
        if (record != null && !contains(record.getSearchKey())) {
            records.add(record);
            return true;
        }
        return false;
    }

    public void deleteRecord(String searchKey) {
        records.removeIf(record -> record.getSearchKey().equals(searchKey));
    }

    public void saveToFile() {
        File file = new File(this.fileName);
        try (FileWriter writer = new FileWriter(file)) {
            for (T record : records) {
                writer.write(record.lineRepresentation() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving to file: " + this.fileName);
        }
    }

    public abstract T createRecord(String line);
}
