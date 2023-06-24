package com.gmail.ivanytskyy.vitaliy.pages.homework15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public class MainPage extends BasePage{
    @FindBy(linkText = "File Download")
    private WebElement fileDownloadPage;
    @FindBy(linkText = "File Upload")
    private WebElement fileUploadPage;

    public MainPage() {
        PageFactory.initElements(webDriver, this);
    }
    public FileDownloadPage openFileDownloadPage(){
        fileDownloadPage.click();
        return new FileDownloadPage();
    }
    public FileUploadPage openFileUploadPage(){
        fileUploadPage.click();
        return new FileUploadPage();
    }
}