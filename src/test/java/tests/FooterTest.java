package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class FooterTest extends BaseTest {
    public static final String EMAIL = "test@test.com";

    @Test
    public void testSubscriptionOnHomePage() {
        String alert = new HomePage(getDriver())
                .checkHomePage()
                .getFooter()
                .verifySubscriptionFormName()
                .enterEmailToSubscribe(EMAIL)
                .clickOnSubscribeButton()
                .getTextAfterSubscribing();

        Assert.assertEquals(alert, "You have been successfully subscribed!");
    }

    @Test
    public void testSubscriptionOnCartPage() {
        String alert = new HomePage(getDriver())
                .checkHomePage()
                .getHeader()
                .clickCartButton()
                .checkCartPage()
                .getFooter()
                .verifySubscriptionFormName()
                .enterEmailToSubscribe(EMAIL)
                .clickOnSubscribeButton()
                .getTextAfterSubscribing();

        Assert.assertEquals(alert, "You have been successfully subscribed!");
    }
}


