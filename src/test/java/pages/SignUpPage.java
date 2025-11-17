package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    private static final String SIGNUP_URL =
            "https://adoring-pasteur-3ae17d.netlify.app/signup.html";

    private static final By NAME_INPUT         = By.id("name");
    private static final By EMAIL_INPUT        = By.id("email");
    private static final By PASSWORD_INPUT     = By.id("password1");
    private static final By CONFIRM_PASS_INPUT = By.id("password2");
    private static final By SUBMIT_BUTTON      = By.cssSelector("button[type='submit']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(SIGNUP_URL);
    }

    public void submitEmptyForm() {
        click(SUBMIT_BUTTON);
    }

    public void submitForm(String name, String email, String pass, String confirm) {
        type(NAME_INPUT, name);
        type(EMAIL_INPUT, email);
        type(PASSWORD_INPUT, pass);
        type(CONFIRM_PASS_INPUT, confirm);
        click(SUBMIT_BUTTON);
    }
}
