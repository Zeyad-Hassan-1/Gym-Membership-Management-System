package org.example.admin;

import java.util.ArrayList;

public class AdminRole{
    private final TrainerDatabase database;

    public AdminRole()
    {
        this.database = new TrainerDatabase("Trainers.txt");
    }

    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber)
    {
        Trainer newTrainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        if (this.database.insertRecord(newTrainer))
        {
            System.out.println("Trainer added successfully");
        }
        else
        {
            System.out.println("Trainer already exists");
        }
    }

    public ArrayList<Trainer> getListOfTrainers(){
        return this.database.returnAllRecords();
    }

    public void deleteTrainer(String trainerId)
    {
        this.database.deleteRecord(trainerId);
    }

    public void logout(){
        this.database.saveToFile();
    }
}
