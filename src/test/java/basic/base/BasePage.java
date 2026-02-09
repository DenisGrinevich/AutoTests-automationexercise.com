package basic.base;

import component.FooterComponent;
import component.HeaderComponent;
import component.LeftSidebarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage extends BaseModel {

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderComponent getHeader() {
        return new HeaderComponent(getDriver());
    }

    public LeftSidebarComponent getSidebar() {
        return new LeftSidebarComponent(getDriver());
    }

    public FooterComponent getFooter() {
        return new FooterComponent(getDriver());
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}




