package com.gmail.ivanytskyy.vitaliy.homework08.service;

import com.gmail.ivanytskyy.vitaliy.homework08.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 07/05/2023
 */
public class DealerMachineBuilder {
    private Player[] players;
    private int cardsForPlayer;
    private CardDeck cardDeck;
    public DealerMachineBuilder() {
        this.players = new Player[]{
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
        };
        this.cardsForPlayer = 5;
        this.cardDeck = new FrenchSuitedDeck();
    }

    public DealerMachine build() {
        return new DealerMachine(players, cardsForPlayer, cardDeck);
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setCardsForPlayer(int cardsForPlayer) {
        this.cardsForPlayer = cardsForPlayer;
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }
}
