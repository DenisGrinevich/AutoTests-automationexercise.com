/*
Page Object класс для страницы с тесткейсами
 */

package pages;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkTestCasesPage() {
        try {
            return WaitUtils.waitForVisibleElement(driver,
                    By.xpath("//h2[@class='title text-center']/b[contains(text(),'Test Cases')]"))
                    .isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Заголовок страницы \"Test cases\" не совпадает с текущим");
        }

    }
}
