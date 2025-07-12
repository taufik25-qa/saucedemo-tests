package com.qa.saucedemo.base;

import com.qa.utils.ConfigReader;
import com.qa.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
