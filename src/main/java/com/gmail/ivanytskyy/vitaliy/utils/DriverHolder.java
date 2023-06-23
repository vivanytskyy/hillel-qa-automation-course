package com.gmail.ivanytskyy.vitaliy.utils;

import org.openqa.selenium.WebDriver;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public final class DriverHolder {
    private static DriverHolder instance = null;
    private WebDriver webDriver;
    private DriverHolder() {}
    public static DriverHolder getInstance(){
        if(instance == null){
            instance = new DriverHolder();
        }
        return instance;
    }
    public WebDriver getWebDriver(){
        return getInstance().webDriver;
    }
    public void setWebDriver(WebDriver webDriver){
        getInstance().webDriver = webDriver;
    }
}
