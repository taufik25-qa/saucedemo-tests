# 🧪 SauceDemo QA Automation Project

Proyek ini adalah implementasi **End-to-End UI Automation Testing** untuk situs [SauceDemo](https://www.saucedemo.com/) 
menggunakan **Java + Selenium + Cucumber + TestNG**.

## 📁 Struktur Folder

src/
├── main/
│ └── java/
│ └── com.qa.saucedemo/
│ ├── pages/ # Page Object (LoginPage, InventoryPage, dsb)
│ ├── utils/ # DriverFactory (singleton WebDriver)
│ └── hooks/ # Cucumber Hooks (Before/After)
├── test/
│ └── java/
│ └── com.qa.saucedemo.stepdefinitions/ # Step Definitions
│
└── resources/
└── features/ # File .feature Gherkin (login, inventory, cart-checkout)
---------------------------------------------------------------------------------------------
## ✅ Fitur yang Di-otomasi

1. **Login**
    - Valid login ke aplikasi

2. **Inventory**
    - Sorting produk berdasarkan:
        - Name (A to Z)
        - Price (low to high)

3. **Cart & Checkout**
    - Tambah produk ke keranjang
    - Checkout hingga muncul pesan "Thank you for your order!"

## 🚀 Tools & Framework

| Tool         | Fungsi                    |
|--------------|---------------------------|
| Java         | Bahasa pemrograman utama  |
| Selenium     | Automasi browser          |
| Cucumber     | BDD testing dengan Gherkin|
| TestNG       | Test runner               |
| Maven        | Build & dependency manager|

## ▶️ Cara Menjalankan Test

1. **Clone repo**
2. Jalankan `mvn clean test` di terminal
3. Test akan:
    - Buka browser 1x
    - Jalankan semua test feature (Login, Inventory, Cart)
    - Tutup browser setelah selesai

## 🔐 Struktur Login

| Username       | Password      |
|----------------|---------------|
| standard_user  | secret_sauce  |

## 📌 Catatan Penting

- Jangan memanggil `WebDriver` langsung di Step Definition — gunakan `DriverFactory.getDriver()`.
- Jangan membuat browser lebih dari satu — semua test pakai 1 driver session.
- `Hooks` hanya buka & tutup browser 1x (Before & After).
- Feature test sudah dipisah per skenario (login, sorting, checkout).

## 🙋‍♂️ Author

- Taufikurrohman QA Engineer

