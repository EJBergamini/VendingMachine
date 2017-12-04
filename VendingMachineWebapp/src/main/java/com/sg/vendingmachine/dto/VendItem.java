/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author EJB Laptop
 */
public class VendItem {
    private int itemLocation;
    private String itemName;
    private BigDecimal itemCost;
    private int numberOfItems;

    public VendItem() {
        
    }
    
    public VendItem(int itemLocation) {
        this.itemLocation = itemLocation;
    }

    public int getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(int itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.itemLocation);
        hash = 31 * hash + Objects.hashCode(this.itemName);
        hash = 31 * hash + Objects.hashCode(this.itemCost);
        hash = 31 * hash + this.numberOfItems;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendItem other = (VendItem) obj;
        if (this.numberOfItems != other.numberOfItems) {
            return false;
        }
        if (!Objects.equals(this.itemLocation, other.itemLocation)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemCost, other.itemCost)) {
            return false;
        }
        return true;
    }
    
    
}
