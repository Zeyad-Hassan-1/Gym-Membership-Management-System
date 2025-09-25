package org.example.admin;

import org.example.User;

public class Trainer implements User {
    private final String trainerId, speciality, name, email, phoneNumber;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.trainerId = trainerId;
        this.speciality = speciality;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
