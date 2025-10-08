package pages.testcases;

import basic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCasesPage extends BasePage {
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkTestCasesPage() {
        try {
            return getWait5().until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[@class='title text-center']/b[contains(text(),'Test Cases')]")))
                    .isDisplayed();
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            throw new RuntimeException(e);
        }

    }
}
