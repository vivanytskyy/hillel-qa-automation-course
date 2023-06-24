package com.gmail.ivanytskyy.vitaliy.wd.homework15;

import com.gmail.ivanytskyy.vitaliy.pages.homework15.MainPage;
import com.gmail.ivanytskyy.vitaliy.utils.DriverHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*
 * Написати тест, який буде завантажувати файл зі сторінки, змінювати його за завантажувати назад на сервер.
 * Для даунлоада потрібно використати сторінку https://the-internet.herokuapp.com/download
 * Обрати буть-який текстовий файл. В цей файл потрібно дописати декілька нових рядків.
 * Після цього перейти на сторінку https://the-internet.herokuapp.com/upload завантажити файл і перевірити,
 * що дія виконана успішно.
 * Логіка роботи з елементами сторінки має бути винесена у PageObject-и.
 * Логіка роботи з файлами має бути в тесті
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public class BaseTest {
    protected WebDriver webDriver;
    private static final String MAIN_PAGE_URL = "https://the-internet.herokuapp.com";
    private static final String ABSOLUTE_PATH;
    static {
        ABSOLUTE_PATH = new File("target" + File.separator + "downloads").getAbsolutePath();
    }
    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(setOptionsForChrome());
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver(setOptionsForFirefox());
        }else{
            throw new IllegalArgumentException("Incorrect browser name");
        }
        webDriver.manage().window().maximize();
        DriverHolder.getInstance().setWebDriver(webDriver);
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
    protected MainPage openApp(){
        webDriver.get(MAIN_PAGE_URL);
        return new MainPage();
    }
    private ChromeOptions setOptionsForChrome(){
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", ABSOLUTE_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        return chromeOptions;
    }
    private FirefoxOptions setOptionsForFirefox(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", ABSOLUTE_PATH);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/zip");
        return new FirefoxOptions().setProfile(profile);
    }
    public static boolean waitForFileDownloaded(String absolutePath) throws InterruptedException {
        File file = new File(absolutePath);
        do{
            Thread.sleep(3000);
        }while (!file.exists());
        return true;
    }
}