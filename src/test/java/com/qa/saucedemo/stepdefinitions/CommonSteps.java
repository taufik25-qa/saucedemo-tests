package com.qa.saucedemo.stepdefinitions;

import com.qa.saucedemo.pages.LoginPage;
import com.qa.utils.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    WebDriver driver;

    @Given("user is logged in")
    public void user_is_logged_in() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }
}
