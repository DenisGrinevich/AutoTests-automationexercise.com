package tests;

import basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.main.HomePage;

import static pages.signup.SignupPage.Gender.Mr;

public class UserTest extends BaseTest {
    public static String NAME = "James";
    public static String EMAIL = "james@test.test";
    public static String PASSWORD = "james@test.test";

    @Test
    public void testUserRegistration() {
        String name = new HomePage(getDriver())
                .getHeader()
                .clickSignupLoginButton()
                .checkSignupFormName()
                .enterName(NAME)
                .enterEmail(EMAIL)
                .clickSignupButton()

                .selectGenderButton(Mr)
                .checkEmail(EMAIL)
                .checkName(NAME)
                .sendPassword(PASSWORD)
                .chooseDay("12").chooseMonth("5").chooseYear("1995")
                .selectNewsletterCheckbox().selectOffersCheckbox()
                .sendFirstName("fast").sendLastName("boy").sendCompany("JJJ")
                .sendAddress("FGFG").sendSecondAddress("QWEWE")
                .chooseCountry("India").sendState("CAL").sendCity("NY")
                .sendZipcode("123123123")
                .sendMobileNumber("666333")

                .clickCreateAccountButton()
                .clickContinueButton()
                .checkHomePage()
                .getHeader()
                .getUserName();

        Assert.assertEquals(name, NAME);
    }

    @Test(dependsOnMethods = "testUserRegistration")
    public void testSuccessLogin() {
        String name = new HomePage(getDriver())
                .getHeader()
                .clickSignupLoginButton()
                .checkSignupFormName()
                .enterLogin(EMAIL)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .getHeader()
                .getUserName();

        Assert.assertEquals(name, NAME);

    }

    @Test(dependsOnMethods = "testUserRegistration")
    public void testSuccessLogout() {
        String text = new HomePage(getDriver())
                .login(EMAIL, PASSWORD)
                .getHeader()
                .clickLogoutButton()
                .getLoginFormName();

        Assert.assertEquals(text, "Login to your account");
    }

    @Test(dependsOnMethods = "testSuccessLogin")
    public void testExistingEmailRegistration() {
        boolean text = new HomePage(getDriver())
                .getHeader()
                .clickSignupLoginButton()
                .enterName(NAME)
                .enterEmail(EMAIL)
                .clickSignupButtonWithIncorrectData()
                .isUnsuccessfulRegistrationTextDisplayed();

        Assert.assertTrue(text);
    }

    @Test
    public void testLoginWithIncorrectData() {

        boolean text = new HomePage(getDriver())
                .getHeader()
                .clickSignupLoginButton()
                .enterLogin("qweasdzxc123yy@erewr.trter")
                .enterPassword("aawewe")
                .clickLoginButtonWithIncorrectData()
                .isUnsuccessfulLoginTextDisplayed();

        Assert.assertTrue(text);
    }
}