package pages.login;

import basic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.main.HomePage;
import pages.signup.SignupPage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

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


    public LoginPage checkSignupFormName() {
        try {
            getWait10().until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//*[.='New User Signup!']"))).isDisplayed();
            return this;
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            throw new RuntimeException(e);
        }
    }


    public String getLoginFormName() {
        return getWait10().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='login-form']/h2"))).getText();
    }

    public boolean isUnsuccessfulLoginTextDisplayed() {
        try {
            return getWait10().until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("//*[.='Your email or password is incorrect!']")))
                    .isDisplayed();
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            throw new RuntimeException(e);
        }
    }

    public boolean isUnsuccessfulRegistrationTextDisplayed() {
        try {
            return getWait10().until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("//*[.='Email Address already exist!']")))
                    .isDisplayed();
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            throw new RuntimeException(e);
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


}
