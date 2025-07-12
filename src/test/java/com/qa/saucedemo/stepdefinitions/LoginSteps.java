package com.qa.saucedemo.stepdefinitions;

import com.qa.saucedemo.pages.LoginPage;
import com.qa.saucedemo.hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = Hooks.getDriver();  // ✅ Dapatkan driver dari Hooks
        this.loginPage = new LoginPage(driver);
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should land on inventory page")
    public void user_should_land_on_inventory_page() {
        // Buat metode ini di LoginPage
        loginPage.verifyUserOnInventoryPage();
    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage(); // Panggil dari PageObject
        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
    }



}
