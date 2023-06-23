package com.gmail.ivanytskyy.vitaliy.pages.homework15;

import com.gmail.ivanytskyy.vitaliy.utils.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage() {
        this.webDriver = DriverHolder.getInstance().getWebDriver();
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }
    protected void clickButton(WebElement button){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}