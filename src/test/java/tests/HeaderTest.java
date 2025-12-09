package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HeaderTest extends BaseTest {

    @Test(description = "Go to the Main Page by Logo")
    public void testMainLogoTransition() {
        String mainPageUrl = Navigate.toLoginPage(getDriver())
                .getHeader()
                .clickSiteLogo()
                .getCurrentUrl();
        Assert.assertEquals(mainPageUrl, Navigate.toHomePage(getDriver()).getCurrentUrl());
    }

    @Test(description = "Go to the Main Page by Home Button")
    public void testHomeButtonTransition() {
        String mainPageUrl = Navigate.toProductsPage(getDriver())
                .getHeader()
                .clickHomeButton()
                .getCurrentUrl();
        Assert.assertEquals(mainPageUrl, Navigate.toHomePage(getDriver()).getCurrentUrl());
    }
}
