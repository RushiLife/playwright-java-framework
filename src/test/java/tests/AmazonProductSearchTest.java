package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class AmazonProductSearchTest extends BaseTest 
{

   
    @Test
    public void verifyAddToCartProject()
    {
         HomePage home = new HomePage(page);
    
        home.searchProduct("HP smart tank");
    }
        
}