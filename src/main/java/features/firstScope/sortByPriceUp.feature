Feature: You can sort goods by price up

  Scenario: Check sort by price up
    Given Catalog new arrivals is open
    And Sorted by price up selected
    Then Displayed products of the selected price up