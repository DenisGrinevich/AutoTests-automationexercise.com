package pages;

import basic.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.file.Files;
import java.nio.file.Path;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-qa='name']")
    protected WebElement nameField;

    @FindBy(css = "[data-qa='email']")
    protected WebElement emailField;

    @FindBy(css = "[data-qa='subject']")
    protected WebElement subjectField;

    @FindBy(css = "[data-qa='message']")
    protected WebElement messageField;

    @FindBy(xpath = "//input[@name='upload_file']")
    protected WebElement uploadButton;

    public ContactUsPage checkContactFormName() {
        try {
            getWait().until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//*[.='Get In Touch']"))).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Текст \"Get in Touch \" не найден");
        }

    }

    public ContactUsPage clickSubmitButton() {
        waitForClickableElement(By.cssSelector("[name='submit']")).click();
        return this;
    }

    public HomePage clickReturnHomeButton() {
        waitForClickableElement(By.cssSelector("a.btn")).click();
        return new HomePage(getDriver());
    }

    public ContactUsPage isSuccessSendingTextDisplayed() {
        {
            try {
                getWait().until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[.='Success! Your details have been submitted successfully.']"))).isDisplayed();
                return this;
            } catch (Exception e) {
                throw new RuntimeException("Текст Success! Your details have been submitted successfully. не найден");
            }
        }
    }

    public ContactUsPage enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public ContactUsPage enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public ContactUsPage enterSubject(String text) {
        subjectField.clear();
        subjectField.sendKeys(text);
        return this;
    }

    public ContactUsPage enterMessage(String message) {
        messageField.clear();
        messageField.sendKeys(message);
        return this;
    }


    public ContactUsPage clickOkOnAlert() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        return new ContactUsPage(getDriver());
    }

    public ContactUsPage uploadFile() {

        Path path = Path.of("files", "text.txt");

            if (!Files.exists(path)) {
                throw new NullPointerException("Файл не найден: " + path.toAbsolutePath());
            } else {
                uploadButton.sendKeys(path.toAbsolutePath().toString());
                return this;
            }
        }
    }

