/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendItem;
import com.sg.vendingmachine.dao.VendingMachineDaoInmemImplementation;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author EJB Laptop
 */

public class VendingMachineDaoImplementationTest {
    
    private VendingMachineDaoInmemImplementation dao;
    
    public VendingMachineDaoImplementationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("vendingMachineDao", VendingMachineDaoInmemImplementation.class);
        for (VendItem vendItem : dao.getAllItems()) {
            dao.deleteItem(vendItem.getItemLocation());
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteItem() {
        // Create new item
        VendItem nv = new VendItem();
        nv.setItemLocation(10);
        nv.setItemName("Godiva");
        nv.setItemCost(new BigDecimal("2.50"));
        nv.setNumberOfItems(10);
        dao.addItem(nv);
        VendItem fromDb = dao.getItem(nv.getItemLocation());
        assertEquals(fromDb, nv);
        dao.deleteItem(nv.getItemLocation());
        assertNull(dao.getItem(nv.getItemLocation()));
    }

    @Test
    public void addUpdateItem() {
        // Create new item
        VendItem nv = new VendItem();
        nv.setItemLocation(10);
        nv.setItemName("Godiva");
        nv.setItemCost(new BigDecimal("2.50"));
        nv.setNumberOfItems(10);
        dao.addItem(nv);
        
        nv.setNumberOfItems(20);
        
        dao.updateItem(nv);
        
        VendItem fromDb = dao.getItem(nv.getItemLocation());
        assertEquals(fromDb, nv);
    }

    @Test
    public void getAllItems() {
        // Create new item
        VendItem nv = new VendItem();
        nv.setItemLocation(25);
        nv.setItemName("Crackers");
        nv.setItemCost(new BigDecimal("1.50"));
        nv.setNumberOfItems(5);
        dao.addItem(nv);
        // Create new contact
        VendItem nv1 = new VendItem();
        nv1.setItemLocation(26);
        nv1.setItemName("Pretzels");
        nv1.setItemCost(new BigDecimal("1.75"));
        nv1.setNumberOfItems(4);
        dao.addItem(nv1);
        
        List<VendItem> vList = dao.getAllItems();
        assertEquals(vList.size(), 2);
    }

}
