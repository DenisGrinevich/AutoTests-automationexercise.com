package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.main.HomePage;


public class HomePageTest extends BaseTest {
    public static final String URL_MAIN = "https://automationexercise.com/";

    @Test
    public void testViewProductButton() {
        int itemNumber = 5;
        String productURL = new HomePage(getDriver())
                .clickOnViewProductButton(itemNumber)
                .getCurrentUrl();

        String expectedUrl = URL_MAIN + "product_details/" + itemNumber;

        Assert.assertEquals(productURL, expectedUrl);
    }


}


