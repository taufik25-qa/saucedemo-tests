package com.qa.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.time.Duration;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Constructor yang benar
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Tunggu sampai halaman inventori muncul
    public void waitForInventoryPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
    }

    // ✅ Sorting produk sesuai kriteria
    public void sortProductsBy(String criteria) {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(criteria);
    }

    // ✅ Tambahkan produk ke cart berdasarkan nama
    public void addProductToCart(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }

        String formattedName = productName
                .toLowerCase()
                .trim()
                .replaceAll(" ", "-")
                .replaceAll("[^a-z0-9\\-]", "");

        String id = "add-to-cart-" + formattedName;
        System.out.println("DEBUG: Menunggu ID = " + id + " clickable...");

        By locator = By.id(id);

        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
            wait.until(ExpectedConditions.visibilityOf(addToCartButton));
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartButton.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout: Tombol tidak ditemukan atau tidak clickable dalam batas waktu.");
            throw e;
        } catch (Exception e) {
            System.out.println("Gagal klik tombol dengan ID: " + id);
            e.printStackTrace();
            throw e;
        }
    }

    // ✅ Navigasi ke halaman keranjang
    public void goToCart() {
        By cartIcon = By.className("shopping_cart_link");
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
        cartButton.click();
    }

    // ✅ Verifikasi produk sudah tersorting sesuai pilihan user
    public void verifyProductSorted(String criteria) {
        if (criteria.contains("Name")) {
            List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
            List<String> actualNames = new ArrayList<>();
            for (WebElement el : productElements) {
                actualNames.add(el.getText());
            }

            List<String> expectedNames = new ArrayList<>(actualNames);
            if (criteria.contains("A to Z")) {
                Collections.sort(expectedNames);
            } else {
                Collections.sort(expectedNames, Collections.reverseOrder());
            }

            Assert.assertEquals("Produk tidak tersorting dengan benar berdasarkan nama", expectedNames, actualNames);

        } else if (criteria.contains("Price")) {
            List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
            List<Double> actualPrices = new ArrayList<>();
            for (WebElement el : priceElements) {
                actualPrices.add(Double.parseDouble(el.getText().replace("$", "")));
            }

            List<Double> expectedPrices = new ArrayList<>(actualPrices);
            if (criteria.contains("low to high")) {
                Collections.sort(expectedPrices);
            } else {
                Collections.sort(expectedPrices, Collections.reverseOrder());
            }

            Assert.assertEquals("Produk tidak tersorting dengan benar berdasarkan harga", expectedPrices, actualPrices);
        }
    }
}
