package com.gmail.ivanytskyy.vitaliy.pages.homework16;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 26/06/2023
 */
public class DynamicLoadingPage {
    private final SelenideElement firstExamplePage = $("[href$='/1']");
    private final SelenideElement secondExamplePage = $("[href$='/2']");
    public FirstExamplePage openFirstExamplePage(){
        firstExamplePage.click();
        return new FirstExamplePage();
    }
    public SecondExamplePage openSecondExamplePage(){
        secondExamplePage.click();
        return new SecondExamplePage();
    }
}