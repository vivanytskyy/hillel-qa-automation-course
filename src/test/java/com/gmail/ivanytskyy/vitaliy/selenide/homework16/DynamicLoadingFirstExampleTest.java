package com.gmail.ivanytskyy.vitaliy.selenide.homework16;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 26/06/2023
 */
public class DynamicLoadingFirstExampleTest extends BaseTest{
    private static final String SUCCESS_MESSAGE = "Hello World!";

    @Test(description = "Example 1. Element on page that is hidden.", priority = 10)
    public void dynamicLoadingFirstExampleTest(){
        String resultMessage = openApp()
                .openDynamicLoadingPage()
                .openFirstExamplePage()
                .startLoading()
                .getSuccessMessage();
        Assert.assertEquals(resultMessage, SUCCESS_MESSAGE);
    }
}