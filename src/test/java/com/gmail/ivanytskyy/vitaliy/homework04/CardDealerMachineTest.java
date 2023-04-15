package com.gmail.ivanytskyy.vitaliy.homework04;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/04/2023
 */
public class CardDealerMachineTest {
    private final String[] exemplaryCardDeck = {
            // hearts
            "2 of hearts", "3 of hearts", "4 of hearts", "5 of hearts", "6 of hearts", "7 of hearts", "8 of hearts",
            "9 of hearts", "10 of hearts", "Jack of hearts", "Queen of hearts", "King of hearts", "Ace of hearts",
            // tiles
            "2 of tiles", "3 of tiles", "4 of tiles", "5 of tiles", "6 of tiles", "7 of tiles", "8 of tiles",
            "9 of tiles", "10 of tiles", "Jack of tiles", "Queen of tiles", "King of tiles", "Ace of tiles",
            // clovers
            "2 of clovers", "3 of clovers", "4 of clovers", "5 of clovers", "6 of clovers", "7 of clovers", "8 of clovers",
            "9 of clovers", "10 of clovers", "Jack of clovers", "Queen of clovers", "King of clovers", "Ace of clovers",
            // pikes
            "2 of pikes", "3 of pikes", "4 of pikes", "5 of pikes", "6 of pikes", "7 of pikes", "8 of pikes",
            "9 of pikes", "10 of pikes", "Jack of pikes", "Queen of pikes", "King of pikes", "Ace of pikes"
    };

    @Test(description = "Checking for duplicates")
    public void testShuffleTheCardDeckIsNotDuplicates(){
        String[] cardDeckForCompare = new String[exemplaryCardDeck.length];
        System.arraycopy(exemplaryCardDeck, 0, cardDeckForCompare, 0, exemplaryCardDeck.length);
        String[] cardDeckForShuffle = new String[exemplaryCardDeck.length];
        System.arraycopy(exemplaryCardDeck, 0, cardDeckForShuffle, 0, exemplaryCardDeck.length);
        CardDealerMachine.shuffleTheCardDeck(cardDeckForShuffle);
        Arrays.sort(cardDeckForCompare);
        Arrays.sort(cardDeckForShuffle);
        Assert.assertEquals(cardDeckForShuffle, cardDeckForCompare);
    }

    @Test(description = "Checking for shuffle")
    public void testShuffleTheCardDeckIsShuffled(){
        String[] cardDeckForCompare = new String[exemplaryCardDeck.length];
        System.arraycopy(exemplaryCardDeck, 0, cardDeckForCompare, 0, exemplaryCardDeck.length);
        String[] cardDeckForShuffle = new String[exemplaryCardDeck.length];
        System.arraycopy(exemplaryCardDeck, 0, cardDeckForShuffle, 0, exemplaryCardDeck.length);
        CardDealerMachine.shuffleTheCardDeck(cardDeckForShuffle);
        int coincidence = 0;
        for(int i = 0; i < cardDeckForCompare.length; i++){
            if(cardDeckForShuffle[i].equals(cardDeckForCompare[i])) coincidence++;
        }
        Assert.assertTrue(coincidence < cardDeckForCompare.length/2);
    }

    @Test(description = "Negative test: cardDesk == null",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Incorrect input value: null")
    public void testShuffleTheCardDeckArrayIsNull(){
        CardDealerMachine.shuffleTheCardDeck(null);
    }

    @Test(description = "Negative test: cardDesk.length == 0",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Incorrect input value: \\[]")
    public void testShuffleTheCardDeckArrayIsEmpty(){
        CardDealerMachine.shuffleTheCardDeck(new String[]{});
    }
}
