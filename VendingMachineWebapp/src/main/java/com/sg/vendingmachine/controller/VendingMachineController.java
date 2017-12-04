/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.VendItem;
import com.sg.vendingmachine.service.VendingMachineServiceInterface;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author EJB Laptop
 */

@Controller
public class VendingMachineController {
    
    VendingMachineServiceInterface service;
    
    @Inject
    public VendingMachineController(VendingMachineServiceInterface service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayAllItems(Model model) {
        // Get all the Contacts from the DAO
        List<VendItem> itemList = service.listAllItems();

        //retrieve the selected item from service and display to page
        int selectedSlot = service.getCurrentSelectedSlot();
        model.addAttribute("itemNumberOutput", selectedSlot);
        
        //retrieve the balance from service and display to page
        BigDecimal userBalance = service.getUserMoney();
        model.addAttribute("moneyInDisplay", userBalance);
        
        // Put the List of Contacts on the Model
        model.addAttribute("itemList", itemList);
        
        //Output a message
        String displayMessage = service.getMessage();
        model.addAttribute("messagesOutDisplay", displayMessage);

        
        return "VendingMachine";
    }
    
    @RequestMapping(value="/getItemSelection", method = RequestMethod.GET)
    public String getItemSelection(HttpServletRequest request, Model model) {
        String itemSelected = request.getParameter("itemSelected");
        int itemSelection = Integer.parseInt(itemSelected);
        service.setCurrentSelectedSlot(itemSelection);
        return "redirect:/";
    }
    
    @RequestMapping(value="/addUserMoney", method = RequestMethod.GET)
    public String addUserMoney(HttpServletRequest request, Model model) {
        String moneyIn  = request.getParameter("money");
        BigDecimal userMoney = new BigDecimal(moneyIn);
        service.addUserDeposit(userMoney);
        return "redirect:/";
    }
            
    @RequestMapping(value="/makeAPurchase", method = RequestMethod.GET)        
    public String makeAPurchase(HttpServletRequest request, Model model) {
        String itemSelected = request.getParameter("itemSelected");
        int itemSelection = Integer.parseInt(itemSelected);
        service.purchaseAnItem(itemSelection);
        return "redirect:/";
    }
    
    @RequestMapping(value="/makeChange", method = RequestMethod.GET)
    public String makeChange(HttpServletRequest request, Model model) {
        Change change = service.getChange();
        model.addAttribute("dollar", "Dollars " + change.getUserDollars());        
        model.addAttribute("quarter", "      Quarters: " + change.getUserQuarters());       
        model.addAttribute("dime", "Dimes: " + change.getUserDimes());       
        model.addAttribute("nickel", "    Nickels: " + change.getUserNickels());
        return "redirect:/";
    }
    
}
