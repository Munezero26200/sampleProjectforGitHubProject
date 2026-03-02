Feature: Registration functionality

  As a new customer,
  I want to register an account
  so that I can make purchase as a registered customer

  Background:
    Given customer is on the account page

  Scenario: Verify that customer registers using valid credentials
    When the customer registers with the credentials
      | username | email        | password |
      | PG1       | pG1@gmail.com | 123      |
    Then account details Page shows username "PG1"