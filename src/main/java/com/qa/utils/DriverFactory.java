package com.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // ✅ Jalankan dalam mode incognito
            options.addArguments("--incognito");

            // ✅ Hindari error 'Runtime.evaluate'
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");  // opsional, agar popup tidak mengganggu

            driver = new ChromeDriver(options);

            // ✅ Hindari .maximize() yang error, set ukuran manual
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
