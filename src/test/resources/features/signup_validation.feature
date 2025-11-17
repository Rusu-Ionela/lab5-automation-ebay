Feature: Sign Up validation (negative scenarios)
  Pagina de Sign Up nu este implementata complet, iar utilizatorul ajunge la
  o pagina de eroare in loc de mesaj de validare frumos.

  Scenario: Email invalid si parole diferite - pagina nu este implementata
    Given I am on the "Sign Up" page
    When I fill the sign up form with invalid email and different passwords
    And I submit the sign up form
    Then I should see error page "Page not found"
