package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.main.HomePage;

public class ContactUsPageTest extends BaseTest {

    @Test
    public void testSendContactForm(){
        String homepage = new HomePage(getDriver())
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
                .checkHomePage()
                .getCurrentUrl();

        Assert.assertEquals(homepage, "https://automationexercise.com/");

    }
}