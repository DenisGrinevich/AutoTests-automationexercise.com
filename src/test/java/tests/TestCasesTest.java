package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.main.HomePage;

public class TestCasesTest extends BaseTest {

    @Test
    public void testCheckTestCasesPage() {
        boolean page = new HomePage(getDriver())
                .getHeader()
                .clickTestCasesButton()
                .checkTestCasesPage();

        Assert.assertTrue(page);
    }
}
