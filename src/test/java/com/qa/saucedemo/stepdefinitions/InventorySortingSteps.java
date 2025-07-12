package com.qa.saucedemo.stepdefinitions;

import com.qa.saucedemo.pages.InventoryPage;
import com.qa.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class InventorySortingSteps {

    WebDriver driver = DriverFactory.getDriver();
    InventoryPage inventoryPage = new InventoryPage(driver);

    @When("user sorts products by {string}")
    public void user_sorts_products_by(String sortingOption) {
        inventoryPage.sortProductsBy(sortingOption);
    }

    @Then("products should be sorted in ascending order")
    public void products_should_be_sorted_in_ascending_order() {
        inventoryPage.verifyProductSorted("Price (low to high)");
    }

    @Then("products should be sorted in descending order")
    public void products_should_be_sorted_in_descending_order() {
        inventoryPage.verifyProductSorted("Price (high to low)");
    }

    @Then("products should be sorted alphabetically A to Z")
    public void products_should_be_sorted_alphabetically_az() {
        inventoryPage.verifyProductSorted("Name (A to Z)");
    }

    @Then("products should be sorted alphabetically Z to A")
    public void products_should_be_sorted_alphabetically_za() {
        inventoryPage.verifyProductSorted("Name (Z to A)");
    }
}
