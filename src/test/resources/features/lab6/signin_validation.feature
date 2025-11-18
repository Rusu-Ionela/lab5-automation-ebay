Feature: Sign In negative
  Pagina de Sign In nu este implementata si afiseaza pagina de eroare.

  Scenario: Autentificare cu date invalide afiseaza pagina de eroare
    Given I am on the "Sign In" page
    When I try to sign in with invalid credentials
    Then I should see error page "Page not found"
