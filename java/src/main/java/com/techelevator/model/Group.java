package com.techelevator.model;



import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private int groupOwnerId;
    private String groupCode;
    private String dateCreated;

    public String getGroupCode() {
        return groupCode;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String datedCreated) {
        this.dateCreated = datedCreated;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public int getGroupOwnerId() {
        return groupOwnerId;
    }

    public void setGroupOwnerId(int groupOwnerId) {
        this.groupOwnerId = groupOwnerId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                ", groupOwnerId=" + groupOwnerId +
                ", groupCode='" + groupCode + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}

