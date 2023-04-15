package com.gmail.ivanytskyy.vitaliy.homework04;

import java.util.Arrays;
import java.util.Random;

/*
* Task 4
* Задача просунуого рівня (виконання необов'язкове, але вітається).
* Написати програму, яка імітує роботу автомату з покеру, а саме роздає карти гравцям.
* За столом сидять 4 гравці, кожен з них отримує 5 карт.
* Карти не можуть повторюватися та йти одна за одною.
* Формат виводу на екран: "Гравець N отримує карту <НАЗВА КАРТИ>"
*/
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 14/04/2023
 */
public class CardDealerMachine {
    private final String[] cardSuits = {"hearts", "tiles", "clovers", "pikes"};
    private final String[] cardValues =
            {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args){
        CardDealerMachine cardDealer = new CardDealerMachine();
        int cardsForPlayer = 5;
        String[] players = {"Player 1", "Player 2", "Player 3", "Player 4"};
        String[] cardDeck = cardDealer.createCardDeck();
        CardDealerMachine.shuffleTheCardDeck(cardDeck);
        int cardsForDistribution = cardsForPlayer * players.length;
        int cardCounter = 0;
        int iteration = 1;
        while(cardCounter < cardsForDistribution){
            System.out.println("\n" + "Iteration: " + iteration++);
            for(String player : players){
                System.out.println(player + " gets the card: " + cardDeck[cardCounter++]);
            }
        }
    }
    public static void shuffleTheCardDeck(String[] cardDeck){
        if(cardDeck == null || cardDeck.length == 0)
            throw new IllegalArgumentException("Incorrect input value: " + Arrays.toString(cardDeck));
        Random randGenerator = new Random();
        for (int i = cardDeck.length - 1; i > 0; i--) {
            int index = randGenerator.nextInt(i + 1);
            String temp = cardDeck[index];
            cardDeck[index] = cardDeck[i];
            cardDeck[i] = temp;
        }
    }
    private String[] createCardDeck(){
        String[] newCardDeck = new String[cardSuits.length * cardValues.length];
        int index = 0;
        for(String suit : cardSuits){
            for(String value : cardValues){
                newCardDeck[index++] = value + " of " + suit;
            }
        }
        return newCardDeck;
    }
}
