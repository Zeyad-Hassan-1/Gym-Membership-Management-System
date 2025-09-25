package org.example.trainer;

import org.example.Database;

public class MemberDatabase extends Database<Member> {
    public MemberDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Member createRecord(String line) {
        if (line == null) return null;
        String[] fields = line.split(",");
        if (fields.length != 6) return null;
        return new Member(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
    }
}
