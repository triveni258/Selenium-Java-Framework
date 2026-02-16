@tag
  Feature: Purchase the order of Ecommerce Website
    I want to use this template for my feature file

    Background:
      Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When Add the product <productName> to the cart
    And Checkout <productName> and submit the order
    Then "THANKyOU FOR THE ORDER." message is displayed on the confirmation page


    Examples:
      | name                         | password    | productName     |
      | triveni.bhaskar999@gmail.com | Kitaboo@123 | ADIDAS ORIGINAL |