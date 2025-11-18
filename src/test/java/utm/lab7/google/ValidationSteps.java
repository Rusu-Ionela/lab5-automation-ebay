package utm.lab7.google;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ValidationSteps {

    private GoogleHomePage homePage = new GoogleHomePage();

    @Then("I should see at least {int} search result on the page")
    public void i_should_see_at_least_search_result_on_the_page(Integer minResults) {
        int actual = homePage.getResultsCount();
        Assert.assertTrue(
                "Expected at least " + minResults + " result(s), but found: " + actual,
                actual >= minResults
        );
    }

    @And("no search results should be displayed")
    public void no_search_results_should_be_displayed() {
        Assert.assertTrue("Some results are displayed", homePage.hasNoResults());
    }

    @Then("I should see a {string} suggestion")
    public void i_should_see_a_suggestion(String text) {
        Assert.assertTrue(
                "Did you mean suggestion not visible",
                homePage.hasDidYouMeanSuggestion()
        );
    }
}
