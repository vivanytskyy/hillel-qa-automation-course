package com.gmail.ivanytskyy.vitaliy.wd.homework14;

import com.gmail.ivanytskyy.vitaliy.listeners.CustomExtentReportsListener;
import com.gmail.ivanytskyy.vitaliy.pages.homework14.MainPage;
import com.gmail.ivanytskyy.vitaliy.utils.DriverHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
@Listeners({CustomExtentReportsListener.class})
public class BaseTest {
    protected WebDriver webDriver;
    private static final String MAIN_PAGE_URL = "https://the-internet.herokuapp.com";
    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }else if(browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }else{
            throw new IllegalArgumentException("Incorrect browser name");
        }
        webDriver.manage().window().maximize();
        DriverHolder.getInstance().setWebDriver(webDriver);
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
    protected MainPage openApp(){
        webDriver.get(MAIN_PAGE_URL);
        return new MainPage();
    }
}