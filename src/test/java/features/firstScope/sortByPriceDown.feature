Feature: You can sort goods by price down

  Scenario: Check sort by price down
    Given Catalog new arrivals is open
    And Sorted by price down selected
    Then Displayed products of the selected price down