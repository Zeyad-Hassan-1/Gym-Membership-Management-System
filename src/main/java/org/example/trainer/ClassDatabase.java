package org.example.trainer;

import org.example.Database;

public class ClassDatabase extends Database<Class> {
    protected ClassDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Class createRecord(String line) {
        if(line == null)return null;
        String[] fields = line.split(",");
        if(fields.length != 5)return null;
        return new Class(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
    }
}
