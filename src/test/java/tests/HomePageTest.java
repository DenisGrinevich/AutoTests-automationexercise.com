package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {
    public static final String URL_MAIN = "https://automationexercise.com/";

    @Test(description = "Open Product Page", groups = {"smoke"})
    public void testViewProductButton() {

        int itemNumber = 5;

        String productURL = Navigate.toHomePage(getDriver())
                .clickOnViewProductButton(itemNumber)
                .getCurrentUrl();

        String expectedUrl = URL_MAIN + "product_details/" + itemNumber;

        Assert.assertEquals(productURL, expectedUrl);
    }

}


