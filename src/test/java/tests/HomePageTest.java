package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class HomePageTest extends BaseTest {
    public static final String URL_MAIN = "https://automationexercise.com/";
    public static final String EMAIL = "test@test.com";

    @Test
    public void testViewProductButton() {
        int itemNumber = 5;
        String productURL = new HomePage(getDriver())
                .clickOnViewProductButton(itemNumber)
                .getCurrentUrl();

        String expectedUrl = URL_MAIN + "product_details/" + itemNumber;

        Assert.assertEquals(productURL, expectedUrl);
    }

    @Test
    public void testSubscription() {
        String alert = new HomePage(getDriver())
                .checkHomePage()
                .getFooter()
                .verifySubscriptionFormName()
                .enterEmailToSubscribe(EMAIL)
                .clickOnSubscribeButton()
                .getTextAfterSubscribing();

        Assert.assertEquals(alert, "You have been successfully subscribed!");
    }


}


