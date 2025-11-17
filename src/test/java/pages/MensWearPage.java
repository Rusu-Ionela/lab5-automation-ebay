package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MensWearPage extends BasePage {

    private static final String MENS_WEAR_URL =
            "https://adoring-pasteur-3ae17d.netlify.app/mens.html";

    private static final By PRODUCT_TITLES =
            By.cssSelector(".product-men h4 a");

    private static final By PRODUCT_PRICES =
            By.cssSelector(".product-men .item_price");

    public MensWearPage(WebDriver driver) {
        super(driver);
    }

    /* ----------------- NAV / OPEN PAGE ----------------- */

    public void open() {
        driver.get(MENS_WEAR_URL);
    }

    /* ----------------- BREADCRUMB ----------------- */

    public boolean isBreadcrumbVisible() {
        return find(CommonLocators.BREADCRUMB_BAR).isDisplayed();
    }

    /** Textul complet al breadcrumb-ului (de ex. "Home | Men's Wear") */
    public String getBreadcrumbFullText() {
        return find(CommonLocators.BREADCRUMB_BAR).getText();
    }

    /** Lista de item-uri din breadcrumb (fără | ) */
    public List<String> getBreadcrumbItemsText() {
        List<WebElement> elements = driver.findElements(CommonLocators.BREADCRUMB_ITEMS);
        List<String> texts = new ArrayList<>();

        for (WebElement el : elements) {
            String text = el.getText()
                    .replace("|", "")
                    .trim();
            if (!text.isEmpty()) {
                texts.add(text);
            }
        }

        return texts;
    }

    /** Click pe un item din breadcrumb după label ("Home", "Men's Wear" etc.) */
    public void clickBreadcrumbItem(String label) {
        String normLabel = label.replace("’", "'").trim().toLowerCase();

        List<WebElement> elements = driver.findElements(CommonLocators.BREADCRUMB_ITEMS);

        for (WebElement li : elements) {
            String t = li.getText()
                    .replace("|", "")
                    .replace("’", "'")
                    .trim()
                    .toLowerCase();

            if (t.equals(normLabel)) {
                List<WebElement> links = li.findElements(By.tagName("a"));
                if (!links.isEmpty()) {
                    links.get(0).click();
                } else {
                    li.click();
                }
                return;
            }
        }

        throw new RuntimeException("Breadcrumb item not found: " + label);
    }

    /* ----------------- UI ELEMENTS ----------------- */

    public boolean isFiltersPanelVisible() {
        return find(CommonLocators.FILTERS_PANEL).isDisplayed();
    }

    public boolean isSortByVisible() {
        return find(CommonLocators.SORT_BY_DROPDOWN).isDisplayed();
    }

    public boolean hasProductsWithQuickView() {
        return !driver.findElements(CommonLocators.QUICK_VIEW_BUTTONS).isEmpty();
    }

    public int getProductsCount() {
        return driver.findElements(CommonLocators.PRODUCTS_LIST).size();
    }

    /* ----------------- QUICK VIEW ----------------- */

    public void clickFirstQuickView() {
        List<WebElement> buttons = driver.findElements(CommonLocators.QUICK_VIEW_BUTTONS);

        if (buttons.isEmpty()) {
            throw new RuntimeException("No Quick View buttons found");
        }

        WebElement btn = buttons.get(0);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", btn);
    }

    /* ----------------- SORTARE ----------------- */

    public void selectSortOptionByVisibleText(String optionText) {
        WebElement dropdown = find(CommonLocators.SORT_BY_DROPDOWN);
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

    public List<String> getProductNames() {
        List<WebElement> elements = driver.findElements(PRODUCT_TITLES);
        List<String> names = new ArrayList<>();
        for (WebElement el : elements) {
            names.add(el.getText().trim());
        }
        return names;
    }

    public List<Double> getProductPrices() {
        List<WebElement> elements = driver.findElements(PRODUCT_PRICES);
        List<Double> prices = new ArrayList<>();
        for (WebElement el : elements) {
            String txt = el.getText()
                    .replaceAll("[^0-9.,]", "")
                    .replace(",", ".");
            if (!txt.isEmpty()) {
                prices.add(Double.parseDouble(txt));
            }
        }
        return prices;
    }

    public boolean isListSortedAscending(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        copy.sort(String::compareToIgnoreCase);
        return copy.equals(list);
    }

    public boolean isListSortedAscendingNumbers(List<Double> list) {
        List<Double> copy = new ArrayList<>(list);
        copy.sort(Comparator.naturalOrder());
        return copy.equals(list);
    }

    /* ----------------- CONTACT LINKS ----------------- */

    public void clickNavContact() {
        click(CommonLocators.NAV_CONTACT_LINK);
    }

    public void clickFooterContact() {
        click(CommonLocators.FOOTER_CONTACT_LINK);
    }
}
