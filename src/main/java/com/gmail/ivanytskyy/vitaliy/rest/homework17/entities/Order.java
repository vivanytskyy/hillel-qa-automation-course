package com.gmail.ivanytskyy.vitaliy.rest.homework17.entities;

import lombok.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 03/07/2023
 */
@Data
public class Order {
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private Long petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;
}