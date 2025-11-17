Feature: Contact links
  Verific linkul Contact din navbar si din footer.

  Scenario: Link Contact din navbar functioneaza
    Given I am on the "Men's Wear" page
    When I click on Contact link from navbar
    Then the URL should contain "contact"

  Scenario: Link Contact din footer duce la YouTube (bug)
    Given I am on the "Men's Wear" page
    When I click on Contact link from footer
    Then the URL should contain "youtube.com"
