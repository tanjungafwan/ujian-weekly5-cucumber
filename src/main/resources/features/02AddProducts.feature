Feature: Add Products

  Scenario: Adding products to cart
    Given User logged in
    When The user click the add to cart button for backpack
    And The user click the add to cart button for bike light
    And The user click cart confirmation button
    Then The user click the checkout button




