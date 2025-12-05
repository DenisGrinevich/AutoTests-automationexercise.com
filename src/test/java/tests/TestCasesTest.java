package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesTest extends BaseTest {

    @Test(description = "№7: Verify Test Cases Page")
    public void testCheckTestCasesPage() {
        boolean page = Navigate.toHomePage(getDriver())
                .getHeader()
                .clickTestCasesButton()
                .checkTestCasesPage();

        Assert.assertTrue(page);
    }

}
