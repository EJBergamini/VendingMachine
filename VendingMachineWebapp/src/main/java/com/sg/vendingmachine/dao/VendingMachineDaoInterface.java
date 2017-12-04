/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendItem;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface VendingMachineDaoInterface {
    
    List<VendItem> getAllItems();
    
    VendItem addItem(VendItem item);
    
    VendItem getItem(int itemLocation);  
    
    VendItem updateItem(VendItem item);
    
    void deleteItem (int itemLocation);
    
}
