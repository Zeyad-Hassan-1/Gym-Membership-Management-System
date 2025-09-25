package org.example;

public abstract class User {
    protected String name, email, phoneNumber;
    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public abstract String lineRepresentation();
    public abstract String getSearchKey();
}
