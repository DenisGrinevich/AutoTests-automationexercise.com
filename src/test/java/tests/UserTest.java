package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.SignupPage.Gender.Mr;

public class UserTest extends BaseTest {
    public static String NAME = "James";
    public static String EMAIL = "james@test.test";
    public static String PASSWORD = "james@test.test";



    @Test(description = "№1: Register User")
    public void testUserRegistration() {
        String name = Navigate.toHomePage(getDriver())
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

    @Test(description = "№2: Login User with correct email and password", dependsOnMethods = "testUserRegistration")
    public void testSuccessLogin() {
        String name = Navigate.toLoginPage(getDriver())
                .checkSignupFormName()
                .enterLogin(EMAIL)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .getHeader()
                .getUserName();

        Assert.assertEquals(name, NAME);

    }

    @Test(description = "№4: Logout User", dependsOnMethods = "testSuccessLogin")
    public void testSuccessLogout() {
        String text = Navigate.toLoginPage(getDriver())
                .login(EMAIL, PASSWORD)
                .getHeader()
                .clickLogoutButton()
                .getLoginFormName();

        Assert.assertEquals(text, "Login to your account");
    }

    @Test(description = "№5: Register User with existing email", dependsOnMethods = "testSuccessLogout")
    public void testExistingEmailRegistration() {
        boolean text = Navigate.toLoginPage(getDriver())
                .enterName(NAME)
                .enterEmail(EMAIL)
                .clickSignupButtonWithIncorrectData()
                .isUnsuccessfulRegistrationTextDisplayed();

        Assert.assertTrue(text);
    }

    @Test(description = "Delete User", dependsOnMethods = "testExistingEmailRegistration")
    public void testDeleteUser(){
        boolean page = Navigate.toLoginPage(getDriver())
                .login(EMAIL, PASSWORD)
                .getHeader()
                .clickDeleteAccountButton()
                .checkAccountDeletedPageText()
                .clickContinueButton()
                .isHomepageDisplayed();

        Assert.assertTrue(page);

    }

    @Test(description = "№3: Login User with incorrect email and password", dependsOnMethods = "testDeleteUser")
    public void testLoginWithIncorrectData() {

        boolean text = Navigate.toLoginPage(getDriver())
                .enterLogin("qweasdzxc123yy@erewr.trter")
                .enterPassword("aawewe")
                .clickLoginButtonWithIncorrectData()
                .isUnsuccessfulLoginTextDisplayed();

        Assert.assertTrue(text);
    }

}