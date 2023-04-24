package com.gmail.ivanytskyy.vitaliy.homework06;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/04/2023
 */
public class Player {
    private final String name;

    public Player(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Incorrect input value");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
