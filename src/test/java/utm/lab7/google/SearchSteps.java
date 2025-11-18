package utm.lab7.google;

import io.cucumber.java.en.When;

public class SearchSteps {

    private final GoogleHomePage homePage = new GoogleHomePage();

    @When("I search for {string}")
    public void i_search_for(String query) {
        homePage.typeQuery(query);
        homePage.submitSearch();
    }

    @When("I click the search button without entering text")
    public void i_click_the_search_button_without_entering_text() {
        homePage.clickSearchButtonWithoutText();
    }
}
