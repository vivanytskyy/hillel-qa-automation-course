package com.gmail.ivanytskyy.vitaliy.wd.homework12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/*
 * Task 1
 * Написати тест до сторінки:
 * https://the-internet.herokuapp.com/challenging_dom - потрібно знайти і клікнути по кожній кнопці,
 * після чого вибрати всі значення з 4го стовбця таблиці і вивести їх на екран
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 03/06/2023
 */
public class ChallengingDomTest {
    private static final String BASE_URL = "https://the-internet.herokuapp.com/challenging_dom";
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
    @Test(description = "Task 1: find the elements by class name", priority = 10)
    public void findElementsByClassNameTest(){
        webDriver.get(BASE_URL);
        WebElement button1 = webDriver.findElement(By.className("button"));
        System.out.println(button1.getText());
        button1.click();
        WebElement button2 = webDriver.findElement(By.className("alert"));
        System.out.println(button2.getText());
        button2.click();
        WebElement button3 = webDriver.findElement(By.className("success"));
        System.out.println(button3.getText());
        button3.click();
    }
    @Test(description = "Task 1: find the elements by css selector (class name as attribute of tag)", priority = 20)
    public void findElementsByCssSelectorAndAttrNameTest(){
        webDriver.get(BASE_URL);
        WebElement button1 = webDriver.findElement(By.cssSelector("a[class='button']"));
        System.out.println(button1.getText());
        button1.click();
        WebElement button2 = webDriver.findElement(By.cssSelector("a[class='button alert']"));
        System.out.println(button2.getText());
        button2.click();
        WebElement button3 = webDriver.findElement(By.cssSelector("a[class='button success']"));
        System.out.println(button3.getText());
        button3.click();
    }
    @Test(description = "Task 1: find the elements by css selector (class name + order of elements)", priority = 30)
    public void findElementsByCssSelectorAndOrderOfElementsTest(){
        webDriver.get(BASE_URL);
        WebElement button1 = webDriver.findElement(By.cssSelector(".large-2 > a:nth-of-type(1)"));
        System.out.println(button1.getText());
        button1.click();
        WebElement button2 = webDriver.findElement(By.cssSelector(".large-2 > a:nth-of-type(2)"));
        System.out.println(button2.getText());
        button2.click();
        WebElement button3 = webDriver.findElement(By.cssSelector(".large-2 > a:nth-of-type(3)"));
        System.out.println(button3.getText());
        button3.click();
    }
    @Test(description = "Task 1: find the elements by xpath (class name as attribute of tag)", priority = 40)
    public void findElementsByXpathTest(){
        webDriver.get(BASE_URL);
        WebElement button1 = webDriver.findElement(By.xpath("//a[@class='button']"));
        System.out.println(button1.getText());
        button1.click();
        WebElement button2 = webDriver.findElement(By.xpath("//a[@class='button alert']"));
        System.out.println(button2.getText());
        button2.click();
        WebElement button3 = webDriver.findElement(By.xpath("//a[@class='button success']"));
        System.out.println(button3.getText());
        button3.click();
    }
    @Test(description = "Task 1: print fourth column of the table)", priority = 50)
    public void printColumnOfTableTest(){
        webDriver.get(BASE_URL);
        WebElement headElement = webDriver.findElement(By.xpath("//table/thead/tr[1]/th[4]"));
        System.out.println(headElement.getText());
        System.out.println("-".repeat(11));
        webDriver.findElements(By.xpath("//table/tbody/tr/td[4]"))
                .stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
    }
}