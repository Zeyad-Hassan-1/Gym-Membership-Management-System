package org.example.trainer;

import org.example.Database;

import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends Database<MemberClassRegistration> {
    protected MemberClassRegistrationDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public MemberClassRegistration createRecord(String line) {
        if (line == null) return null;
        String[] fields = line.split(",");
        if (fields.length != 4) return null;
        return new MemberClassRegistration(fields[0],fields[1],fields[2], LocalDate.parse(fields[3]));
    }
}
