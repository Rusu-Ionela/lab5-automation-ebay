package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /** Găsește un singur element pe pagină */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Click pe un element după locator */
    protected void click(By locator) {
        find(locator).click();
    }

    /** Scrie text într-un input */
    protected void type(By locator, String text) {
        WebElement el = find(locator);
        el.clear();
        el.sendKeys(text);
    }

    /** Returnează textul dintr-un element */
    protected String getText(By locator) {
        return find(locator).getText();
    }
}
