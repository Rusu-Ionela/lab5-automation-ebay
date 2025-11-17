package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private static final By PRODUCT_TITLE =
            By.cssSelector(".single-right-left h3");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return getText(PRODUCT_TITLE);
    }
}
