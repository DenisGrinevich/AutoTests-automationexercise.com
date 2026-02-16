package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import basic.tools.UserFactory;
import component.users.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {
    User user = UserFactory.defaultUser();

    private String EMAIL = user.getEmail();
    private String NAME = user.getName();
    private String PASSWORD = user.getPassword();

    @Test(description = "№1: Register User", groups = {"smoke"})
    public void testUserRegistration() {
        String name = Navigate.toHomePage(getDriver())
                .getHeader()
                .clickSignupLoginButton()
                .checkSignupFormName()
                .enterName(NAME)
                .enterEmail(EMAIL)
                .clickSignupButton()
                .fillFullForm(user)
                .clickCreateAccountButton()
                .clickContinueButton()
                .checkHomePage()
                .getHeader()
                .getUserName();

        Assert.assertEquals(name, user.getName());
    }

    @Test(description = "№2: Login User with correct email and password", dependsOnMethods = "testUserRegistration", groups = {"smoke"})
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

    @Test(description = "№4: Logout User", dependsOnMethods = "testSuccessLogin", groups = {"smoke"})
    public void testSuccessLogout() {
        String text = Navigate.toLoginPage(getDriver())
                .login(user)
                .getHeader()
                .clickLogoutButton()
                .getLoginFormName();

        Assert.assertEquals(text, "Login to your account");
    }

    @Test(description = "№5: Register User with existing email", dependsOnMethods = "testSuccessLogout", groups = {"smoke"})
    public void testExistingEmailRegistration() {
        boolean text = Navigate.toLoginPage(getDriver())
                .enterName(NAME)
                .enterEmail(EMAIL)
                .clickSignupButtonWithIncorrectData()
                .isUnsuccessfulRegistrationTextDisplayed();

        Assert.assertTrue(text);
    }

    @Test(description = "Delete User", dependsOnMethods = "testExistingEmailRegistration", groups = {"smoke"})
    public void testDeleteUser(){
        boolean page = Navigate.toLoginPage(getDriver())
                .login(user)
                .getHeader()
                .clickDeleteAccountButton()
                .checkAccountDeletedPageText()
                .clickContinueButton()
                .isHomepageDisplayed();

        Assert.assertTrue(page);

    }

    @Test(description = "№3: Login User with incorrect email and password",dependsOnMethods = "testDeleteUser", groups = {"smoke"})
    public void testLoginWithIncorrectData() {

        boolean text = Navigate.toLoginPage(getDriver())
                .enterLogin(EMAIL)
                .enterPassword(PASSWORD)
                .clickLoginButtonWithIncorrectData()
                .isUnsuccessfulLoginTextDisplayed();

        Assert.assertTrue(text);
    }

}