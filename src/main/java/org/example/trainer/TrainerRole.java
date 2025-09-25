package org.example.trainer;

import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;


    public TrainerRole(MemberDatabase memberDatabase, ClassDatabase classDatabase, MemberClassRegistrationDatabase registrationDatabase) {
        this.memberDatabase = memberDatabase;
        this.classDatabase = classDatabase;
        this.registrationDatabase = registrationDatabase;
    }

    public void addMember (String memberID, String name, String membershipType, String email, String
            phoneNumber, String status){
        Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        if (this.memberDatabase.insertRecord(member)){
            System.out.println("Member added successfully");
        }
        else
        {
            System.out.println("Trainer already exists");
        }
    }

    public ArrayList<Member> getListOfMembers(){
        return this.memberDatabase.returnAllRecords();
    }
    public void addClass (String classID, String className, String trainerID, int duration, int
            maxParticipants){
        Class newClass = new Class(classID, className, trainerID, duration, maxParticipants);
        if (this.classDatabase.insertRecord(newClass)){
            System.out.println("Class added successfully");
        }
        else
        {
            System.out.println("Trainer already exists");
        }
    }

    public ArrayList<Class> getListOfClasses(){
        return this.classDatabase.returnAllRecords();
    }

    public void registerMemberForClass (String memberID, String classID, LocalDate registrationDate){
        if (classDatabase.getRecord(classID).getAvailableSeats() == 0) {
            System.out.println("No available seats available");
            return;
        }
        else
        {
            MemberClassRegistration registration = new MemberClassRegistration(memberID,classID,"active",registrationDate);
            if (registrationDatabase.insertRecord(registration)){
                System.out.println("registered successfully");
            }
            else
            {
                System.out.println("unsuccessfully register");
            }
        }
    }

    public void cancelRegistration(String memberID, String classID) {
        MemberClassRegistration old = registrationDatabase.getRecord(memberID + classID);

        // Check if the registration exists
        if (old == null) {
            System.out.println("Registration not found");
            return;
        }

        // Calculate days between registration and cancellation
        LocalDate currentDate = LocalDate.now();
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(old.getRegistrationDate(), currentDate);

        // Create updated registration with canceled status
        MemberClassRegistration updated = new MemberClassRegistration(
                old.getMemberId(),
                old.getClassId(),
                "canceled",
                old.getRegistrationDate()
        );

        // Update the registration record
        int index = registrationDatabase.returnAllRecords().indexOf(old);
        registrationDatabase.returnAllRecords().set(index, updated);

        // Increase available seats as the member canceled
        Class classRecord = classDatabase.getRecord(classID);
        classRecord.setAvailableSeats(classRecord.getAvailableSeats() + 1);

        // Check if a refund is applicable (within 3 days)
        if (daysBetween <= 3) {
            System.out.println("Refund issued for cancellation within 3 days of registration");
        } else {
            System.out.println("No refund issued - cancellation made after 3 days of registration");
        }
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations(){
        return this.registrationDatabase.returnAllRecords();
    }

    public void logout(){
        this.memberDatabase.saveToFile();
        this.classDatabase.saveToFile();
        this.registrationDatabase.saveToFile();
        System.out.println("logged out");
    }
}
