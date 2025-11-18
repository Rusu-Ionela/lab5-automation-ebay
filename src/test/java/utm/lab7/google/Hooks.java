package utm.lab7.google;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
public class Hooks {
    public static WebDriver driver;
    private WebDriver createLocalDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver local = new ChromeDriver();
        local.manage().window().maximize();
        return local;
    }
    private WebDriver createBrowserStackDriver() throws MalformedURLException {
        String USERNAME = "USERNAME_TAU_DE_LA_BROWSERSTACK";
        String ACCESS_KEY = "ACCESS_KEY_TA";
        String remoteUrl = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "latest");
        MutableCapabilities bstackOptions = new MutableCapabilities();
        bstackOptions.setCapability("os", "Windows");
        bstackOptions.setCapability("osVersion", "11");
        bstackOptions.setCapability("projectName", "Lab 7 CPP");
        bstackOptions.setCapability("buildName", "Lab7-Google-Cucumber");
        bstackOptions.setCapability("sessionName", "Google search basic tests");

        caps.setCapability("bstack:options", bstackOptions);

        return new RemoteWebDriver(new URL(remoteUrl), caps);
    }

    @Before
    public void setUp() throws MalformedURLException {
        String mode = System.getProperty("runMode", "local"); // default local

        if ("browserstack".equalsIgnoreCase(mode)) {
            System.out.println("[INFO] Pornez sesiune pe BrowserStack");
            driver = createBrowserStackDriver();
        } else {
            System.out.println("[INFO] Pornez sesiune local pe Chrome");
            driver = createLocalDriver();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
