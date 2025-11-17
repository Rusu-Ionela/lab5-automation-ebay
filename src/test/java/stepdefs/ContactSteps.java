package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MensWearPage;

public class ContactSteps {

    private final MensWearPage mensWearPage;

    public ContactSteps() {
        WebDriver driver = Hooks.driver;
        this.mensWearPage = new MensWearPage(driver);
    }

    @When("I click on Contact link from navbar")
    public void i_click_on_contact_link_from_navbar() {
        mensWearPage.clickNavContact();
    }

    @When("I click on Contact link from footer")
    public void i_click_on_contact_link_from_footer() {
        mensWearPage.clickFooterContact();
    }

    @Then("the URL should contain {string}")
    public void the_url_should_contain(String fragment) {
        String url = Hooks.driver.getCurrentUrl();
        Assert.assertTrue("URL does not contain expected fragment: " + fragment,
                url.contains(fragment));
    }
}
