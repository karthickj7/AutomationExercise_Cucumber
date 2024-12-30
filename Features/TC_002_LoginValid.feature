Feature: Login User with correct email and password

  @sanity @regression
  Scenario: Login User with correct email and password
    Given the user navigates to login page
    When the user enters email as "karthickslearnings@gmail.com" and password as "karthickslearnings"
    And the user clicks on the login button
    Then the user should be redirected to the MyAccount Page