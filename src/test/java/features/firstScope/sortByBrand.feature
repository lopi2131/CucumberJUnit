Feature: You can sort goods by brand

  Scenario: Check sort by Gucci
    Given Catalog new arrivals is open
    And Sorted by brand selected
    Then Displayed products of the selected brand