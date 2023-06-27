package com.gmail.ivanytskyy.vitaliy.pages.homework16;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 25/06/2023
 */
public class MainPage {
    private final SelenideElement fileDownloadPage = $(By.linkText("File Download"));
    private final SelenideElement fileUploadPage = $(By.linkText("File Upload"));
    private final SelenideElement dynamicLoadingPage = $(By.linkText("Dynamic Loading"));
    public FileDownloadPage openFileDownloadPage(){
        fileDownloadPage.click();
        return new FileDownloadPage();
    }
    public FileUploadPage openFileUploadPage(){
        fileUploadPage.click();
        return new FileUploadPage();
    }
    public DynamicLoadingPage openDynamicLoadingPage(){
        dynamicLoadingPage.click();
        return new DynamicLoadingPage();
    }
}