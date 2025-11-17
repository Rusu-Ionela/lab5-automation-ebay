package stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MensWearPage;
import pages.ProductPage;
import java.util.List;

public class MensWearSteps {

    private final MensWearPage mensWearPage;
    private final ProductPage productPage;

    public MensWearSteps() {
        WebDriver driver = stepdefs.Hooks.driver;
        this.mensWearPage = new MensWearPage(driver);
        this.productPage = new ProductPage(driver);
    }

    @When("I select sort option {string}")
    public void i_select_sort_option(String optionText) {
        mensWearPage.selectSortOptionByVisibleText(optionText);
    }

    @Then("product names should remain in the same order")
    public void product_names_should_remain_in_the_same_order() {
        List<String> namesBefore = mensWearPage.getProductNames();
        List<String> namesAfter = mensWearPage.getProductNames();
        Assert.assertEquals(namesBefore, namesAfter);
    }

    @Then("product prices should remain in the same order")
    public void product_prices_should_remain_in_the_same_order() {
        List<Double> pricesBefore = mensWearPage.getProductPrices();
        List<Double> pricesAfter = mensWearPage.getProductPrices();
        Assert.assertEquals(pricesBefore, pricesAfter);
    }

    /* ---------- UI elements ---------- */

    @And("I should see the filters panel")
    public void i_should_see_the_filters_panel() {
        Assert.assertTrue(mensWearPage.isFiltersPanelVisible());
    }

    @And("I should see the sort by dropdown")
    public void i_should_see_the_sort_by_dropdown() {
        Assert.assertTrue(mensWearPage.isSortByVisible());
    }

    @And("I should see the products list with Quick View buttons")
    public void i_should_see_the_products_list_with_quick_view_buttons() {
        Assert.assertTrue(mensWearPage.hasProductsWithQuickView());
    }

    @Then("I should see at least {int} product in the list")
    public void i_should_see_at_least_product_in_the_list(Integer min) {
        Assert.assertTrue(mensWearPage.getProductsCount() >= min);
    }

    /* ---------- Quick View ---------- */

    @When("I click Quick View on the first product in list")
    public void i_click_quick_view_on_the_first_product_in_list() {
        mensWearPage.clickFirstQuickView();
    }

    @Then("I should see product page with title {string}")
    public void i_should_see_product_page_with_title(String expectedTitle) {
        Assert.assertTrue(
                productPage.getProductTitle().contains(expectedTitle)
        );
    }
}
