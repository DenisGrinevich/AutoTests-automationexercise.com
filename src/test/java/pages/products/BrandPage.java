/*
Page Object класс для страницы листинга товаров определенного бренда, в нем элементы и методы для взаимодействия со страницей
 */

package pages.products;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import component.ProductsListComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandPage extends BasePage {
    public BrandPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2.text-center")
    private WebElement pageTitle;

    public ProductsListComponent getProductList(){
        return new ProductsListComponent(driver);
    }

    public boolean checkBrandPage(String brandName) {
        if (!WaitUtils.waitForVisibleElement(driver, By.xpath("//h2[@class='title text-center' and normalize-space(.) ='Brand - " + brandName + " Products']")).isDisplayed())
            throw new AssertionError("Это страница не бренда " + brandName + ", а " + pageTitle.getText());

        return true;
    }
}







