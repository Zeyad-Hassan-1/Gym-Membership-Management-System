package org.example.trainer;

import org.example.User;

public class Member extends User {
    private final String memberID, membershipType, status;
    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        super(name, email, phoneNumber);
        this.memberID = memberID;
        this.membershipType = membershipType;
        this.status = status;
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
