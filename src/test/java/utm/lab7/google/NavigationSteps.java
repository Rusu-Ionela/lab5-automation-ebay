package utm.lab7.google;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class NavigationSteps {

    private final GoogleHomePage homePage = new GoogleHomePage();

    @Given("I open the Google home page")
    public void i_open_the_google_home_page() {
        homePage.open();
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expected) {
        Assert.assertTrue(
                "Page title does not contain expected text",
                homePage.getTitle().contains(expected)
        );
    }

    @Then("I should still be on the Google home page")
    public void i_should_still_be_on_the_google_home_page() {
        Assert.assertTrue("Not on Google home page", homePage.isAtHomePage());
    }
}
