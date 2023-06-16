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
public class HoversPage extends BasePage{
    @FindBy(xpath = "//div[@class='figure'][1]/img")
    private WebElement user1Img;
    @FindBy(xpath = "//div[@class='figure'][2]/img")
    private WebElement user2Img;
    @FindBy(xpath = "//div[@class='figure'][3]/img")
    private WebElement user3Img;
    @FindBy(xpath = "//div[@class='figure'][1]/div[@class='figcaption']/h5")
    private WebElement user1Heading;
    @FindBy(xpath = "//div[@class='figure'][2]/div[@class='figcaption']/h5")
    private WebElement user2Heading;
    @FindBy(xpath = "//div[@class='figure'][3]/div[@class='figcaption']/h5")
    private WebElement user3Heading;

    public HoversPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public String getNameUser1(){
        return getUserName(user1Img, user1Heading);
    }
    public String getNameUser2(){
        return getUserName(user2Img, user2Heading);
    }
    public String getNameUser3(){
        return getUserName(user3Img, user3Heading);
    }
    private String getUserName(WebElement target, WebElement nameSource){
        moveToElement(target);
        return nameSource.getText().substring(6);
    }
}