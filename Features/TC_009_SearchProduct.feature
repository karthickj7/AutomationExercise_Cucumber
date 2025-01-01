Feature: Search Product
  Scenario: verify search product feature
    Given the user navigates to base page
    When the user clicks on products
    And the user navigates to all products and products list is visible
    Then the user enters product name in search box and clicks search
    And the searched products msg is displayed
    And verify all the products related to search are visible