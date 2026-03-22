package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
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
    
        home.searchProduct("HP smart tank");
        Assert.assertTrue(results.isResultsDisplayed(), "No search results");

        results.selectProductFromProductPage("Smart Tank 589");
        Assert.assertTrue(product.isProductPageDisplayed(), "Product page not opened");

        product.selectQuantity("2");
        product.clickAddToCart();

    }
        
}