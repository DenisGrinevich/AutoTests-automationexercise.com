package pages;

import basic.base.BaseProductsPage;
import basic.tools.Logging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandPage extends BaseProductsPage<BrandPage> {
    public BrandPage(WebDriver driver) {
        super(driver);
        Logging.info("Открыта страница бренда " + pageTitle.getText());
    }

    @FindBy(css = "h2.text-center")
    private WebElement pageTitle;

    @Override
    protected BrandPage self() {
        return this;
    }

    public boolean checkBrandPage(String brandName) {
        if (!waitForVisibleElement(By.xpath("//h2[@class='title text-center' and normalize-space(.) ='Brand - " + brandName + " Products']")).isDisplayed())
            throw new AssertionError("Это страница не бренда " + brandName + ", а " + pageTitle.getText());

        return true;
    }
}







