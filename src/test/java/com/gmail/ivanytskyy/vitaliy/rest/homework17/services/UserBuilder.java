package com.gmail.ivanytskyy.vitaliy.rest.homework17.services;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.User;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 04/07/2023
 */
public class UserBuilder {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public UserBuilder() {
        this.id = 444L;
        this.username = "default_username";
        this.firstName = "John";
        this.lastName = "Smith";
        this.email = "default@email.com";
        this.password = "default_password";
        this.phone = "123456789";
        this.userStatus = 555;
    }
    public User build(){
        User user = new User();
        user.setId(this.id);
        user.setUsername(this.username);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setPhone(this.phone);
        user.setUserStatus(this.userStatus);
        return user;
    }
    public UserBuilder setId(Long id) {
        this.id = id;
        return this;
    }
    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }
    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserBuilder setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
        return this;
    }
}