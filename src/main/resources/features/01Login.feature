Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    And I click the login button
    Then I should see the products page

  Scenario:  Invalid login with invalid credentials
    When I am logout
    And I enter invalid username and password
    And I click the login button
    Then Show message invalid credentials

  Scenario: Valid login with blank email credentials
    Given I am on the login page
    When I enter valid password and blank username
    And I click the login button
    Then I should see the message invalid credentials blank username

    Scenario: Valid login with blank password credentials
      Given I am on the login page
      When I enter valid username and blank password
      And I click the login button
      Then I should see the message invalid credentials blank password

      Scenario: Valid login with locked out user
        Given I am on the login page
        When I enter valid locked out username and valid password
        And I click the login button
        Then I should see the message invalid credentials locked out user

