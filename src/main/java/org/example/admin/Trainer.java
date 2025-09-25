package org.example.admin;

import org.example.User;

public class Trainer extends User {
    private final String trainerId;
    private final String speciality;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        super(name, email, phoneNumber);
        this.trainerId = trainerId;
        this.speciality = speciality;
    }

    @Override
    public String lineRepresentation() {
        return String.format("%s,%s,%s,%s,%s", trainerId, name, email, speciality, phoneNumber);
    }
    @Override
    public String getSearchKey() {
        return trainerId;
    }
}
