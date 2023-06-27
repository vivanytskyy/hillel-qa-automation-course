package com.gmail.ivanytskyy.vitaliy.pages.homework16;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 26/06/2023
 */
public class FirstExamplePage {
    private final SelenideElement startButton = $x("//div[@id='start']/button");
    private final SelenideElement successHeading = $("#finish h4");
    private final SelenideElement loader = $("div#loading");

    public FirstExamplePage startLoading(){
        startButton.click();
        loader.should(Condition.exist)
                .shouldBe(Condition.visible)
                .shouldNotBe(Condition.visible, Duration.ofSeconds(6));
        return this;
    }
    public String getSuccessMessage(){
        return successHeading
                .should(Condition.exist)
                .shouldBe(Condition.visible)
                .getText();
    }
}