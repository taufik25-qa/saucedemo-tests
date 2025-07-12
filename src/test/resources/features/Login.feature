Feature: Login

Scenario: Valid login
  Given user is on login page
  When user enters username "standard_user" and password "secret_sauce"
  Then user should land on inventory page