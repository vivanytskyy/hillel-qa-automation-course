package com.gmail.ivanytskyy.vitaliy.homework08;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 06/05/2023
 */
public class DealerMachine {
    private final Player[] players;
    private final CardDeck cardDeck;
    private final int cardsForDistribution;

    public DealerMachine(Player[] players, int cardsForPlayer, CardDeck cardDeck)
            throws InvalidInputArgumentException, CardsDistributionException {
        if(players == null
                || players.length == 0
                || !Arrays.stream(players).allMatch(Objects::nonNull)
                || cardsForPlayer <= 0
                || cardDeck == null){
            throw new InvalidInputArgumentException("\n"
                    + "players: " + Arrays.toString(players) + ", "
                    + "cardsForPlayer: " + cardsForPlayer + ", "
                    + "CardDeck: " + cardDeck);
        }
        this.players = players;
        this.cardDeck = cardDeck;
        int cardsForDistribution = cardsForPlayer * players.length;
        if(cardsForDistribution > cardDeck.getSize()){
            throw new CardsDistributionException(cardsForDistribution, cardDeck.getSize());
        }
        this.cardsForDistribution = cardsForDistribution;
    }

    public void distributeTheCards() throws InvalidInputArgumentException, CardsDistributionException {
        Card[] cards = cardDeck.getCards();
        if(cardsForDistribution > cards.length){
            throw new CardsDistributionException(cardsForDistribution, cards.length);
        }
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

    private void shuffleTheCards(Card[] cards) throws InvalidInputArgumentException {
        if(cards == null || cards.length == 0){
            throw new InvalidInputArgumentException("cards: " + Arrays.toString(cards));
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