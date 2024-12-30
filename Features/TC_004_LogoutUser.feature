Feature: Logout User

  @sanity @regression
  Scenario: Logout User
    Given the user navigates to login page
    When the user enters email as "karthickslearnings@gmail.com" and password as "karthickslearnings"
    And the user clicks on the login button
    Then the user should be redirected to the MyAccount Page
    And the user clicks the logout button and login page is visible