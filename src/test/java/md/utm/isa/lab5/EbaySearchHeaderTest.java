package md.utm.isa.lab5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EbaySearchHeaderTest {

    private static void silenceLogs() {
        // 1) Taie JUL (java.util.logging) – sursa mesajelor "WARNING:"
        Logger root = Logger.getLogger("");
        root.setLevel(Level.OFF);
        for (Handler h : root.getHandlers()) {
            h.setLevel(Level.OFF);
        }
        Logger.getLogger("org.openqa").setLevel(Level.OFF);
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        // 2) Reduc SLF4J-simple la "error" (dacă apare ceva transitive)
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "error");

        // 3) Oprește logurile ChromeDriver
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        silenceLogs();                             // 🔇 înainte de orice inițializare Selenium
        WebDriverManager.chromedriver().setup();   // manager pentru driver
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        // opțional: rulează mai "curat" și stabil
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    @AfterEach
    void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    @DisplayName("Variant 4: Open ebay.com, search 'computer', check header is displayed")
    void searchComputerAndCheckHeader() {
        driver.get("https://www.ebay.com/");
        handleOptionalCookieBanner();

        // Folosim ENTER în căsuța de căutare (mai robust decât click pe buton)
        By searchBox = By.id("gh-ac");
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        box.clear();
        box.sendKeys("computer");
        box.sendKeys(Keys.ENTER);

        // Header-ul eBay (id="gh") trebuie să fie vizibil după căutare
        By header = By.id("gh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        assertTrue(driver.findElement(header).isDisplayed(), "eBay header should be visible after search");
    }

    private void handleOptionalCookieBanner() {
        // Închidem bannerele dacă apar; încercăm câteva selecții comune
        clickIfPresent(By.cssSelector("button[aria-label='Accept all']"));
        clickIfPresent(By.id("gdpr-banner-accept"));
        clickIfPresent(By.xpath("//button[contains(.,'Accept') or contains(.,'Accept All')]"));
    }

    private void clickIfPresent(By locator) {
        try {
            WebElement el = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
        } catch (TimeoutException ignored) {
        }
    }
}
