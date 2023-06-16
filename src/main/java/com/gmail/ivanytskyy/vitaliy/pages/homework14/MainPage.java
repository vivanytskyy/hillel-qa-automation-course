package com.gmail.ivanytskyy.vitaliy.pages.homework14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
* Task description:
* Провести рефакторинг власного коду, розділити логіку тестів і логіку роботи зі сторінками,
* винести її в класи PageObject (можна також додати використання фабрики).
* Рефакторити потрібно тільки сторінки тестового сайту https://the-internet.herokuapp.com/
*/
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class MainPage extends BasePage{
    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxesPage;
    @FindBy(linkText = "Hovers")
    private WebElement hoversPage;
    @FindBy(linkText = "Challenging DOM")
    private WebElement challengingDomPage;
    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationPage;
    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public LoginPage openFormAuthenticationPage(){
        formAuthenticationPage.click();
        return new LoginPage(webDriver);
    }
    public CheckboxesPage openCheckboxesPage(){
        checkboxesPage.click();
        return new CheckboxesPage(webDriver);
    }
    public HoversPage openHoversPage(){
        hoversPage.click();
        return new HoversPage(webDriver);
    }
    public ChallengingDomPage openChallengingDomPage(){
        challengingDomPage.click();
        return new ChallengingDomPage(webDriver);
    }
}