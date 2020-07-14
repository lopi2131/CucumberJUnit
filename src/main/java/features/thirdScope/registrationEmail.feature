Feature: You cannot register  without password

  Scenario: Check registration verification
    Given Registration page is open
    And Email have introduced
    Then Register button is not enabled