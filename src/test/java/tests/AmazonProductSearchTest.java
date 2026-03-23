package tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import utils.TestDataReader;

@Epic("Amazon Testing")
@Feature("Cart Validation")
public class AmazonProductSearchTest extends BaseTest 
{
    JSONObject data = TestDataReader.getTestData();

    String searchProduct = data.getString("searchProduct");
    String expectedProduct = data.getString("expectedProduct");
    String quantity = data.getString("quantity");

    @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    @Description("Verify add to cart and subtotal validation")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyAddToCartProject() throws InterruptedException
    {
         HomePage home = new HomePage(page);
         SearchResultsPage results = new SearchResultsPage(page);
         ProductPage product = new ProductPage(page);
         CartPage cart = new CartPage(page);
    
        home.searchProduct(searchProduct);
        Assert.assertTrue(results.isResultsDisplayed(), "No search results");

        results.selectProductFromProductPage(expectedProduct);
        Assert.assertTrue(product.isProductPageDisplayed(), "Product page not opened");

        int perProductPrice = results.getProductPrice();
        System.out.println("pricePerProduct: " + perProductPrice);

        product.selectQuantity(quantity);
        product.clickAddToCart();

        Assert.assertTrue(cart.getCartSubTotalSection(), "Cart Sub Total not displayed");
        int subTotal = cart.getSubtotalPrice();
        System.out.println("Subtotal: " + subTotal);

        Thread.sleep(2000);
        Assert.assertEquals(subTotal, perProductPrice * Integer.parseInt(quantity), "Subtotal mismatch!");

        product.goToCart();

        Assert.assertTrue(cart.isCartDisplayed(), "Cart not displayed");

        Assert.assertTrue(cart.getProductName().contains(expectedProduct));
        System.out.println("Product Name: " + cart.getProductName());

        Assert.assertEquals(cart.getQuantity(), "1");
        System.out.println("Product Quantity: " + cart.getQuantity());

    }
        
}