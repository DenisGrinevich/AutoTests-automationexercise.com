package pages;

import basic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public enum Gender {Mr, Mrs;}

    @FindBy(css = "[data-qa='name']")
    protected WebElement nameField;

    @FindBy(css = "[data-qa='email']")
    protected WebElement emailField;

    @FindBy(css = "[data-qa='password']")
    protected WebElement passwordField;

    @FindBy(css = "[data-qa='first_name']")
    protected WebElement firstNameField;

    @FindBy(css = "[data-qa='last_name']")
    protected WebElement lastNameField;

    @FindBy(css = "[data-qa='company']")
    protected WebElement companyField;

    @FindBy(css = "[data-qa='address']")
    protected WebElement addressField;

    @FindBy(css = "[data-qa='address2']")
    protected WebElement secondAddressField;

    @FindBy(css = "[data-qa='state']")
    protected WebElement stateField;

    @FindBy(css = "[data-qa='city']")
    protected WebElement citydField;

    @FindBy(css = "[data-qa='zipcode']")
    protected WebElement zipCodeField;

    @FindBy(css = "[data-qa='mobile_number']")
    protected WebElement mobileNumberField;

    @FindBy(css = "[data-qa='days']")
    protected WebElement dayDropdown;

    @FindBy(css = "[data-qa='months']")
    protected WebElement monthDropdown;

    @FindBy(css = "[data-qa='years']")
    protected WebElement yearDropdown;

    @FindBy(css = "[id='newsletter']")
    protected WebElement newsletterCheckbox;

    @FindBy(css = "[id='optin']")
    protected WebElement offersCheckbox;

    @FindBy(css = "[data-qa='country']")
    protected WebElement countryDropdown;


    public String getEnterAccountText() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))).getText();

    }

    public SignupPage selectGenderButton(Gender gender) {
        waitForClickableElement(By.xpath("//input[@type='radio' and @value = '" + gender + "']")).click();
        return this;
    }

    public SignupPage checkName(String nameFromLogin) {
        try {
            if (nameField.getAttribute("value").equals(nameFromLogin)) {
                return this;
            } else {
                sendName(nameFromLogin);
                return this;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public SignupPage sendName(String name) {
        nameField.sendKeys(name);
        return this;
    }


    public SignupPage checkEmail(String emailFromLogin) {
        if (!emailField.getAttribute("value").equals(emailFromLogin)) {
            throw new AssertionError("Емейлы не совпадают");
        }
        return this;
    }


    public SignupPage sendPassword(String text) {
        passwordField.clear();
        passwordField.sendKeys(text);
        return this;
    }

    public SignupPage sendFirstName(String text) {
        firstNameField.clear();
        firstNameField.sendKeys(text);
        return this;
    }

    public SignupPage sendLastName(String text) {
        lastNameField.clear();
        lastNameField.sendKeys(text);
        return this;
    }

    public SignupPage sendCompany(String text) {
        companyField.clear();
        companyField.sendKeys(text);
        return this;
    }

    public SignupPage sendAddress(String text) {
        addressField.clear();
        addressField.sendKeys(text);
        return this;
    }

    public SignupPage sendSecondAddress(String text) {
        secondAddressField.clear();
        secondAddressField.sendKeys(text);
        return this;
    }

    public SignupPage sendState(String text) {
        stateField.clear();
        stateField.sendKeys(text);
        return this;
    }

    public SignupPage sendCity(String text) {
        citydField.clear();
        citydField.sendKeys(text);
        return this;
    }

    public SignupPage sendZipcode(String text) {
        zipCodeField.clear();
        zipCodeField.sendKeys(text);
        return this;
    }

    public SignupPage sendMobileNumber(String text) {
        mobileNumberField.clear();
        mobileNumberField.sendKeys(text);
        return this;
    }

    public SignupPage chooseDay(String value) {
        new Select(dayDropdown).selectByValue(value);
        return this;
    }

    public SignupPage chooseMonth(String value) {
        new Select(monthDropdown).selectByValue(value);
        return this;
    }

    public SignupPage chooseYear(String value) {
        new Select(yearDropdown).selectByValue(value);
        return this;
    }

    public SignupPage chooseCountry(String value) {
        new Select(countryDropdown).selectByValue(value);
        return this;
    }

    public SignupPage selectOffersCheckbox() {
        offersCheckbox.click();
        return this;
    }

    public SignupPage selectNewsletterCheckbox() {
        newsletterCheckbox.click();
        return this;
    }

    public AccountCreatedPage clickCreateAccountButton() {
        waitForClickableElement(By.cssSelector("[data-qa='create-account']")).click();
        return new AccountCreatedPage(getDriver());
    }
}