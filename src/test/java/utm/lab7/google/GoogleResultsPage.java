package utm.lab7.google;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleResultsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public int getResultsCount() {
        try {
            // așteptăm să apară măcar UN rezultat
            wait.until(ExpectedConditions.presenceOfElementLocated(GoogleLocators.SEARCH_RESULTS));
        } catch (TimeoutException e) {
            // dacă nu găsim nimic, întoarcem 0 (testul va pica, dar măcar nu dă alte erori)
        }

        List<WebElement> results = driver.findElements(GoogleLocators.SEARCH_RESULTS);

        // numărăm doar elementele vizibile
        return (int) results.stream()
                .filter(WebElement::isDisplayed)
                .count();
    }

    public boolean isDidYouMeanVisible() {
        // 1) încercăm prin locator
        List<WebElement> links = driver.findElements(GoogleLocators.DID_YOU_MEAN);
        for (WebElement e : links) {
            if (e.isDisplayed()) {
                return true;
            }
        }

        // 2) fallback: verificăm textul din pagină (RO / EN)
        String src = driver.getPageSource().toLowerCase();
        if (src.contains("did you mean") || src.contains("ai vrut să scrii")) {
            return true;
        }

        return false;
    }

    public boolean hasAnyResults() {
        return getResultsCount() > 0;
    }

    public boolean isHomeLogoVisible() {
        List<WebElement> logo = driver.findElements(GoogleLocators.LOGO);
        return !logo.isEmpty() && logo.get(0).isDisplayed();
    }
}
