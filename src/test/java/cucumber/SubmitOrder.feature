@Regression
Feature: Purchase the order from Ecomm Website
  I want to use this template for my feature file

Background:
Given I landed on Ecomm Page

  Scenario: Positive test of Submiting the order
  
    Given Logged in with username "<name>" and password "<password>"
    When I add the product "<productname>" to Cart
    And Checkout "<productname>" and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | name  									|	password 	| productName  	|
      | suhanee@khanderkar.com 	| Password1 | IPHONE 13 PRO |
