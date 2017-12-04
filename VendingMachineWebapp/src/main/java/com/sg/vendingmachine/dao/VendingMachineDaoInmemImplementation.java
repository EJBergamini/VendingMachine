/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author EJB Laptop
 */
public class VendingMachineDaoInmemImplementation implements VendingMachineDaoInterface {

    Map<Integer, VendItem> itemList = new HashMap<>();
    
    public VendingMachineDaoInmemImplementation() {
        
        VendItem vendItem1 = new VendItem(1);
        vendItem1.setItemName("Snickers");
        vendItem1.setItemCost(new BigDecimal("1.50"));
        vendItem1.setNumberOfItems(10);
        itemList.put(vendItem1.getItemLocation(), vendItem1);
        
        VendItem vendItem2 = new VendItem(2);
        vendItem2.setItemName("M&Ms");
        vendItem2.setItemCost(new BigDecimal("1.25"));
        vendItem2.setNumberOfItems(8);
        itemList.put(vendItem2.getItemLocation(), vendItem2);
        
        VendItem vendItem3 = new VendItem(3);
        vendItem3.setItemName("Almond Joy");
        vendItem3.setItemCost(new BigDecimal("1.25"));
        vendItem3.setNumberOfItems(10);
        itemList.put(vendItem3.getItemLocation(), vendItem3);
        
        VendItem vendItem4 = new VendItem(4);
        vendItem4.setItemName("Milky Way");
        vendItem4.setItemCost(new BigDecimal("1.65"));
        vendItem4.setNumberOfItems(3);
        itemList.put(vendItem4.getItemLocation(), vendItem4);
        
        VendItem vendItem5 = new VendItem(5);
        vendItem5.setItemName("PayDay");
        vendItem5.setItemCost(new BigDecimal("1.75"));
        vendItem5.setNumberOfItems(2);
        itemList.put(vendItem5.getItemLocation(), vendItem5);
        
        VendItem vendItem6 = new VendItem(6);
        vendItem6.setItemName("Reese's");
        vendItem6.setItemCost(new BigDecimal("1.50"));
        vendItem6.setNumberOfItems(5);
        itemList.put(vendItem6.getItemLocation(), vendItem6);
        
        VendItem vendItem7 = new VendItem(7);
        vendItem7.setItemName("Pringles");
        vendItem7.setItemCost(new BigDecimal("2.35"));
        vendItem7.setNumberOfItems(4);
        itemList.put(vendItem7.getItemLocation(), vendItem7);
        
        VendItem vendItem8 = new VendItem(8);
        vendItem8.setItemName("CheezIts");
        vendItem8.setItemCost(new BigDecimal("2.00"));
        vendItem8.setNumberOfItems(6);
        itemList.put(vendItem8.getItemLocation(), vendItem8);
        
        VendItem vendItem9 = new VendItem(9);
        vendItem9.setItemName("Doritos");
        vendItem9.setItemCost(new BigDecimal("1.95"));
        vendItem9.setNumberOfItems(7);
        itemList.put(vendItem9.getItemLocation(), vendItem9);
    }

    @Override
    public List<VendItem> getAllItems() {
	return new ArrayList<VendItem>(itemList.values());
    }

    @Override
    public VendItem addItem(VendItem item) {
        VendItem changedItem = itemList.put(item.getItemLocation(), item);
        return changedItem;
    }

    @Override
    public VendItem getItem(int itemLocation) {
        VendItem item = itemList.get(itemLocation);
        return item;
    }

    @Override
    public VendItem updateItem(VendItem item) {
        VendItem changedItem = itemList.put(item.getItemLocation(), item);
        return changedItem;
    }

    @Override
    public void deleteItem(int itemLocation) {
        itemList.remove(itemLocation);
    }
    
}
