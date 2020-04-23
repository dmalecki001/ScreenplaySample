@AAA
Feature: James attempts to get values from server and post new comment

  @Smoke @Cast
  Scenario: James tries to get the userIds from get request
    Given James can call an api at its base rest service
    When he sends a get request to resource "posts/"
    Then the status code should be 200
    And he should collect the userIds

  @Smoke
  Scenario: James tries to find all users with the highest id and the highest userId
    Given James can call an api at its base rest service
    When he sends a get request to resource with data "posts?userId="
    Then the status code should be 200
    And he should collect the subIds

  @Smoke @Dismiss
  Scenario: James tries to post a new comment to the user with the highest id
    Given James can call an api at its base rest service
    When he sends a post request to resource "comments"
    Then the status code should be 201