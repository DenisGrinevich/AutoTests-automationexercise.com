package pages.testcases;

import basic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkTestCasesPage() {
        try {
            return waitForVisibleElement(
                    By.xpath("//h2[@class='title text-center']/b[contains(text(),'Test Cases')]"))
                    .isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Заголовок страницы \"Test cases\" не совпадает с текущим");
        }

    }
}
