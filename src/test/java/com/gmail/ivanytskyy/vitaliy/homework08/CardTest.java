package com.gmail.ivanytskyy.vitaliy.homework08;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 07/05/2023
 */
public class CardTest {

    @Test(description = "Positive test case with correct input values")
    public void testCardCreation(){
        Card card = new Card("Jack", "clubs");
        Assert.assertEquals(card.toString(), "Jack of clubs");
    }

    @Test(description = "Negative test: value = null",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "value: null, suit: clubs")
    public void testCardCreationValueIsNull(){
        new Card(null, "clubs");
    }

    @Test(description = "Negative test: value is empty",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "value: , suit: clubs")
    public void testCardCreationValueIsEmpty(){
        new Card("", "clubs");
    }

    @Test(description = "Negative test: value is blank",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "value: " + "\\s{2}" + ", suit: clubs")
    public void testCardCreationValueIsBlank(){
        new Card("  ", "clubs");
    }

    @Test(description = "Negative test: suit = null",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "value: King, suit: null")
    public void testCardCreationSuitIsNull(){
        new Card("King", null);
    }

    @Test(description = "Negative test: suit is empty",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "value: King, suit: ")
    public void testCardCreationSuitIsEmpty(){
        new Card("King", "");
    }

    @Test(description = "Negative test: suit is blank",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "value: King, suit: " + "\\s{2}")
    public void testCardCreationSuitIsBlank(){
        new Card("King", "  ");
    }
}
