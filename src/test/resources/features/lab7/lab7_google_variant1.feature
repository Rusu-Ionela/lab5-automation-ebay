Feature: Google search basic tests

  Scenario: Pagina Google se deschide corect
    Given I open the Google home page
    Then the page title should contain "Google"

  Scenario: Verific numărul de rezultate afișate pe prima pagină
    Given I open the Google home page
    When I search for "selenium webdriver"
    Then I should see at least 1 search result on the page

  Scenario: Căutare fără text - nu se întâmplă nimic
    Given I open the Google home page
    When I click the search button without entering text
    Then I should still be on the Google home page
    And no search results should be displayed

  Scenario: Căutare irelevantă - apare "Did you mean"
    Given I open the Google home page
    When I search for "gogle"
    Then I should see a "Did you mean" suggestion
