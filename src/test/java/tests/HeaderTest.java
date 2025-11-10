package tests;

import basic.BaseTest;
import component.HeaderComponent;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HeaderTest extends BaseTest {
    public static final String URL_MAIN = "https://automationexercise.com/";

    @Test
    public void testMainLogoTransition() {
        String mainPageUrl = new HeaderComponent(getDriver())
                .clickSiteLogo()
                .getCurrentUrl();
        Assert.assertEquals(mainPageUrl, URL_MAIN);
    }

    @Test
    public void testHomeButtonTransition() {
        String mainPageUrl = new HeaderComponent(getDriver())
                .clickProductsButton()
                .getHeader()
                .clickHomeButton()
                .getCurrentUrl();
        Assert.assertEquals(mainPageUrl, URL_MAIN);
    }
}
