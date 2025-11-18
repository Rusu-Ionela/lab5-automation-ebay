package stepdefs;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class SignInSteps {

    @When("I try to sign in with invalid credentials")
    public void i_try_to_sign_in_with_invalid_credentials() {
        Hooks1.driver.get("https://adoring-pasteur-3ae17d.netlify.app/signin.html");

        Hooks1.driver.findElement(By.id("exampleInputEmail1"))
                .sendKeys("ionela@test");

        Hooks1.driver.findElement(By.id("exampleInputPassword1"))
                .sendKeys("wrong123");

        Hooks1.driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
