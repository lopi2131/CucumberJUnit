Feature: You cannot register  with wrong Email

  Scenario: Check registration verification
    Given Wrong email has introduced
    And Password has introduced
    Then Registration forbidden