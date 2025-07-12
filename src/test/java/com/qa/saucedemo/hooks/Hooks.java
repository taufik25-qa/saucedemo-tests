package com.qa.saucedemo.hooks;

import com.qa.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver(); // ⛳ Inisialisasi WebDriver hanya lewat DriverFactory
        DriverFactory.getDriver().get("https://www.saucedemo.com/"); // buka URL awal
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(); // ⛳ Hentikan dan hapus sesi driver
    }

    // Jika diperlukan akses ke driver di tempat lain
    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
