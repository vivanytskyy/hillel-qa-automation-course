package com.gmail.ivanytskyy.vitaliy.rest.homework17.entities;

import lombok.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 04/07/2023
 */
@Data
public class User {
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;
}