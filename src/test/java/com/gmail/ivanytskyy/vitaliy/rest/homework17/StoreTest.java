package com.gmail.ivanytskyy.vitaliy.rest.homework17;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers.StoreController;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Order;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.services.OrderBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 03/07/2023
 */
public class StoreTest {
    private StoreController storeController;
    @BeforeMethod
    public void setUp(){
        storeController = new StoreController();
    }
    @AfterMethod
    public void tearDown(){
        storeController = null;
    }
    @Test(priority = 10)
    public void placeOrderForPetTest() throws IOException {
        Order defaultOrder = new OrderBuilder().build();
        Order addedOrder = storeController.placeOrderForPet(defaultOrder);
        Assert.assertEquals(addedOrder.toString(), defaultOrder.toString());
    }
    @Test(priority = 20)
    public void findPurchaseOrderByIdTest() throws IOException {
        Order defaultOrder = new OrderBuilder().build();
        Order addedOrder = storeController.placeOrderForPet(defaultOrder);
        Assert.assertEquals(addedOrder.toString(), defaultOrder.toString());
        long id = addedOrder.getId();
        Order resultOrder = storeController.findPurchaseOrderById(id);
        Assert.assertEquals(resultOrder.toString(), addedOrder.toString());
    }
    @Test(priority = 30)
    public void deletePurchaseOrderByIdTest() throws IOException {
        Order defaultOrder = new OrderBuilder().build();
        Order addedOrder = storeController.placeOrderForPet(defaultOrder);
        Assert.assertEquals(addedOrder.toString(), defaultOrder.toString());
        long targetId = addedOrder.getId();
        int code = storeController.deletePurchaseOrderById(targetId);
        Assert.assertEquals(code, 200);
    }
    @Test(priority = 40)
    public void returnPetInventoriesByStatusTest() throws IOException {
        int code = storeController.returnPetInventoriesByStatus();
        Assert.assertEquals(code, 200);
    }
}