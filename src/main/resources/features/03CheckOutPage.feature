Feature: CheckOutPage

  Scenario: Succesful checkout process
    Given The user is on the checkout page
    And The user enters their first name
    And The user enters their last name
    And The user enters their zip code
    And The user clicks the continue button
    Then The user should see valid information displayed
    When The user clicks the finish button
    Then The user should be redirected to the homepage

    Scenario: Unsuccesful checkout process
      Given The user is on the home page
      And The user click the add to cart button for backpacks
      And The user click cart confirmation buttons
      And The user click the checkout buttons
      And The user click the continue buttons
      Then The user will get warning