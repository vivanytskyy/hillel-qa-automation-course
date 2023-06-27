package com.gmail.ivanytskyy.vitaliy.pages.homework16;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 25/06/2023
 */
public class FileUploadPage {
    private final SelenideElement fileSelectInput = $("#file-upload");
    private final SelenideElement fileUploadButton = $("#file-submit");
    private final SelenideElement successHeading = $("div.example h3");

    public FileUploadPage selectFile(String path, String fileName){
        fileSelectInput.sendKeys(path);
        fileSelectInput.shouldHave(Condition.attributeMatching("value", String.format(".*%s.*", fileName)));
        return this;
    }
    public FileUploadPage uploadFile(){
        fileUploadButton.should(Condition.exist).shouldBe(Condition.visible).click();
        return new FileUploadPage();
    }
    public String getSuccessUploadMessage(){
        return successHeading.getText();
    }
}