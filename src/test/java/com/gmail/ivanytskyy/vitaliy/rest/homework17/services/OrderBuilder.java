package com.gmail.ivanytskyy.vitaliy.rest.homework17.services;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers.StoreController;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Order;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 03/07/2023
 */
public class OrderBuilder {
    private Long id;
    private Long petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;
    public OrderBuilder(){
        this.id = 111L;
        this.petId = 222L;
        this.quantity = 3;
        this.shipDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+0000'").format(new Date());
        this.status = StoreController.OrderStatus.PLACED.toString().toLowerCase();
        this.complete = true;
    }
    public Order build(){
        Order order = new Order();
        order.setId(this.id);
        order.setPetId(this.petId);
        order.setQuantity(this.quantity);
        order.setShipDate(this.shipDate);
        order.setStatus(this.status);
        order.setComplete(this.complete);
        return order;
    }
    public OrderBuilder setId(Long id) {
        this.id = id;
        return this;
    }
    public OrderBuilder setPetId(Long petId) {
        this.petId = petId;
        return this;
    }
    public OrderBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
    public OrderBuilder setShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }
    public OrderBuilder setStatus(StoreController.OrderStatus status) {
        this.status = status.toString().toLowerCase();
        return this;
    }
    public OrderBuilder setComplete(Boolean complete) {
        this.complete = complete;
        return this;
    }
}