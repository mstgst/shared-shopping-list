package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class List {
    @NotEmpty
    private int listId;
    @NotEmpty
    private int groupId;
    private String description;
    @NotEmpty
    private String listName;
    private int claimedId;
    private boolean listCompleted;
    private String dateModified;


    public boolean isListCompleted() {
        return listCompleted;
    }

    public void setListCompleted(boolean listCompleted) {
        this.listCompleted = listCompleted;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public int getClaimedId() {
        return claimedId;
    }

    public void setClaimedId(int claimedId) {
        this.claimedId = claimedId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String toString() {
        return "List{" +
                "listId=" + listId +
                ", groupId=" + groupId +
                ", description='" + description + '\'' +
                ", listName='" + listName + '\'' +
                ", claimedId=" + claimedId +
                ", listCompleted=" + listCompleted +
                ", dateModified='" + dateModified + '\'' +
                '}';
    }
}
