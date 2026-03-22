package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class AmazonProductSearchTest extends BaseTest 
{

   
    @Test
    public void verifyAddToCartProject() throws InterruptedException
    {
         HomePage home = new HomePage(page);
         SearchResultsPage results = new SearchResultsPage(page);
         ProductPage product = new ProductPage(page);
         CartPage cart = new CartPage(page);
    
        home.searchProduct("HP smart tank");
        Assert.assertTrue(results.isResultsDisplayed(), "No search results");

        results.selectProductFromProductPage("Smart Tank 589");
        Assert.assertTrue(product.isProductPageDisplayed(), "Product page not opened");

        int perProductPrice = results.getProductPrice();
        System.out.println("pricePerProduct: "+perProductPrice);

        product.selectQuantity("2");
        product.clickAddToCart();

        Assert.assertTrue(cart.getCartSubTotalSection(), "Cart Sub Total not displayed");
        int subTotal = cart.getSubtotalPrice();
        System.out.println("Subtotal: " + subTotal);

        Thread.sleep(2000);
        Assert.assertEquals(subTotal, perProductPrice * 2, "Subtotal mismatch!");

        product.goToCart();

        Assert.assertTrue(cart.isCartDisplayed(), "Cart not displayed");

        Assert.assertTrue(cart.getProductName().contains("Smart Tank 589"));
        System.out.println("Product Name: " + cart.getProductName());

        Assert.assertEquals(cart.getQuantity(), "2");
        System.out.println("Product Quantity: " + cart.getQuantity());

    }
        
}