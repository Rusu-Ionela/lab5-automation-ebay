package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    private static final By HEADER_TITLE =
            By.cssSelector("h3.tittle-w3l");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getText(HEADER_TITLE);
    }
}
