Feature: The user attempts to withdraw money from the current account

  Background:
    Given James has an account with "200" PLN

  Scenario: James attempts to withdraw more money than he has on the account and receives an error
    Given James successfully logs into his account
    When he attempts to withdraw "500" PLN
    Then he receives an error message

  Scenario: James attempts to withdraw 0 amount of money from the account and receives an error
    Given James successfully logs into his account
    When he attempts to withdraw "0" PLN
    Then he receives an error message that the amount cannot be 0

  Scenario: James attempts to withdraw more money than he has on the account, receives an error and corrects the amount
    Given James successfully logs into his account
    When he attempts to withdraw "500" PLN
    Then he receives an error message
    Given he corrects the amount to be withdrawn
    When he attempts to withdraw "200" PLN
    Then he should have "0" PLN left on the account

  Scenario: James attempts to withdraw more money than he has on the account and goes into debit
    Given James successfully logs into his account
    When he attempts to withdraw "500" PLN
    Then he receives an error message
    Given he accepts going into debit on his account
    When he attempts to withdraw "500" PLN
    Then he has a debit of 300 PLN on his account

  Scenario Outline: James attempts to withdraw <amount> PLN of money from his account
    Given James successfully logs into his account
    When he attempts to withdraw <amount> PLN
    Then he should have <amountLeft> PLN left on the account

    Examples:
      | amount | amountLeft |
      | 50     | 150        |
      | 100    | 100        |
      | 150    | 50         |
      | 200    | 0          |