/*
Класс позиции продукта из корзины.
В нем мы можем распарсить его со страницы корзины и здесь же добавлен методы для взаимодействия с конкретной позицией
 */

package component.products;

import basic.base.BaseComponent;
import basic.model.Product;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartProductComponent extends BaseComponent {

    private final WebElement container;

    public CartProductComponent(WebElement container, WebDriver driver) {
        super(driver);
        this.container = container;
    }

    public Product parseData() {
        return new Product(Integer.parseInt(container.getAttribute("id").replace("product-", "").trim()),
                container.findElement(By.xpath("./td[@class='cart_description']/h4/a")).getText(),
                Integer.parseInt(container.findElement(By.xpath("./td[@class='cart_total']/p[@class='cart_total_price']")).getText().replace("Rs. ", "").trim()));

    }

    public Integer getQuantity() {
        return Integer.parseInt(container.findElement(By.xpath("./td[@class='cart_quantity']/button")).getText());
    }

    public void clickOnDeleteButton() {
        WaitUtils.waitForClickableElement(driver, container.findElement(By.className("cart_quantity_delete"))).click();
    }

}
