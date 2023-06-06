package com.gmail.ivanytskyy.vitaliy.wd.homework12;

/*
 * Task 3
 * Написати тест до сторінки:
 * https://the-internet.herokuapp.com/checkboxes - вивести на екран початковий стан чекбоксів (вибраний чи ні),
 * потім вибрати обидва.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 03/06/2023
 */
public class CheckboxesTest {
    private static final String BASE_URL = "https://the-internet.herokuapp.com/checkboxes";
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
    @Test(description = "Task 3: work with checkboxes", priority = 10)
    public void checkboxesTest(){
        webDriver.get(BASE_URL);
        final String checkbox1XPathLocator= "//form/input[1]";
        final String checkbox2XPathLocator= "//form/input[2]";
        boolean isCheckbox1Selected = webDriver.findElement(By.xpath(checkbox1XPathLocator)).isSelected();
        boolean isCheckbox2Selected = webDriver.findElement(By.xpath(checkbox2XPathLocator)).isSelected();
        System.out.println("Initial state:");
        System.out.println("Is checkbox 1 selected? " + isCheckbox1Selected);
        System.out.println("Is checkbox 2 selected? " + isCheckbox2Selected);
        if(!isCheckbox1Selected) webDriver.findElement(By.xpath(checkbox1XPathLocator)).click();
        if(!isCheckbox2Selected) webDriver.findElement(By.xpath(checkbox2XPathLocator)).click();
        Assert.assertTrue(
                webDriver.findElement(By.xpath(checkbox1XPathLocator)).isSelected(), "is checkbox1 selected?");
        Assert.assertTrue(
                webDriver.findElement(By.xpath(checkbox2XPathLocator)).isSelected(), "is checkbox2 selected?");
    }
}