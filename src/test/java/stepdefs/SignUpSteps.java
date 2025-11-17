package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import pages.SignUpPage;

import java.util.List;
import java.util.Map;

public class SignUpSteps {

    private final SignUpPage signUpPage;

    public SignUpSteps() {
        this.signUpPage = new SignUpPage(stepdefs.Hooks.driver);
    }

    @When("I submit the sign up form with empty fields")
    public void i_submit_the_sign_up_form_with_empty_fields() {
        signUpPage.open();
        signUpPage.submitEmptyForm();
    }

    @Then("I should see required field validation messages")
    public void i_should_see_required_field_validation_messages() {
        // aici poți adăuga un assert mai concret,
        // de exemplu să verifici dacă apare un text de eroare
        // Assert.assertTrue(Hooks.driver.getPageSource().contains("required"));
    }

    @When("I submit the sign up form with invalid data:")
    public void i_submit_the_sign_up_form_with_invalid_data(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            signUpPage.open();
            signUpPage.submitForm(
                    row.get("name"),
                    row.get("email"),
                    row.get("password"),
                    row.get("confirmPassword")
            );
        }
    }
}
