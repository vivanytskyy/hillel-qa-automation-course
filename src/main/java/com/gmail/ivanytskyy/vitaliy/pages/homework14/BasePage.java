package com.gmail.ivanytskyy.vitaliy.pages.homework14;

import com.gmail.ivanytskyy.vitaliy.utils.DriverHolder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    protected JavascriptExecutor javascriptExecutor;
    public BasePage() {
        this.webDriver = DriverHolder.getInstance().getWebDriver();
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        this.actions = new Actions(webDriver);
        this.javascriptExecutor = (JavascriptExecutor) webDriver;
    }
    protected void setTextFieldValue(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    protected void clickButton(WebElement button){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
    protected void selectCheckbox(WebElement checkbox){
        if(!checkbox.isSelected()){
            checkbox.click();
        }
    }
    protected void moveToElement(WebElement targetElement){
        actions.moveToElement(targetElement).perform();
    }
}