Feature: Add product to cart and complete checkout

  Background:
    Given user is logged in

  Scenario: Add Backpack to cart and complete checkout
    And user adds "Sauce Labs Backpack" to the cart
    And user navigates to cart page
    And user proceeds to checkout
    And user fills in checkout info with "Taufik", "QA", "12345"
    Then user should see the "Thank you for your order!" message
