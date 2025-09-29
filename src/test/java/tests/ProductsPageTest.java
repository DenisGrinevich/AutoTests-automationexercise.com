package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.products.ProductsPage;

import static basic.Constants.Urls.URL_PRODUCTS;


public class ProductsPageTest extends BaseTest {
    public static String SEARCH_REQUEST = "Dress";

    @Test
    public void testViewProductButton() {
        String productName = new ProductsPage(getDriver())
                .enterProductName(SEARCH_REQUEST)
                .checkProductsListName();

        Assert.assertTrue(productName.contains(SEARCH_REQUEST.toLowerCase()));

    }
//    @Test
//    public void testHomeButtonTransition()  {
//        String productsPageUrl = new ProductsPage(getDriver()).clickOnHomeButton().getCurrentUrl();
//        Assert.assertEquals(productsPageUrl, URL_PRODUCTS);
//    }
}
