package component.products;

import basic.base.BaseProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartProduct extends BaseProduct {
    private final WebElement container;
    private int id;
    private String name;
    private int price;
    private int quantity;

    public CartProduct(WebElement container, WebDriver driver) {
        super(driver);
        this.container = container;
        parseData();
    }

    @Override
    protected void parseData() {
        id = Integer.parseInt(container.getAttribute("id").replace("product-", "").trim());
        name = container.findElement(By.xpath("./td[@class='cart_description']/h4/a")).getText();
        price = Integer.parseInt(container.findElement(By.xpath("./td[@class='cart_total']/p[@class='cart_total_price']")).getText().replace("Rs. ", "").trim());
        quantity = Integer.parseInt(container.findElement(By.xpath("./td[@class='cart_quantity']/button")).getText());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void clickOnDeleteButton() {
        waitForClickableElement(container.findElement(By.className("cart_quantity_delete"))).click();
    }

}
