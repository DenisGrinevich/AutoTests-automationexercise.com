/*
Базовый класс для компонентов, от которого они наследуются
 */

package basic.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent {

    protected final WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
