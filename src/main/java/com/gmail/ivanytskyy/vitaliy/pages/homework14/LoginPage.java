package com.gmail.ivanytskyy.vitaliy.pages.homework14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class LoginPage extends BasePage{
    @FindBy(xpath = "//label[text()='Username']/../input")
    private WebElement usernameInput;
    @FindBy(xpath = "//label[text()='Password']/../input")
    private WebElement passwordInput;
    @FindBy(tagName = "button")
    private WebElement loginButton;
    @FindBy(css = ".flash.error")
    private WebElement errorPopup;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public LoginPage setUsername(String username){
        setTextFieldValue(usernameInput, username);
        return this;
    }
    public LoginPage setPassword(String password){
        setTextFieldValue(passwordInput, password);
        return this;
    }
    public SecureAreaPage clickLoginButtonPositiveCase(){
        clickButton(loginButton);
        return new SecureAreaPage(webDriver);
    }
    public LoginPage clickLoginButtonNegativeCase(){
        clickButton(loginButton);
        return this;
    }
    public SecureAreaPage loginPositiveCase(String username, String password){
        return setUsername(username).setPassword(password).clickLoginButtonPositiveCase();
    }
    public LoginPage loginNegativeCase(String username, String password){
        return setUsername(username).setPassword(password).clickLoginButtonNegativeCase();
    }
    public String getErrorLoginMessage(){
        return errorPopup.getText();
    }
}