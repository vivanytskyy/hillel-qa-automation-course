package com.gmail.ivanytskyy.vitaliy.pages.homework14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class ChallengingDomPage extends BasePage{
    @FindBy(className = "button")
    private WebElement button1;
    @FindBy(className = "alert")
    private WebElement button2;
    @FindBy(className = "success")
    private WebElement button3;
    @FindBy(xpath = "//table/tbody/tr/td[4]")
    private List<WebElement> fourthColumOfTable;

    public ChallengingDomPage() {
        PageFactory.initElements(webDriver, this);
    }
    public ChallengingDomPage clickButton1(){
        clickButton(button1);
        return this;
    }
    public ChallengingDomPage clickButton2(){
        clickButton(button2);
        return this;
    }
    public ChallengingDomPage clickButton3(){
        clickButton(button3);
        return this;
    }
    public List<String> getTextOfFourthColumn(){
        return fourthColumOfTable
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}