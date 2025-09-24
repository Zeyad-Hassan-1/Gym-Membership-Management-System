package org.example.admin;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class TrainerDatabase{
    private final ArrayList<Trainer> records;
    private final String fileName;

    public TrainerDatabase(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<>();
        readFromFile();
    }

    public void readFromFile(){
        File file = new File(this.fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                Trainer trainer = createRecord(scanner.nextLine());
                if (trainer != null) {  // Only add valid trainers
                    records.add(trainer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + this.fileName);
        }
    }

    public Trainer createRecord(String line){
        if (line == null) {
            return null;
        }
        String[] fields = line.split(",");
        if (fields.length != 5) {
            return null;
        }
        return new Trainer(fields[0], fields[1], fields[2], fields[3], fields[4]);
    }

    public ArrayList<Trainer> returnAllRecords() {
        return new ArrayList<>(this.records);
    }

    public boolean contains(String searchKey) {
        for (Trainer record : records) {
            if (record.getSearchKey().equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public Trainer getRecord(String searchKey) {
        for (Trainer record : records) {
            if (record.getSearchKey().equals(searchKey)) {
                return record;
            }
        }
        return null;
    }

    public boolean insertRecord(Trainer record) {
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
            for (Trainer record : records) {
                writer.write(record.lineRepresentation() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving to file: " + this.fileName);
        }
    }

}
