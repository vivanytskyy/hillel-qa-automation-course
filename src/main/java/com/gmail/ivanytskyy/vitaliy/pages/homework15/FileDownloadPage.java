package com.gmail.ivanytskyy.vitaliy.pages.homework15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public class FileDownloadPage extends BasePage{
    @FindBy(linkText = "some-file.txt")
    private WebElement fileLink;

    public FileDownloadPage() {
        PageFactory.initElements(webDriver, this);
    }
    public FileDownloadPage downloadFile(){
        fileLink.click();
        return this;
    }
}