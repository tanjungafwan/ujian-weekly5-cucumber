Feature: Add Products

  Scenario: Adding products to cart
    Given User logged in
    When I click the add to cart button for backpack
    And I click the add to cart button for bike light
    Then I click cart confirmation button




