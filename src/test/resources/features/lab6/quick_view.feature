Feature: Quick View behaviour
  Quick View deschide mereu Big Wing Sneakers (Navy) – bug cunoscut.

  Scenario: Quick View deschide mereu Big Wing Sneakers (Navy) - bug
    Given I am on the "Men's Wear" page
    When I click Quick View on the first product in list
    Then I should see product page with title "Big Wing Sneakers (Navy)"
