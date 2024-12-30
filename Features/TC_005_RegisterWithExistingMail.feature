Feature: Register User with existing email

  @sanity @regression
  Scenario: Register User with existing email
    Given the user navigates to login page and new user sign up message is displayed
    When the user enters existing email "testuser" and "karthickslearnings@gmail.com" and clicks signup
    Then the user is presented with email already exists msg.