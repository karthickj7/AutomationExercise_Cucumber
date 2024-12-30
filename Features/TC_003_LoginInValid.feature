Feature: Login User with incorrect email and password

  @sanity @regression
  Scenario: Login User with incorrect email and password
    Given the user navigates to login page
    When the user enters incorrect email as "karthickslearnings@gmail.com" and password as "karthickslearning"
    And the user clicks on the login button
    Then the user should be presented with a error msg
