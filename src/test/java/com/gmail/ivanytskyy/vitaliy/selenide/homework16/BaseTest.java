package com.gmail.ivanytskyy.vitaliy.selenide.homework16;

import com.codeborne.selenide.Configuration;
import com.gmail.ivanytskyy.vitaliy.pages.homework16.MainPage;
import com.gmail.ivanytskyy.vitaliy.utils.TestProperties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.open;

/*
 * Task 1
 * Переписати код з минулого заняття для download/upload з використанням Selenide (можна створити новий PageObject)
 * Task 2
 * Написати PageObject і тест для https://the-internet.herokuapp.com/dynamic_loading (обидва варіанти).
 * Після кліка по кнопці дочекатися появи тексту на сторінці і перевірити його в асерті
 */

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 25/06/2023
 */
public class BaseTest {
    private static final String ABSOLUTE_PATH_TO_DOWNLOADS;
    private static final String ABSOLUTE_PATH_TO_REPORTS;
    static {
        ABSOLUTE_PATH_TO_DOWNLOADS = new File("target" + File.separator + "downloads").getAbsolutePath();
        ABSOLUTE_PATH_TO_REPORTS = new File("target" + File.separator + "reports").getAbsolutePath();
    }
    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser) throws IOException {
        Configuration.baseUrl = TestProperties.getInstance().getProperty("url_hw16");
        Configuration.browser = browser;
        Configuration.downloadsFolder = ABSOLUTE_PATH_TO_DOWNLOADS;
        Configuration.reportsFolder = ABSOLUTE_PATH_TO_REPORTS;
    }
    protected MainPage openApp(){
        open(Configuration.baseUrl);
        return new MainPage();
    }
}