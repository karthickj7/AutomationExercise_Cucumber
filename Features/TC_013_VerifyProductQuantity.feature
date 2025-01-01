Feature: Verify Product quantity in Cart

  Scenario: Verify Product quantity in Cart
    Given the user navigates to base page
    And the user clicks on products
    And the user clicks on view product of any product
    When the user is landed on product details page
    And the quantity is increased to "4"
    Then the user clicks add to cart and then view cart
    And verify the product quantity is "4"
