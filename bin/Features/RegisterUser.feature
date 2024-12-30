Feature: Creating a New User Registration

  @sanity @regression
  Scenario: Successful User Registration
    Given the user navigates to login page and new user sign up message is displayed
    When the user enters the login details "user name" and "email" and clicks signup
    And the user enters the details into below fields and click on Create Account button
      | title        | MR           |
      | password     | testpassword |
      | newsletter   | true         |
      | offers       | true         |
      | firstName    | John         |
      | lastName     | Kenedy       |
      | company      | testcompany  |
      | address1     | testaddress1 |
      | address2     | testaddress2 |
      | state        | teststate    |
      | city         | testcity     |
      | zipcode      | 000000       |
      | mobilenumber | 1234567890   |

    Then the account created message is displayed
    And the user clicks continue and verify logged in msg
    And the user clicks delete account and deleted msg is visible.