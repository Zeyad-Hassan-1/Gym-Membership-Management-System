package org.example.trainer;

import org.example.User;

public class Class implements User {
    private final String classId, className, TrainerId;
    private int duration,availableSeats;

    public Class(String trainerId, String classId, String className,int duration, int availableSeats) {
        this.TrainerId = trainerId;
        this.classId = classId;
        this.className = className;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    @Override
    public String lineRepresentation() {
        return String.format("%s,%s,%s,%d,%d", TrainerId, classId, className, duration, availableSeats);
    }

    @Override
    public String getSearchKey() {
        return classId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
