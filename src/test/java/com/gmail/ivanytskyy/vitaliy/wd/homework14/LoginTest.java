package com.gmail.ivanytskyy.vitaliy.wd.homework14;

import com.gmail.ivanytskyy.vitaliy.pages.homework14.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * Task 2
 * Написати тести до сторінки:
 * https://the-internet.herokuapp.com/login - написати 2 тести на коректний та некоректний логін.
 * В першому випадку перевірити, що відображається повідомлення "You logged into a secure area!",
 * в другому випадку - що відображається повідомлення про неправильний логін/пароль
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 16/06/2023
 */
public class LoginTest extends BaseTest{
    private static final String VALID_USERNAME = "tomsmith";
    private static final String VALID_PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESS_MESSAGE = "You logged into a secure area!";
    private static final String INVALID_USERNAME_MESSAGE = "Your username is invalid!";
    private static final String INVALID_PASSWORD_MESSAGE = "Your password is invalid!";

    @Test(description = "Task 2: registration (step by step) is successful", priority = 10)
    public void successLoginStepByStepTest(){
        SecureAreaPage secureAreaPage = openApp()
                .openFormAuthenticationPage()
                .setUsername(VALID_USERNAME)
                .setPassword(VALID_PASSWORD)
                .clickLoginButtonPositiveCase();
        Assert.assertTrue(secureAreaPage.getSuccessLoginMessage().contains(SUCCESS_MESSAGE));
        secureAreaPage.logout();
    }
    @Test(description = "Task 2: registration (flow) is successful", priority = 20)
    public void successLoginFlowTest(){
        SecureAreaPage secureAreaPage = openApp()
                .openFormAuthenticationPage()
                .loginPositiveCase(VALID_USERNAME, VALID_PASSWORD);
        Assert.assertTrue(secureAreaPage.getSuccessLoginMessage().contains(SUCCESS_MESSAGE));
        secureAreaPage.logout();
    }
    @Test(description = "Task 2: registration (step by step) is unsuccessful (invalid user name)", priority = 30)
    public void invalidUsernameStepByStepTest(){
        String resultMessage = openApp()
                .openFormAuthenticationPage()
                .setUsername("invalid username")
                .setPassword(VALID_PASSWORD)
                .clickLoginButtonNegativeCase()
                .getErrorLoginMessage();
        Assert.assertTrue(resultMessage.contains(INVALID_USERNAME_MESSAGE));
    }
    @Test(description = "Task 2: registration (flow) is unsuccessful (invalid user name)", priority = 40)
    public void invalidUsernameFlowTest(){
        String resultMessage = openApp()
                .openFormAuthenticationPage()
                .loginNegativeCase("invalid username", VALID_PASSWORD)
                .getErrorLoginMessage();
        Assert.assertTrue(resultMessage.contains(INVALID_USERNAME_MESSAGE));
    }
    @Test(description = "Task 2: registration (step by step) is unsuccessful (invalid password)", priority = 50)
    public void invalidPasswordStepByStepTest(){
        String resultMessage = openApp()
                .openFormAuthenticationPage()
                .setUsername(VALID_USERNAME)
                .setPassword("invalid password")
                .clickLoginButtonNegativeCase()
                .getErrorLoginMessage();
        Assert.assertTrue(resultMessage.contains(INVALID_PASSWORD_MESSAGE));
    }
    @Test(description = "Task 2: registration (flow) is unsuccessful (invalid password)", priority = 60)
    public void invalidPasswordFlowTest(){
        String resultMessage = openApp()
                .openFormAuthenticationPage()
                .loginNegativeCase(VALID_USERNAME, "invalid password")
                .getErrorLoginMessage();
        Assert.assertTrue(resultMessage.contains(INVALID_PASSWORD_MESSAGE));
    }
}