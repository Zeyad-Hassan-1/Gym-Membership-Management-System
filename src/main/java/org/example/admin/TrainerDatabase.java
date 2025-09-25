package org.example.admin;

import org.example.Database;

public class TrainerDatabase extends Database<Trainer> {

    public TrainerDatabase(String fileName) {
        super(fileName);
    }

    @Override
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

}
