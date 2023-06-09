package com.gmail.ivanytskyy.vitaliy.wd.homework13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

/*
 * Task 3
 * Написати тест до сторінки:
 * https://the-internet.herokuapp.com/hovers - написати тест, який виводить юзернейм для кожного користувача
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/06/2023
 */
public class UserNameFinderTest {
    private WebDriver webDriver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com/hovers";
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
    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
    @Test(description = "Get user name by actions (step by step)", priority = 10)
    public void findUserNameStepByStepTest(){
        webDriver.get(BASE_URL);
        Actions actions = new Actions(webDriver);
        // User 1
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='figure'][1]/img"))).perform();
        String userName1 = webDriver.findElement(
                By.xpath("//div[@class='figure'][1]/div[@class='figcaption']/h5")).getText();
        System.out.println(userName1);
        Assert.assertEquals(userName1, "name: user1");
        // User 2
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='figure'][2]/img"))).perform();
        String userName2 = webDriver.findElement(
                By.xpath("//div[@class='figure'][2]/div[@class='figcaption']/h5")).getText();
        System.out.println(userName2);
        Assert.assertEquals(userName2, "name: user2");
        // User 3
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class='figure'][3]/img"))).perform();
        String userName3 = webDriver.findElement(
                By.xpath("//div[@class='figure'][3]/div[@class='figcaption']/h5")).getText();
        System.out.println(userName3);
        Assert.assertEquals(userName3, "name: user3");
    }
    @Test(description = "Get user names by actions (use List() and for loop)", priority = 20)
    public void findUserNameWithListAndLoopTest(){
        webDriver.get(BASE_URL);
        Actions actions = new Actions(webDriver);
        List<WebElement> elements = webDriver.findElements(By.xpath("//h5"));
        List<WebElement> images = webDriver.findElements(By.xpath("//div[@class='figure']/img"));
        for (int i = 0; i < images.size(); i++){
            actions.moveToElement(images.get(i)).perform();
            System.out.println(elements.get(i).getText());
            Assert.assertEquals(elements.get(i).getText(), "name: user" + (i + 1));
        }
    }
    @Test(description = "Print the user names with using InnerHTML as argument of getAttribute()", priority = 30)
    public void printUserNamesByInnerHTMLTest(){
        webDriver.get(BASE_URL);
        webDriver.findElements(By.xpath("//h5"))
                .stream().map(n -> n.getAttribute("innerHTML"))
                .forEach(System.out::println);
    }
}