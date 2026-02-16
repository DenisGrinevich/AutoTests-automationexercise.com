package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {

    private final static String SEARCH_REQUEST = "Blue";

    @Test(description = "№9: Search Product", groups = {"smoke"})
    public void testSearchProductName() {

        boolean productNames = Navigate.toHomePage(getDriver())
                .checkHomePage()
                .getHeader()
                .clickProductsButton()
                .checkAllProductsPage()
                .enterSearchRequest(SEARCH_REQUEST)
                .checkSearchResultPage()
                .checkSearchRequestInProductName(SEARCH_REQUEST);

        Assert.assertTrue(productNames);

    }
}
