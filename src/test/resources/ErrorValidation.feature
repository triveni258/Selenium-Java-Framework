@tag
Feature: ErrorValidation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title is your scenario outline
    Given I landed on Ecommerce Page
    Given Logged in with username <name> and password <password>
    Then  I verfied the <status> in step


    Examples:
      | name                         | password     |  |
      | triveni.bhaskar999@gmail.com | Kitaboo@1234 |  |