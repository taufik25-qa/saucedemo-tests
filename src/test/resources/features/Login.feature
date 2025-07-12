Feature: Login

Scenario: Valid login
  Given user is on login page
  When user enters username "standard_user" and password "secret_sauce"
  Then user should land on inventory page

Scenario: Login with invalid credentials
    Given user is on login page
    When user enters username "wrong_user11" and password "secret_sauce"
    Then user should see an error message "Epic sadface: Username and password do not match any user in this service"

