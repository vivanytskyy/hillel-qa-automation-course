package com.gmail.ivanytskyy.vitaliy.homework06;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/04/2023
 */
public class DealerMachine {
    private final Player[] players;
    private final int cardsForPlayer;
    private final CardDeck cardDeck;

    public DealerMachine(Player[] players, int cardsForPlayer, CardDeck cardDeck){
        if(players == null || players.length == 0 || cardsForPlayer <= 0 || cardDeck == null){
            throw new IllegalArgumentException("Incorrect input values");
        }
        this.players = players;
        this.cardsForPlayer = cardsForPlayer;
        this.cardDeck = cardDeck;
    }

    public void distributeTheCards(){
        int cardsForDistribution = cardsForPlayer * players.length;
        if(cardsForDistribution > cardDeck.getSize()){
            throw new IllegalArgumentException("Number of cards for distribution more than number of cards in the deck");
        }
        Card[] cards = cardDeck.getCards();
        shuffleTheCards(cards);
        int cardCounter = 0;
        int iteration = 1;
        while(cardCounter < cardsForDistribution){
            System.out.println("\n" + "Iteration: " + iteration++);
            for(Player player : players){
                System.out.println(player.getName() + " gets the card: " + cards[cardCounter++]);
            }
        }
    }

    private void shuffleTheCards(Card[] cards){
        if(cards == null || cards.length == 0){
            throw new IllegalArgumentException("Incorrect input value: " + Arrays.toString(cards));
        }
        Random randGenerator = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int index = randGenerator.nextInt(i + 1);
            Card temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }
}