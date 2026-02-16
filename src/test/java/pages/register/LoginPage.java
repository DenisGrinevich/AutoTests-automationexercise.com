package pages.register;

import basic.base.BasePage;
import basic.tools.Logging;
import component.users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-qa='signup-name']")
    protected WebElement nameField;

    @FindBy(css = "[data-qa='signup-email']")
    protected WebElement signupEmailField;

    @FindBy(css = "[data-qa='login-email']")
    protected WebElement loginEmailField;

    @FindBy(css = "[data-qa='login-password']")
    protected WebElement loginPasswordField;

    @FindBy(css = "[data-qa='signup-button']")
    protected WebElement signupButton;

    @FindBy(css = "[data-qa='login-button']")
    protected WebElement loginButton;

    public static final String URL = ("/login");

    public LoginPage(WebDriver driver) {
        super(driver);
        Logging.info("Открыта страница логина");
    }

    public LoginPage checkSignupFormName() {

        if (!waitForVisibleElement(By.xpath("//*[.='New User Signup!']")).isDisplayed())
            throw new AssertionError("Текст \"New User Signup!\" не найден");

        return this;
    }


    public String getLoginFormName() {
        return getWait().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='login-form']/h2"))).getText();
    }

    public boolean isUnsuccessfulLoginTextDisplayed() {
        try {
            return waitForVisibleElement(By.xpath("//*[.='Your email or password is incorrect!']"))
                    .isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Текст об некорректном логине или пароле не найден");
        }
    }

    public boolean isUnsuccessfulRegistrationTextDisplayed() {
        try {
            return waitForVisibleElement(By.xpath("//*[.='Email Address already exist!']"))
                    .isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Текст о существующем логине не найден");
        }
    }

    public LoginPage enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public LoginPage enterEmail(String email) {
        signupEmailField.clear();
        signupEmailField.sendKeys(email);
        return this;
    }

    public SignupPage clickSignupButton() {
        waitForClickableElement(signupButton).click();
        return new SignupPage(getDriver());
    }

    public LoginPage clickSignupButtonWithIncorrectData() {
        waitForClickableElement(signupButton).click();
        return this;
    }


    public LoginPage enterLogin(String login) {
        loginEmailField.clear();
        loginEmailField.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        loginPasswordField.clear();
        loginPasswordField.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        waitForClickableElement(loginButton).click();
        return new HomePage(getDriver());
    }

    public LoginPage clickLoginButtonWithIncorrectData() {
        waitForClickableElement(loginButton).click();
        return this;
    }

    public HomePage login(User user) {
        enterLogin(user.getEmail()).enterPassword(user.getPassword())
                .clickLoginButton();
        return new HomePage(getDriver());
    }
}
