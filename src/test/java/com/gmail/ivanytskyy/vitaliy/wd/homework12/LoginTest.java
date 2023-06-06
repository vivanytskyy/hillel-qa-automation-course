package com.gmail.ivanytskyy.vitaliy.wd.homework12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
 * @date 02/06/2023
 */
public class LoginTest {
    private static final String BASE_URL = "https://the-internet.herokuapp.com/login";
    private static final String VALID_USERNAME = "tomsmith";
    private static final String VALID_PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESS_MESSAGE = "You logged into a secure area!";
    private static final String INVALID_USERNAME_MESSAGE = "Your username is invalid!";
    private static final String INVALID_PASSWORD_MESSAGE = "Your password is invalid!";
    private WebDriver webDriver;
    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser){
        if(browser.equals("chrome")) WebDriverManager.chromedriver().setup();
        else if(browser.equals("firefox")) WebDriverManager.firefoxdriver().setup();
        else throw new IllegalArgumentException("Incorrect browser name");
    }
    @BeforeMethod
    @Parameters({"browser"})
    public void preCondition(String browser){
        if(browser.equals("chrome")) webDriver = new ChromeDriver();
        else if(browser.equals("firefox")) webDriver = new FirefoxDriver();
        else throw new IllegalArgumentException("Incorrect browser name");
        webDriver.manage().window().maximize();
    }
    @AfterMethod
    public void postCondition(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
    @Test(description = "Task 2: registration is successful", priority = 10)
    public void loginIsCorrectTest(){
        webDriver.get(BASE_URL);
        final String loginXPathLocator = String.format("//label[text()='%s']/../input", "Username");
        final String passwordXPathLocator = String.format("//label[text()='%s']/../input", "Password");
        WebElement login = webDriver.findElement(By.xpath(loginXPathLocator));
        login.clear();
        login.sendKeys(VALID_USERNAME);
        WebElement password = webDriver.findElement(By.xpath(passwordXPathLocator));
        password.clear();
        password.sendKeys(VALID_PASSWORD);
        webDriver.findElement(By.tagName("button")).click();
        WebElement messageElement = webDriver.findElement(By.id("flash"));
        Assert.assertTrue(messageElement.getText().contains(SUCCESS_MESSAGE));
    }
    @Test(description = "Task 2: registration is unsuccessful (invalid user name)", priority = 20)
    public void invalidUsernameTest(){
        webDriver.get(BASE_URL);
        final String loginXPathLocator = String.format("//label[text()='%s']/../input", "Username");
        final String passwordXPathLocator = String.format("//label[text()='%s']/../input", "Password");
        WebElement login = webDriver.findElement(By.xpath(loginXPathLocator));
        login.clear();
        login.sendKeys("invalid_username");
        WebElement password = webDriver.findElement(By.xpath(passwordXPathLocator));
        password.clear();
        password.sendKeys(VALID_PASSWORD);
        webDriver.findElement(By.tagName("button")).click();
        WebElement messageElement = webDriver.findElement(By.id("flash"));
        System.out.println(messageElement.getText());
        Assert.assertTrue(messageElement.getText().contains(INVALID_USERNAME_MESSAGE));
    }
    @Test(description = "Task 2: registration is unsuccessful (invalid password)", priority = 30)
    public void invalidPasswordTest(){
        webDriver.get(BASE_URL);
        final String loginXPathLocator = String.format("//label[text()='%s']/../input", "Username");
        final String passwordXPathLocator = String.format("//label[text()='%s']/../input", "Password");
        WebElement login = webDriver.findElement(By.xpath(loginXPathLocator));
        login.clear();
        login.sendKeys(VALID_USERNAME);
        WebElement password = webDriver.findElement(By.xpath(passwordXPathLocator));
        password.clear();
        password.sendKeys("invalid_password");
        webDriver.findElement(By.tagName("button")).click();
        WebElement messageElement = webDriver.findElement(By.id("flash"));
        System.out.println(messageElement.getText());
        Assert.assertTrue(messageElement.getText().contains(INVALID_PASSWORD_MESSAGE));
    }
}