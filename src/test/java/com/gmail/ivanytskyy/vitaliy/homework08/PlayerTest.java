package com.gmail.ivanytskyy.vitaliy.homework08;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 07/05/2023
 */
public class PlayerTest {

    @Test(description = "Positive test case with correct input value")
    public void testPlayerCreation(){
        Player player = new Player("Test");
        Assert.assertEquals(player.toString(), "Test");
    }

    @Test(description = "Negative test: name = null",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "name: null")
    public void testPlayerCreationNameIsNull(){
        new Player(null);
    }

    @Test(description = "Negative test: name is empty",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "name: ")
    public void testPlayerCreationNameIsEmpty(){
        new Player("");
    }

    @Test(description = "Negative test: name is blank",
            expectedExceptions = InvalidInputArgumentException.class,
            expectedExceptionsMessageRegExp = "name: " + "\\s{2}")
    public void testPlayerCreationNameIsBlank(){
        new Player("  ");
    }
}
