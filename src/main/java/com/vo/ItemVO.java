package com.vo;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.stereotype.Component;

@Component("items")
public class ItemVO {
    public ItemVO() {
    }

    private int itemId;
    private String itemName;
    private double itemPrice;
    private boolean itemInStock;
    private int itemQuantity;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean getItemStock() {
        return itemInStock;
    }

    public void setItemInStock(boolean itemInStock) {
        this.itemInStock = itemInStock;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
