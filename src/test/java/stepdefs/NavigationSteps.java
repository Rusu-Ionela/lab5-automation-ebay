package stepdefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.MensWearPage;
import pages.SignInPage;
import pages.SignUpPage;

public class NavigationSteps {

    private final MensWearPage mensWearPage;
    private final SignInPage signInPage;
    private final SignUpPage signUpPage;

    public NavigationSteps() {
        WebDriver driver = Hooks1.driver;
        this.mensWearPage = new MensWearPage(driver);
        this.signInPage   = new SignInPage(driver);
        this.signUpPage   = new SignUpPage(driver);
    }

    @Given("I am on the \"Men's Wear\" page")
    public void i_am_on_the_mens_wear_page() {
        mensWearPage.open();
    }

    @Given("I am on the \"Sign In\" page")
    public void i_am_on_the_sign_in_page() {
        signInPage.open();
    }

    @Given("I am on the \"Sign Up\" page")
    public void i_am_on_the_sign_up_page() {
        signUpPage.open();
    }
}
