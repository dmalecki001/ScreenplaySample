Feature: James attempts to register new account and log into it and add another address 1

  Background:
    Given Bobby can browse the web

  @Smoke @Cast @Serialize
  Scenario: James attempts to create a new account 1
    Given Bobby successfully opens the home page
    When he attempts to provide data for new account registration
    Then he should verify that the account was successfully created

  @Smoke
  Scenario: James tries to log into the previously created account 1
    Given Bobby successfully opens the home page
    When he attempts to provide login data
    Then he should successfully log into the account

  @Smoke @Dismiss
  Scenario: James tries to add new address to his account
    Given Bobby successfully opens the home page
    When he attempts to provide login data
    Then he should successfully log into the account
    Given he opens "My addresses" tab
    When he attempts to add a new address
    Then he should verify that the new address has been added