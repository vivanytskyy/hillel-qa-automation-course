package com.gmail.ivanytskyy.vitaliy.homework08;

/*
 * Task 1
 * В нашій програмі для покеру (див. homework06) є потенційні місця, де можуть виникати помилки,
 * а також де можна генерувати власні виключення.
 * Потрібно такі місця знайти і якось обробити, а також інтегрувати власні типи Exception.
 */

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 06/05/2023
 */
public class PokerCasino {

    public static void main(String[] args) {
        try {
            Player[] players = {
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
            };
            int cardsForPlayers = 5;
            CardDeck cardDeck = new FrenchSuitedDeck();
            DealerMachine dealerMachine = new DealerMachine(players, cardsForPlayers, cardDeck);
            dealerMachine.distributeTheCards();
        } catch (InvalidInputArgumentException | CardsDistributionException | CardDeckCreationException e) {
            e.printStackTrace();
        }
    }
}