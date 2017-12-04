/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

/**
 *
 * @author EJB Laptop
 */
public class Change {
    private int userPennies;
    private int userNickels;
    private int userDimes;
    private int userQuarters;
    private int userDollars;

    public int getUserPennies() {
        return userPennies;
    }

    public void setUserPennies(int userPennies) {
        this.userPennies = userPennies;
    }

    public int getUserNickels() {
        return userNickels;
    }

    public void setUserNickels(int userNickels) {
        this.userNickels = userNickels;
    }

    public int getUserDimes() {
        return userDimes;
    }

    public void setUserDimes(int userDimes) {
        this.userDimes = userDimes;
    }

    public int getUserQuarters() {
        return userQuarters;
    }

    public void setUserQuarters(int userQuarters) {
        this.userQuarters = userQuarters;
    }

    public int getUserDollars() {
        return userDollars;
    }

    public void setUserDollars(int userDollars) {
        this.userDollars = userDollars;
    }
    
    
    
}
