package org.example.trainer;

import org.example.User;

public class Member implements User {
    private final String memberID, membershipType, status, name, email, phoneNumber;
    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        this.memberID = memberID;
        this.membershipType = membershipType;
        this.status = status;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        return String.format("%s,%s,%s,%s,%s,%s", memberID, name, membershipType, email, phoneNumber, status);
    }
    @Override
    public String getSearchKey() {
        return memberID;
    }
}
