/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.VendItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface VendingMachineServiceInterface {
    
    //things my vending machine should do (the things it can compute):
    
    List<VendItem> listAllItems();
    
    void purchaseAnItem(int userChoice); //(this actually takes in two items - usermoney and the item itself)
    
    void decreaseInventory(VendItem itemChoice);
    
    boolean checkSufficientFunds(VendItem item);
    
    boolean checkItemInStock(VendItem item);
    
    BigDecimal getUserBalance();
    
    Change calculateChange();
    
    VendItem getItemBySlot(int itemLocation); //(item?)
    
    BigDecimal addUserDeposit(BigDecimal userMoney);
    
    BigDecimal getUserMoney();
    
    void setUserMoney(BigDecimal userMoneyIn);
    
    BigDecimal decreaseFunds(VendItem item);
    
    int getCurrentSelectedSlot();
    
    void setCurrentSelectedSlot(int itemSelection);
    
    String getMessage();
    
    void setMessage(String messageOut);
    
    Change getChange();
    
}
