Feature: You cannot login without wrong data

  Scenario: Check login verification
    Given Email and Password have introduced
    And Login button is enabled
    Then Login forbidden