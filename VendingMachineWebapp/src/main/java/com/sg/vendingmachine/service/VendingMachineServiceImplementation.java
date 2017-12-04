/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDaoInterface;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.VendItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class VendingMachineServiceImplementation implements VendingMachineServiceInterface {
    
    public VendingMachineDaoInterface dao;

    private BigDecimal userBalance;
    
    private int itemSelected;
    
    private String message = "Welcome!";
    
    private Change balance = new Change();
    
    public VendingMachineServiceImplementation(VendingMachineDaoInterface dao) {
        this.dao = dao;
        this.userBalance = new BigDecimal("0.00");
    }

    @Override
    public List<VendItem> listAllItems() {
        return dao.getAllItems();
    }

    @Override
    public void purchaseAnItem(int itemSelected) {
        //this method ties all the other service methods together when the user purchases an item.
        VendItem itemChoice = getItemBySlot(itemSelected); 
        if (checkItemInStock(itemChoice) && checkSufficientFunds(itemChoice)) {
            decreaseInventory(itemChoice);
            decreaseFunds(itemChoice);
            String messageOut = "Thank you for your purchase!";
            setMessage(messageOut);
        }   else if (checkItemInStock(itemChoice) && false == checkSufficientFunds(itemChoice)) {
            String messageOut = "ISF! - Please deposit: ";
            setMessage(messageOut + userBalance.subtract(itemChoice.getItemCost()).negate());
        }   else if (checkItemInStock(itemChoice) == false && checkSufficientFunds(itemChoice)) {
            String messageOut = "ERR: SOLD OUT!!";
            setMessage(messageOut);
        }   else {
            String messageOut = "NO VEND: ISF or 0qty.";
            setMessage(messageOut);
        }   
    }

    @Override
    public void decreaseInventory(VendItem itemChoice) {
        itemChoice.setNumberOfItems(itemChoice.getNumberOfItems()-1);
        dao.updateItem(itemChoice);
    }

    @Override
    public boolean checkSufficientFunds(VendItem item) {
        if (userBalance.compareTo(item.getItemCost()) != -1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkItemInStock(VendItem item) {
        if (item.getNumberOfItems() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public BigDecimal getUserBalance() {
        return userBalance;
    }

    @Override   
    public BigDecimal decreaseFunds (VendItem item) {
        userBalance = userBalance.subtract(item.getItemCost());
        return userBalance;
    }
    
    @Override
    public Change calculateChange() {
        
        int balanceIntegers = userBalance.multiply(new BigDecimal("100.00")).intValue();
        
        int myInt = ((balanceIntegers - (balanceIntegers % 100)) / 100);
        
        balance.setUserDollars(((balanceIntegers - (balanceIntegers % 100)) / 100));
        balanceIntegers = balanceIntegers - (balanceIntegers - (balanceIntegers % 100));
        balance.setUserQuarters(((balanceIntegers - (balanceIntegers % 25)) / 25));
        balanceIntegers = balanceIntegers - (balanceIntegers - (balanceIntegers % 25));
        balance.setUserDimes(((balanceIntegers - (balanceIntegers % 10)) / 10));
        balanceIntegers = balanceIntegers - (balanceIntegers - (balanceIntegers % 10));
        balance.setUserNickels(((balanceIntegers - (balanceIntegers % 5)) / 5));
        balanceIntegers = balanceIntegers - (balanceIntegers - (balanceIntegers % 5));
        balance.setUserPennies(balanceIntegers);
        userBalance = new BigDecimal("0");
        return balance;
    }

    @Override
    public VendItem getItemBySlot(int itemLocation) {
        return dao.getItem(itemLocation);
    }
    
    @Override
    public BigDecimal addUserDeposit(BigDecimal userMoney) {
        userBalance = userBalance.add(userMoney);
        return userBalance;
    }
    //new stuff
    @Override
    public BigDecimal getUserMoney() {
        return userBalance;
    }
    
    @Override
    public void setUserMoney(BigDecimal userMoneyIn) {
        userBalance = userBalance.add(userMoneyIn);
    }

    @Override
    public int getCurrentSelectedSlot() {
        return itemSelected;
    }

    @Override
    public void setCurrentSelectedSlot(int itemSelection) {
        itemSelected = itemSelection;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    @Override
    public void setMessage(String messageOut) {
        message = messageOut;
    }
    
    @Override
    public Change getChange() {
        calculateChange();
        return balance;
    }
}
