package com.gmail.ivanytskyy.vitaliy.utils;

import org.openqa.selenium.WebDriver;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 21/06/2023
 */
public final class DriverHolderMultithreading {
    private static final ThreadLocal<WebDriver> DRIVER_HOLDER = new ThreadLocal<>();
    private DriverHolderMultithreading(){}
    public static WebDriver getWebDriver(){
        return DRIVER_HOLDER.get();
    }
    public static void setWebDriver(WebDriver webDriver){
        DRIVER_HOLDER.set(webDriver);
    }
}