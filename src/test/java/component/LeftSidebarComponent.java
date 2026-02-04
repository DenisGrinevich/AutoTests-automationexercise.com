package component;

import basic.base.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CategoryPage;

public class LeftSidebarComponent extends BaseComponent {
    public LeftSidebarComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'accordian']")
    private WebElement categoryBar;

    @FindBy (xpath = "//div[@class = 'panel-collapse in']/div[@class = 'panel-body']")
    private WebElement subCategoryBar;

    private WebElement getCategory(String categoryName){
        return categoryBar.findElement(By.xpath(".//a[normalize-space() ='"+categoryName+"']"));
    }

    private WebElement getSubCategory(String subCategoryName){
        return waitForLoadedElement(By.xpath(".//div[@class = 'panel-collapse in']//a[normalize-space()='"+subCategoryName+"']"));

    }

    public LeftSidebarComponent clickOnCategory(String categoryName){
        waitForClickableElement(getCategory(categoryName)).click();
        return this;
    }

    public CategoryPage clickOnSubCategory(String subCategoryName){
        waitForClickableElement(getSubCategory(subCategoryName)).click();
        return new CategoryPage(getDriver());
    }


}
