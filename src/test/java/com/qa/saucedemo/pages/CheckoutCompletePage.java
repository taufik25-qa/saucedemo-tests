package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By thankYouMessage = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getThankYouMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage));
        return driver.findElement(thankYouMessage).getText();
    }

    public boolean isThankYouMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage));
            return driver.findElement(thankYouMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
