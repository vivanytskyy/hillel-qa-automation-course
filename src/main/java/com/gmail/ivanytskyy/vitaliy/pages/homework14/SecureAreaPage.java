package com.gmail.ivanytskyy.vitaliy.pages.homework14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class SecureAreaPage extends BasePage{
    @FindBy(css = ".button.secondary.radius")
    private WebElement logoutButton;
    @FindBy(id = "flash")
    private WebElement successPopup;
    public SecureAreaPage(){
        PageFactory.initElements(webDriver, this);
    }
    public LoginPage logout(){
        clickButton(logoutButton);
        return new LoginPage();
    }
    public String getSuccessLoginMessage(){
        return successPopup.getText();
    }
}