Feature:  Verify All Products and product detail page
  Scenario: Verify All Products and product detail page
    Given the user navigates to base page
    When the user clicks on products
    And the user navigates to all products and products list is visible
    Then the user click on view product of first product
    And the user is landed on product details page
    And the product details are visible