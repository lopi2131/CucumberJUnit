Feature: You cannot login without password

  Scenario: Check login verification
    Given Login page open
    And Only email has introduced
    Then Login button is not enabled