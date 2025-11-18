package utm.lab7.google;

import org.openqa.selenium.By;

public class GoogleLocators {

    // Home page
    public static final By SEARCH_BOX = By.name("q");
    public static final By SEARCH_BUTTON = By.name("btnK");

    // Results page – numărăm toate titlurile de rezultate
    public static final By SEARCH_RESULTS =
            By.xpath("//div[@id='search']//h3");

    // „Did you mean / Ai vrut să spui…”
    public static final By DID_YOU_MEAN =
            By.cssSelector("a[aria-label*='Ai vrut să spui'], a[aria-label*='Did you mean']");


    // Logo pentru home page
    public static final By LOGO = By.cssSelector("img[alt='Google']");
}
