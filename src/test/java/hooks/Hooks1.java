package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks1 {

    public static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() {
        // Dacă vrei să NU se închidă browserul după fiecare scenariu,
        // comentează linia de mai jos:
        // driver.quit();
    }
}
