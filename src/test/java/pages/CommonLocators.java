package pages;

import org.openqa.selenium.By;

public class CommonLocators {

    // Bara breadcrumb (Home / Men's Wear)
    public static final By BREADCRUMB_BAR =
            By.cssSelector(".services-breadcrumb ul.w3_short");

    // Elemente din breadcrumb (li)
    public static final By BREADCRUMB_ITEMS =
            By.cssSelector(".services-breadcrumb ul.w3_short li");

    // Panou filtre (FILTER BY PRICE)
    public static final By FILTERS_PANEL = By.cssSelector("AICI_SELECTORUL_TAU");


    // Dropdown Sort By
    public static final By SORT_BY_DROPDOWN =
            By.cssSelector("select.form-control");

    // Lista de produse
    public static final By PRODUCTS_LIST =
            By.cssSelector(".product-men");

    // Butoane „Quick View”
    public static final By QUICK_VIEW_BUTTONS =
            By.cssSelector(".product-men .link-product-add-cart");

    // Link Contact din navbar
    public static final By NAV_CONTACT_LINK =
            By.linkText("Contact");

    // Link Contact din footer
    public static final By FOOTER_CONTACT_LINK =
            By.xpath("//div[contains(@class,'footer')]//a[contains(text(),'Contact')]");
}
