/*
Класс для компонента левогой сайдбара, т.к. он одинаков для большинства листинговых страниц
 */

package component;

import basic.base.BaseComponent;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.products.BrandPage;
import pages.products.CategoryPage;

public class LeftSidebarComponent extends BaseComponent {
    public LeftSidebarComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'accordian']")
    private WebElement categoryBar;

    @FindBy(xpath = "//div[@class = 'brands-name']")
    private WebElement brandBar;

    @FindBy (xpath = "//div[@class = 'panel-collapse in']/div[@class = 'panel-body']")
    private WebElement subCategoryBar;

    private WebElement getCategory(String categoryName){
        return categoryBar.findElement(By.xpath(".//a[normalize-space() ='"+categoryName+"']"));
    }

    private WebElement getSubCategory(String subCategoryName){
        return WaitUtils.waitForLoadedElement(driver, By.xpath(".//div[@class = 'panel-collapse in']//a[normalize-space()='"+subCategoryName+"']"));

    }

    public LeftSidebarComponent clickOnCategory(String categoryName){
        WaitUtils.waitForClickableElement(driver, getCategory(categoryName)).click();
        return this;
    }

    public CategoryPage clickOnSubCategory(String subCategoryName){
        WaitUtils.waitForClickableElement(driver, getSubCategory(subCategoryName)).click();

        return new CategoryPage(driver);
    }

    private WebElement getBrand(String brandName){
        return brandBar.findElement(By.xpath(".//a[text()[normalize-space()='" + brandName + "']]"));
    }

    public BrandPage clickOnBrand(String brandName){
        WaitUtils.waitForClickableElement(driver, getBrand(brandName)).click();
        return new BrandPage(driver);
    }
}
