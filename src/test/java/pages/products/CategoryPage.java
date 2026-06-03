/*
Page Object класс для страницы листинга товаров определенной категории, в нем элементы и методы для взаимодействия со страницей
 */

package pages.products;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2.text-center")
    private WebElement pageTitle;

    public boolean checkCategoryPage(String category, String subCategory) {
        if (!WaitUtils.waitForVisibleElement(driver, By.xpath("//h2[@class='title text-center' and normalize-space(.) ='" + category + " - " + subCategory + " Products']")).isDisplayed())
            throw new AssertionError("Это страница не категории " + category + " и подкатегории " + subCategory + ", а " + pageTitle.getText());

        return true;
    }
}







