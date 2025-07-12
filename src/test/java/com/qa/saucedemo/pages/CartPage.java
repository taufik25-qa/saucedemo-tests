package com.qa.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Constructor untuk inject WebDriver
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Klik tombol Checkout setelah memastikan berada di halaman Cart
    public void clickCheckout() {

        wait.until(ExpectedConditions.urlContains("/cart.html"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        driver.findElement(By.id("checkout")).click();
    }

    // ❕ Optional: Tambahkan verifikasi produk di cart (pengembangan selanjutnya)
    public boolean isProductInCart(String productName) {
        try {
            return driver.findElement(By.xpath("//div[text()='" + productName + "']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
