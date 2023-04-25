package com.gmail.ivanytskyy.vitaliy.homework06;

import java.util.Arrays;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/04/2023
 */
public class FrenchSuitedDeck extends CardDeck {
    private static final String[] SUITS = {"clubs", "diamonds", "hearts", "spades"};
    private static final String[] VALUES =
            {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int CARDS_IN_DECK = SUITS.length * VALUES.length;
    private final Card[] cards;

    public FrenchSuitedDeck(){
        this.cards = new Card[CARDS_IN_DECK];
        int index = 0;
        for(String suit : SUITS){
            for(String value : VALUES){
                cards[index++] = new Card(value, suit);
            }
        }
    }

    @Override
    public Card[] getCards() {
        return cards;
    }

    @Override
    public int getSize() {
        return CARDS_IN_DECK;
    }

    @Override
    public String toString() {
        return Arrays.toString(cards);
    }
}