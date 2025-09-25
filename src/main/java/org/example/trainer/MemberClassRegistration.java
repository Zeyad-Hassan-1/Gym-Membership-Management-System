package org.example.trainer;

import org.example.User;

import java.time.LocalDate;

public class MemberClassRegistration implements User {
    private String memberId;
    private String classId;
    private String statue;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberId, String classId, String statue, LocalDate registrationDate) {
        this.memberId = memberId;
        this.classId = classId;
        this.statue = statue;
        this.registrationDate = registrationDate;
    }


    public String getClassId() {
        return classId;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }


    @Override
    public String lineRepresentation() {
        return String.format("%s,%s,%s,%s",memberId,classId,statue,registrationDate.toString());
    }

    @Override
    public String getSearchKey() {
        return getMemberId()+getClassId();
    }
}
