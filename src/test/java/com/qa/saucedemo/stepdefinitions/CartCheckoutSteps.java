package com.qa.saucedemo.stepdefinitions;

import com.qa.saucedemo.pages.*;
import com.qa.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartCheckoutSteps {
    WebDriver driver = DriverFactory.getDriver();
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
    CheckoutCompletePage completePage = new CheckoutCompletePage(driver);

    @And("user adds {string} to the cart")
    public void user_adds_product_to_cart(String productName) {
        inventoryPage.waitForInventoryPage();
        inventoryPage.addProductToCart(productName);
    }

    @And("user navigates to cart page")
    public void user_navigates_to_cart_page() {
        System.out.println("Navigating to cart page...");
        inventoryPage.goToCart();
        System.out.println("Done navigating to cart page");
    }

    @And("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.clickCheckout();
    }

    @And("user fills in checkout info with {string}, {string}, {string}")
    public void user_fills_in_checkout_info(String firstName, String lastName, String zip) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, zip);
    }

    @Then("user should see the {string} message")
    public void user_should_see_thank_you_message(String expectedMessage) {
        overviewPage.finishCheckout();
        String actualMessage = completePage.getThankYouMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}