Feature: Add Products in Cart
  Scenario: Add Product in Cart
    Given the user navigates to base page
    And the user clicks on products
    When the user adds products to cart
    And the user clicks on view cart
    Then verify the products are added verify the infos