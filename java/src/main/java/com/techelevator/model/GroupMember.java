package com.techelevator.model;

import java.util.List;

public class GroupMember {
    private int groupId;
    private int memberId;
    private String dateJoined;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getDateJoined() {
        return dateJoined;
    }


    @Override
    public String toString() {
        return "GroupMember{" +
                "groupId=" + groupId +
                ", memberId=" + memberId +
                ", dateJoined='" + dateJoined + '\'' +
                '}';
    }
}
