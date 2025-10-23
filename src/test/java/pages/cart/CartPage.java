package pages.cart;

import basic.BasePage;
import component.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tr[@id]")
    private List<WebElement> productCards;

    public CartPage checkCartPage() {
        try {
            if (waitForVisibleElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']")).isDisplayed()) {
                return this;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new NullPointerException("Открыта не страница корзины");
        }
    }

    public List<WebElement> getAllProductsWebElementsFromPage() {
        try {
            if (productCards.isEmpty())
                return null;
        } catch (Exception e) {
            throw new NullPointerException("В корзине нет товаров");
        }
        return productCards;
    }

    public List<WebElement> getProductsWebElementsFromPage() {
        List<WebElement> list = new ArrayList<>();
        for (int i = 0; i <= getAllProductsWebElementsFromPage().size() - 1; i++) {
            list.add(i, getAllProductsWebElementsFromPage().get(i));
        }
        return list;
    }

    public List<Product> getProductsAddedToCart() {
        System.out.println("Товары из корзины");
        return getProductsWebElementsFromPage().stream().map(this::productParserOnProductsPage).toList();
    }

    public Product productParserOnProductsPage(WebElement element) {
        int id = Integer.parseInt(element.getAttribute("id").replace("product-", "").trim());
        String name = element.findElement(By.xpath("./td[@class='cart_description']/h4/a")).getText();
        int price = Integer.parseInt(element.findElement(By.xpath("./td[@class='cart_total']/p[@class='cart_total_price']")).getText().replace("Rs. ", "").trim());
        int quantity = Integer.parseInt(element.findElement(By.xpath("./td[@class='cart_quantity']/button")).getText());
        return new Product(getDriver(), id, name, price, quantity);

    }


}
