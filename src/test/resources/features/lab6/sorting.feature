Feature: Sort By dropdown
  Verific faptul ca Sort By NU schimba ordinea produselor (bug cunoscut).

  Scenario: Sortare dupa nume A-Z nu functioneaza
    Given I am on the "Men's Wear" page
    When I select sort option "Name (A - Z)"
    Then product names should remain in the same order

  Scenario: Sortare dupa pret crescator nu functioneaza
    Given I am on the "Men's Wear" page
    When I select sort option "Price: Low to High"
    Then product prices should remain in the same order
