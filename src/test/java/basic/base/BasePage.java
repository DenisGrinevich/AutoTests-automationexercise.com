/*
Базовый класс для страницы с общими методами для всех страниц
 */

package basic.base;

import component.FooterComponent;
import component.HeaderComponent;
import component.LeftSidebarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage  {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HeaderComponent getHeader() {
        return new HeaderComponent(driver);
    }

    public LeftSidebarComponent getSidebar() {
        return new LeftSidebarComponent(driver);
    }

    public FooterComponent getFooter() {
        return new FooterComponent(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}




