package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ContactUsTest extends BaseTest {

    @Test
    public void testSendContactForm() {
        boolean homepage = new HomePage(getDriver())
                .getHeader()
                .clickContactUsButton()
                .checkContactFormName()
                .enterName("John")
                .enterEmail("john@testtetet.com")
                .enterSubject("pupupu")
                .enterMessage("a lot of pupupu")
                .uploadFile()
                .clickSubmitButton()
                .clickOkOnAlert()
                .isSuccessSendingTextDisplayed()
                .clickReturnHomeButton()
                .isHomepageDisplayed();

        Assert.assertTrue(homepage);

    }
}