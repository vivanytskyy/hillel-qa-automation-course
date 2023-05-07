package com.gmail.ivanytskyy.vitaliy.homework08;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 06/05/2023
 */
public class Player {
    private final String name;

    public Player(String name) throws InvalidInputArgumentException {
        if(name == null || name.isBlank()){
            throw new InvalidInputArgumentException("name: " + name);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
