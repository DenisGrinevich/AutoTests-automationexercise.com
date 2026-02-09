package pages;

import basic.base.BasePage;
import basic.tools.Logging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
        Logging.info("Открыта страница категории " + pageTitle.getText());
    }

    @FindBy(css = "h2.text-center")
    private WebElement pageTitle;

    public boolean checkCategoryPage(String category, String subCategory) {
        if (!waitForVisibleElement(By.xpath("//h2[@class='title text-center' and normalize-space(.) ='" + category + " - " + subCategory + " Products']")).isDisplayed())
            throw new AssertionError("Это страница не категории " + category + " и подкатегории " + subCategory + ", а " + pageTitle.getText());

        return true;
    }
}







