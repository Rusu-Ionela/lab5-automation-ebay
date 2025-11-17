package md.utm.isa.lab5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EbaySearchHeaderTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Oprește logurile inutile din consolă
    private static void silenceLogs() {
        Logger root = Logger.getLogger("");
        root.setLevel(Level.OFF);
        for (Handler h : root.getHandlers()) {
            h.setLevel(Level.OFF);
        }
        Logger.getLogger("org.openqa").setLevel(Level.OFF);
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "error");
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }

    @BeforeAll
    static void setupClass() {
        silenceLogs();
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            // Pauză de 10 secunde ca să vezi rezultatul în browser
            try {
                Thread.sleep(10000); // 10 secunde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit(); // Închide browser-ul după pauză
        }
    }

    @Test
    @DisplayName("Variant 4: Open ebay.com, search 'computer', check header is displayed")
    void searchComputerAndCheckHeader() {
        driver.get("https://www.ebay.com/");
        handleOptionalCookieBanner();

        WebElement searchBox;
        try {
            searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-ac")));
        } catch (TimeoutException e) {
            searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("_nkw")));
        }

        searchBox.click();
        searchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchBox.sendKeys(Keys.DELETE);
        searchBox.sendKeys("computer");

        wait.until(ExpectedConditions.attributeContains(searchBox, "value", "computer"));

        searchBox.sendKeys(Keys.ENTER);

        By header = By.id("gh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        assertTrue(driver.findElement(header).isDisplayed(),
                "eBay header should be visible after search");
    }

    private void handleOptionalCookieBanner() {
        clickIfPresent(By.cssSelector("button[aria-label='Accept all']"));
        clickIfPresent(By.id("gdpr-banner-accept"));
        clickIfPresent(By.xpath("//button[contains(.,'Accept') or contains(.,'Accept All')]"));
    }

    private void clickIfPresent(By locator) {
        try {
            WebElement el = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
        } catch (TimeoutException ignored) { }
    }
}
