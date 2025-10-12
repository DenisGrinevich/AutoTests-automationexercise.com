package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.main.HomePage;


public class SearchTest extends BaseTest {
    public static String SEARCH_REQUEST = "Blue";

    @Test
    public void testSearchProductName() {

        boolean productNames = new HomePage(getDriver())
                .checkHomePage()
                .getHeader()
                .clickProductsButton()
                .checkAllProductsPage()
                .enterProductName(SEARCH_REQUEST)
                .checkSearchResultPage()
                .checkRequestInProductName(SEARCH_REQUEST);

        Assert.assertTrue(productNames);

    }

}
