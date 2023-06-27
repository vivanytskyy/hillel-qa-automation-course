package com.gmail.ivanytskyy.vitaliy.selenide.homework16;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 27/06/2023
 */
public class DynamicLoadingSecondExampleTest extends BaseTest{
    private static final String SUCCESS_MESSAGE = "Hello World!";

    @Test(description = "Example 2. Element rendered after the fact.", priority = 10)
    public void dynamicLoadingSecondExampleTest(){
        String resultMessage = openApp()
                .openDynamicLoadingPage()
                .openSecondExamplePage()
                .startLoading()
                .getSuccessMessage();
        Assert.assertEquals(resultMessage, SUCCESS_MESSAGE);
    }
}