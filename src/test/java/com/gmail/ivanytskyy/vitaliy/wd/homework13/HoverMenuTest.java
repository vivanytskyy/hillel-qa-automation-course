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

/*
 * Task 2
 * Написати тест до сторінки:
 * https://crossbrowsertesting.github.io/hover-menu.html - написати тест, який розкриває dropdown-меню,
 * клікає по пункту Secondary Action і перевіряє, що на сторінці показується текст "Secondary Page"
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/06/2023
 */
public class HoverMenuTest {
    private WebDriver webDriver;
    private static final String BASE_URL = "https://crossbrowsertesting.github.io/hover-menu.html";
    private static final String SUCCESS_TEXT = "Secondary Page";
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
    @Test(description = "Drop-down menu test")
    public void dropdownMenuTest(){
        webDriver.get(BASE_URL);
        WebElement link1 = webDriver.findElement(By.xpath("//a[contains(text(), 'Dropdown')]"));
        WebElement link2 = webDriver.findElement(By.xpath("//a[contains(text(), 'Secondary Menu')]"));
        WebElement link3 = webDriver.findElement(By.xpath("//a[contains(text(), 'Secondary Action')]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(link1).moveToElement(link2).moveToElement(link3).click().perform();
        String resultText = webDriver.findElement(
                By.xpath("//div[@class='jumbotron secondary-clicked']/h1")).getText();
        Assert.assertEquals(resultText, SUCCESS_TEXT);
    }
    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}