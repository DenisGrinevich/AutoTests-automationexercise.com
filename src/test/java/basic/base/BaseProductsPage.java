package basic.base;

import basic.tools.Logging;
import component.products.ProductsPageProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseProductsPage<T extends BaseProductsPage> extends BasePage {

    private List<ProductsPageProduct> addedProducts = new ArrayList<>();
    private int PRODUCTS_QUANTITY;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    public BaseProductsPage(WebDriver driver) {
        super(driver);
    }

    protected abstract T self();

    public List<ProductsPageProduct> getAllProductsFromProductPage() {
        List<WebElement> rows = getDriver().findElements(By.xpath(
                "//div[@class='product-image-wrapper']"));
        if (rows.isEmpty())
            throw new NullPointerException("На странице нет товаров");

        return rows.stream()
                .map(row -> new ProductsPageProduct(row, getDriver()))
                .collect(Collectors.toList());
    }

    public T addProductToCart(int x) {
        PRODUCTS_QUANTITY = x;

        for (int i = 0; i <= PRODUCTS_QUANTITY - 1; i++) {
            ProductsPageProduct product = getAllProductsFromProductPage().get(i);
            product.scrollAndHoverToProduct();
            product.clickOnAddToCartButton();
            waitForVisibleElement(continueShoppingButton).click();
            addedProducts.add(product);
            Logging.info("Товар добавлен в корзину");
        }
        return self();
    }

    public List<ProductsPageProduct> getProductsAddedToCart() {
        if (addedProducts.get(0) == null)
            throw new IllegalStateException("Нет товаров на в корзине");

        return addedProducts;
    }

}
