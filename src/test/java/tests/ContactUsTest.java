/*
Класс для тестов, связанных со связью с работниками магазина
 */

package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {

    @Test(description = "№6: Contact Us Form")
    public void testSendContactForm() {
        boolean homepage = Navigate.toHomePage(getDriver())
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