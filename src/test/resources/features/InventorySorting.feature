Feature: Product Sorting on Inventory Page

  Background:
    Given user is logged in

  Scenario: Sort products by price low to high
    When user sorts products by "Price (low to high)"
    Then products should be sorted in ascending order

  Scenario: Sort products by price high to low
    When user sorts products by "Price (high to low)"
    Then products should be sorted in descending order
