Feature: Place Order and Register while Checkout
  Scenario: Place Order and Register while Checkout
    Given the user navigates to base page
    And the user clicks on products
    And the user adds a product to cart
    When the user clicks on cart page and the page is displayed
    And the user clicks on proceed to checkout
    And the user clicks on register or login button
    Then the user navigates to login page and new user sign up message is displayed
    And the user enters the login details "testuser" and "test@wvw22enm.com" and clicks signup
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
    And the user clicks on cart page and the page is displayed
    And the user clicks on proceed to checkout
    And verify the address and review the order
    And the user enter comments "test comment " and clicks on place order
    And the user enters the payment details
    And the user clicks pay and confirm button
    And verify the order placed msg
    And download invoice and verify it is successfully downloaded
    And the user clicks delete account and deleted msg is visible.
