package stepdefs;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CommonValidationSteps {

    private final WebDriver driver;

    public CommonValidationSteps() {
        this.driver = stepdefs.Hooks.driver;
    }

    @Then("I should see error page {string}")
    public void i_should_see_error_page(String expected) {
        String html = driver.getPageSource();
        Assert.assertTrue(
                "Page does not contain expected text: " + expected,
                html != null && html.toLowerCase().contains(expected.toLowerCase())
        );
    }
}
