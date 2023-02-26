package com.techelevator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Item {
    @NotEmpty
    private int itemId;
    @NotEmpty
    private int listId;
    @NotEmpty
    private int groupId;
    private boolean status;
    @NotEmpty
    private String dateModified;
    //TODO: lastModifier defaults to creator of the list.
    private int lastModifier;
    @Min(1)
    @Max(64)





    private int quantity;

    private String itemName;

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public int getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(int lastModifier) {
        this.lastModifier = lastModifier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", listId=" + listId +
                ", groupId=" + groupId +
                ", dateModified='" + dateModified + '\'' +
                ", lastModifier=" + lastModifier +
                ", quantity=" + quantity +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
