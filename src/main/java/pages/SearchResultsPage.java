package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import utils.webReausableMethods;

public class SearchResultsPage {

    private Page page;

    public SearchResultsPage(Page page) {
        this.page = page;
    }

    public boolean isResultsDisplayed() {
        Locator products = page.locator("div.s-main-slot div[data-component-type='s-search-result']");

        products.first().waitFor(new Locator.WaitForOptions()
            .setTimeout(10000));

        return page.locator("div.s-main-slot").first().isVisible();
        
    }

    public void selectProduct(String productName) {
        page.click("text=" + productName);
    }

    public void selectProductFromProductPage(String productName) {

        Locator product = page.locator("div.s-main-slot div[data-component-type='s-search-result']")
            .filter(new Locator.FilterOptions().setHasText(productName))
            .first();

        product.waitFor(new Locator.WaitForOptions().setTimeout(10000));
        product.scrollIntoViewIfNeeded();
        page.click("text=" + productName);

    }

    public int getProductPrice() {
    String priceText = page.locator("span.a-price-whole").first().innerText();
    return webReausableMethods.extractPrice(priceText);
    }
}