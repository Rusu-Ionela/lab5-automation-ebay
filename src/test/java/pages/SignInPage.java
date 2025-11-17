package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    private static final String SIGNIN_URL =
            "https://adoring-pasteur-3ae17d.netlify.app/signin.html";

    // mai generic: primul input de email / password de pe pagină
    private static final By EMAIL_INPUT =
            By.cssSelector("input[type='email']");
    private static final By PASSWORD_INPUT =
            By.cssSelector("input[type='password']");
    private static final By LOGIN_BUTTON =
            By.cssSelector("button[type='submit'], input[type='submit']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(SIGNIN_URL);
    }

    public void login(String email, String password) {
        type(EMAIL_INPUT, email);
        type(PASSWORD_INPUT, password);
        click(LOGIN_BUTTON);
    }
}
