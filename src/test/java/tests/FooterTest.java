package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {

    private static final String EMAIL = "test@test.com";

    @Test(description = "№10: Verify Subscription in home page")
    public void testSubscriptionOnHomePage() {
        String alert = Navigate.toHomePage(getDriver())
                .checkHomePage()
                .getFooter()
                .verifySubscriptionFormName()
                .enterEmailToSubscribe(EMAIL)
                .clickOnSubscribeButton()
                .getTextAfterSubscribing();

        Assert.assertEquals(alert, "You have been successfully subscribed!");
    }

    @Test(description = "№11: Verify Subscription in Cart page")
    public void testSubscriptionOnCartPage() {
        String alert = Navigate.toCartPage(getDriver())
                .checkCartPage()
                .getFooter()
                .verifySubscriptionFormName()
                .enterEmailToSubscribe(EMAIL)
                .clickOnSubscribeButton()
                .getTextAfterSubscribing();

        Assert.assertEquals(alert, "You have been successfully subscribed!");
    }
}


