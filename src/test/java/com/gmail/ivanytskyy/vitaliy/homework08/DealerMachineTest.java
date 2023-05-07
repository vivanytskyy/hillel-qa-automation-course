package com.gmail.ivanytskyy.vitaliy.homework08;

import com.gmail.ivanytskyy.vitaliy.homework08.service.CardDeckForTesting;
import com.gmail.ivanytskyy.vitaliy.homework08.service.DealerMachineBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 07/05/2023
 */
public class DealerMachineTest {
    private DealerMachineBuilder dealerMachineBuilder;

    @BeforeTest
    public void preCondition() {
       this.dealerMachineBuilder = new DealerMachineBuilder();
    }

    @Test(description = "Positive test case with correct input values, mustn't be any Exception")
    public void testDealerMachineCreation() {
        DealerMachine dealerMachine = dealerMachineBuilder.build();
        dealerMachine.distributeTheCards();
    }

    @Test(description = "Negative test: Players[] = null",
            expectedExceptions = InvalidInputArgumentException.class)
    public void testDealerMachineCreationPlayersArrayIsNull() {
        dealerMachineBuilder.setPlayers(null);
        dealerMachineBuilder.build();
    }

    @Test(description = "Negative test: players.length = null",
            expectedExceptions = InvalidInputArgumentException.class)
    public void testDealerMachineCreationPlayersArrayLengthIsZero() {
        Player[] players = {};
        dealerMachineBuilder.setPlayers(players);
        dealerMachineBuilder.build();
    }

    @Test(description = "Negative test: Player obj = null",
            expectedExceptions = InvalidInputArgumentException.class)
    public void testDealerMachineCreationPlayerIsNull() {
        Player[] players = {
                new Player("Player 1"),
                null,
                new Player("Player 3")
        };
        dealerMachineBuilder.setPlayers(players);
        dealerMachineBuilder.build();
    }

    @Test(description = "Negative test: cardsForPlayer < 0",
            expectedExceptions = InvalidInputArgumentException.class)
    public void testDealerMachineCreationCardsForPlayerIsLessZero() {
        dealerMachineBuilder.setCardsForPlayer(-1);
        dealerMachineBuilder.build();
    }

    @Test(description = "Negative test: cardsForPlayer = 0",
            expectedExceptions = InvalidInputArgumentException.class)
    public void testDealerMachineCreationCardsForPlayerIsZero() {
        dealerMachineBuilder.setCardsForPlayer(0);
        dealerMachineBuilder.build();
    }

    @Test(description = "Negative test: cardDeck = null",
            expectedExceptions = InvalidInputArgumentException.class)
    public void testDealerMachineCreationCardDeckIsNull() {
        dealerMachineBuilder.setCardDeck(null);
        dealerMachineBuilder.build();
    }

    @Test(description = "Negative test: cardsForDistribution > cardDeck.getSize()",
            expectedExceptions = CardsDistributionException.class,
            expectedExceptionsMessageRegExp = "Number of cards for distribution: 6, number of cards in the deck: 3")
    public void testDealerMachineCreationCardsForDistributionMoreThanCardDeckSize() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player[] players = {player1, player2, player3};
        dealerMachineBuilder.setPlayers(players);
        Card card1 = new Card("2", "clubs");
        Card card2 = new Card("King", "hearts");
        Card card3 = new Card("Jack", "spades");
        CardDeck cardDeck = new CardDeckForTesting(card1, card2, card3);
        dealerMachineBuilder.setCardDeck(cardDeck);
        // cardsForDistribution = cardsForPlayer * players.length -> 6 is more than cardDeck.size() -> 3
        int wrongNumberOfCardsForPlayer = 2;
        dealerMachineBuilder.setCardsForPlayer(wrongNumberOfCardsForPlayer);
        dealerMachineBuilder.build();
    }

    @AfterTest
    public void postCondition(){
        dealerMachineBuilder = null;
    }
}
