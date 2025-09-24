package org.example.admin;

public class Trainer {
    private final String trainerId;
    private final String name;
    private final String email;
    private final String speciality;
    private final String phoneNumber;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }

    public String lineRepresentation() {
        return String.format("%s,%s,%s,%s,%s", trainerId, name, email, speciality, phoneNumber);
    }

    public String getSearchKey() {
        return trainerId;
    }
}
