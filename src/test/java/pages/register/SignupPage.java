package pages.register;

import basic.base.BasePage;
import basic.tools.Logging;
import component.users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

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

    public SignupPage(WebDriver driver) {
        super(driver);
        Logging.info("Открыта страница регистрации пользователя");
    }

    public String getEnterAccountText() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))).getText();

    }

    public SignupPage selectGenderButton(User user) {
        waitForClickableElement(By.xpath("//input[@type='radio' and @value = '" + user.getGender() + "']")).click();
        return this;
    }

    public SignupPage checkName(User user) {
        try {
            if (nameField.getAttribute("value").equals(user.getName())) {
                return this;
            } else {
                sendName(user);
                return this;
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public SignupPage sendName(User user) {
        waitForClickableElement(nameField).sendKeys(user.getName());
        return this;
    }


    public SignupPage checkEmail(User user) {
        if (!emailField.getAttribute("value").equals(user.getEmail())) {
            throw new AssertionError("Емейлы не совпадают");
        }
        return this;
    }

    public SignupPage sendPassword(User user) {
        waitForClickableElement(passwordField).clear();
        passwordField.sendKeys(user.getPassword());
        return this;
    }

    public SignupPage sendFirstName(User user) {
        waitForClickableElement(firstNameField).clear();
        firstNameField.sendKeys(user.getFirstName());
        return this;
    }

    public SignupPage sendLastName(User user) {
        waitForClickableElement(lastNameField).clear();
        lastNameField.sendKeys(user.getLastName());
        return this;
    }

    public SignupPage sendCompany(User user) {
        waitForClickableElement(companyField).clear();
        companyField.sendKeys(user.getCompany());
        return this;
    }

    public SignupPage sendAddress(User user) {
        waitForClickableElement(addressField).clear();
        addressField.sendKeys(user.getAddress());
        return this;
    }

    public SignupPage sendSecondAddress(User user) {
        waitForClickableElement(secondAddressField).clear();
        secondAddressField.sendKeys(user.getAddress2());
        return this;
    }

    public SignupPage sendState(User user) {
        waitForClickableElement(stateField).clear();
        stateField.sendKeys(user.getState());
        return this;
    }

    public SignupPage sendCity(User user) {
        waitForClickableElement(citydField).clear();
        citydField.sendKeys(user.getCity());
        return this;
    }

    public SignupPage sendZipcode(User user) {
        waitForClickableElement(zipCodeField).clear();
        zipCodeField.sendKeys(user.getZipcode());
        return this;
    }

    public SignupPage sendMobileNumber(User user) {
        waitForClickableElement(mobileNumberField).clear();
        mobileNumberField.sendKeys(user.getMobileNumber());
        return this;
    }

    public SignupPage chooseDay(User user) {
        new Select(waitForClickableElement(dayDropdown)).selectByValue(user.getDayOfBirth());
        return this;
    }

    public SignupPage chooseMonth(User user) {
        new Select(waitForClickableElement(monthDropdown)).selectByValue(user.getMonthOfBirth());
        return this;
    }

    public SignupPage chooseYear(User user) {
        new Select(waitForClickableElement(yearDropdown)).selectByValue(user.getYearOfBirth());
        return this;
    }

    public SignupPage chooseCountry(User user) {
        new Select(waitForClickableElement(countryDropdown)).selectByValue(user.getCountry());
        return this;
    }

    public SignupPage selectOffersCheckbox() {
        waitForClickableElement(offersCheckbox).click();
        return this;
    }

    public SignupPage selectNewsletterCheckbox() {
        waitForClickableElement(newsletterCheckbox).click();
        return this;
    }
    public SignupPage fillFullForm(User user){
        selectGenderButton(user)
                .checkEmail(user)
                .checkName(user)
                .sendPassword(user)
                .chooseDay(user).chooseMonth(user).chooseYear(user)
                .selectNewsletterCheckbox().selectOffersCheckbox()
                .sendFirstName(user).sendLastName(user).sendCompany(user)
                .sendAddress(user).sendSecondAddress(user)
                .chooseCountry(user).sendState(user).sendCity(user)
                .sendZipcode(user)
                .sendMobileNumber(user);
        return this;
    }

    public AccountCreatedPage clickCreateAccountButton() {
        waitForClickableElement(By.cssSelector("[data-qa='create-account']")).click();
        return new AccountCreatedPage(getDriver());
    }
}