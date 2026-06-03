package component;

/*
Класс компонента листинга, который мы можем использовать на любой странице с листингом товаров
 */

import basic.base.BaseComponent;
import component.products.ProductCardComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ProductsListComponent extends BaseComponent {

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    private List<WebElement> productCards;

    public ProductsListComponent(WebDriver driver) {
        super(driver);
    }

    public List<ProductCardComponent> getAllProductsFromProductPage() {
        if (productCards.isEmpty())
            throw new NullPointerException("На странице нет товаров");

        return productCards.stream()
                .map(row -> new ProductCardComponent(driver, row))
                .collect(Collectors.toList());
    }

    public ProductCardComponent getProductCard(int listingNumber) {
        return getAllProductsFromProductPage().get(listingNumber - 1);
    }

    public List<ProductCardComponent> getProductCards(int quantity) {
        List<ProductCardComponent> products = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            products.add(getAllProductsFromProductPage().get(i));
        }
        return products;
    }
}
