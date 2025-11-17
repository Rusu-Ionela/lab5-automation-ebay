package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import pages.SignUpPage;

import java.util.List;
import java.util.Map;

public class AuthSteps {

    private final SignInPage signInPage;
    private final SignUpPage signUpPage;

    public AuthSteps() {
        WebDriver driver = Hooks.driver;
        this.signInPage = new SignInPage(driver);
        this.signUpPage = new SignUpPage(driver);
    }

    @When("I try to login with invalid credentials:")
    public void i_try_to_login_with_invalid_credentials(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            signInPage.open();
            signInPage.login(row.get("email"), row.get("password"));
        }
    }

    // aici vei adăuga și pașii pentru Sign Up (empty form, invalid data etc.)
}
