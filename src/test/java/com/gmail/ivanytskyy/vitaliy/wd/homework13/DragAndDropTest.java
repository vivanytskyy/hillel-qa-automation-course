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
 * Task 1
 * Написати тест до сторінки:
 * https://crossbrowsertesting.github.io/drag-and-drop.html - написати тест,
 * який буде перетаскувати елементи і перевіряти результат (що текст "Dropped!" відображається)
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/06/2023
 */
public class DragAndDropTest {
    private WebDriver webDriver;
    private static final String BASE_URL = "https://crossbrowsertesting.github.io/drag-and-drop.html";
    private static final String SUCCESS_TEXT = "Dropped!";
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
    @Test(description = "Drag and drop the element")
    public void dragAndDropTest(){
        webDriver.get(BASE_URL);
        WebElement source = webDriver.findElement(By.id("draggable"));
        WebElement target = webDriver.findElement(By.id("droppable"));
        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(source, target).perform();
        String resultText = webDriver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        Assert.assertEquals(resultText, SUCCESS_TEXT);
    }
    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}
