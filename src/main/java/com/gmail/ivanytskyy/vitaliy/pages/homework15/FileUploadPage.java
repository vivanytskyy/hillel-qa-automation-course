package com.gmail.ivanytskyy.vitaliy.pages.homework15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public class FileUploadPage extends BasePage{
    @FindBy(id = "file-upload")
    private WebElement fileSelectInput;
    @FindBy(id = "file-submit")
    private WebElement fileUploadButton;
    @FindBy(css = "div.example h3")
    private WebElement successHeading;

    public FileUploadPage() {
        PageFactory.initElements(webDriver, this);
    }
    public FileUploadPage selectFile(String path){
        fileSelectInput.sendKeys(path);
        return this;
    }
    public FileUploadPage uploadFile(String fileName){
        if(fileSelectInput.getAttribute("value").contains(fileName)){
            clickButton(fileUploadButton);
        }
        return this;
    }
    public String getSuccessUploadMessage(){
        return successHeading.getText();
    }
}