Feature: Verify Subscription in home page
  Scenario: Verify Subscription in home page
    Given the user navigates to base page
    And the user scrolls down to subscription section
    When the user enter the email "test@test"and click on arrow key
    Then the user is displayed with successfully subscribed