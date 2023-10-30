package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    public static WebDriver driver;

    public WebDriver initialization() {
        System.setProperty("webdriver.gecko.driver", "/home/vickey.manwar/Desktop/CAWStudios/src/main/resources/driver/geckodriver");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;
    }
}
