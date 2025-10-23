package basic;

import org.openqa.selenium.WebDriver;

public abstract class BaseProduct extends BaseComponent{
    public BaseProduct(WebDriver driver) {
        super(driver);
    }

    public abstract boolean equals(Object  other);
}
