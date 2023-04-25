package com.gmail.ivanytskyy.vitaliy.homework06;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/04/2023
 */
public class Card {
    private final String value;
    private final String suit;

    public Card(String value, String suit) {
        if(value == null || value.isBlank() || suit == null || suit.isBlank()){
            throw new IllegalArgumentException("Incorrect input values");
        }
        this.value = value;
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}