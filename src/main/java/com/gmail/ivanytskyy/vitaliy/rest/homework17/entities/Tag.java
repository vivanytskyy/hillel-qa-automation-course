package com.gmail.ivanytskyy.vitaliy.rest.homework17.entities;

import lombok.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 02/07/2023
 */
@Data
public class Tag {
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private String name;
}