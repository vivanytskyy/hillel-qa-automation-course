package com.gmail.ivanytskyy.vitaliy.homework08;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 06/05/2023
 */
public class CardsDistributionException extends RuntimeException{
    public CardsDistributionException(int cardsForDistribution, int cardDeckSize) {
        super("Number of cards for distribution: " + cardsForDistribution
                + ", number of cards in the deck: " + cardDeckSize);
    }
}