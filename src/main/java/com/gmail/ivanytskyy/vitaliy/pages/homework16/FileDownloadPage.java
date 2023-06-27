package com.gmail.ivanytskyy.vitaliy.pages.homework16;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.io.File;
import java.io.FileNotFoundException;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 25/06/2023
 */
public class FileDownloadPage {
    private final SelenideElement fileLink = $(By.linkText("some-file.txt"));
    public File downloadFile() throws FileNotFoundException {
        return fileLink.download();
    }
}