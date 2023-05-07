package com.gmail.ivanytskyy.vitaliy.homework08.service;

import com.gmail.ivanytskyy.vitaliy.homework08.Card;
import com.gmail.ivanytskyy.vitaliy.homework08.CardDeck;
import java.util.Arrays;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 07/05/2023
 */
public class CardDeckForTesting extends CardDeck {
    private final Card[] cards;
    public CardDeckForTesting(Card ... cards){
        this.cards = cards;
    }

    @Override
    public Card[] getCards() {
        return cards;
    }

    @Override
    public int getSize() {
        return cards.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(cards);
    }
}
