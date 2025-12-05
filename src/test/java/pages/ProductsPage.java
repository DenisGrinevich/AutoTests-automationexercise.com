package pages;

import basic.base.BasePage;
import basic.tools.Logging;
import component.products.ProductsPageProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = ("/product");
    private int PRODUCTS_QUANTITY;
    private List<ProductsPageProduct> addedProducts = new ArrayList<>();

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;




    public ProductsPage enterProductName(String searchRequest) {
        waitForVisibleElement(searchBox)
                .sendKeys(searchRequest.trim().toLowerCase());
        searchButton.click();
        return this;
    }

    public ProductsPage checkAllProductsPage() {
        try {
            getWait().until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//h2[@class='title text-center'][contains(text(),'All Products')]"))).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new NullPointerException("Элемент не найден");
        }
    }

    public ProductsPage checkSearchResultPage() {

        if (!waitForVisibleElement(By.xpath("//h2[@class='title text-center'][contains(text(),'Searched Products')]")).isDisplayed())
            throw new AssertionError("Текст \"Searched Products\" не найден");

        return this;
    }


    public boolean checkSearchRequestInProductName(String request) {
        List<String> text = getDriver().findElements(By.xpath("//div[@class='productinfo text-center']/p"))
                .stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .toList();

        if (text.stream().allMatch(name -> name.contains(request.toLowerCase()))) {
            return true;
        } else {
            return false;
        }
    }


    public List<ProductsPageProduct> getAllProductsFromProductPage(){
        List<WebElement> rows = getDriver().findElements(By.xpath(
                "//div[@class='product-image-wrapper']"));
        if (rows.isEmpty())
            throw new NullPointerException("На странице нет товаров");

        return rows.stream()
                .map(row -> new ProductsPageProduct(row, getDriver()))
                .collect(Collectors.toList());

    }

//    public List<WebElement> getAllProductsWebElementsFromProductsPage() {
//        if (productCards.isEmpty())
//            throw new IllegalStateException("В корзине нет товаров");
//
//        return productCards;
//    }
//
//    private List<WebElement> getProductsWebElementsFromProductsPage() {
//        List<WebElement> list = new ArrayList<>();
//        for (int i = 0; i <= PRODUCTS_QUANTITY - 1; i++) {
//            list.add(i, getAllProductsWebElementsFromProductsPage().get(i));
//        }
//        return list;
//    }

    public ProductsPage addProductToCart(int x) {
        PRODUCTS_QUANTITY = x;

        for (int i = 0; i <= PRODUCTS_QUANTITY - 1; i++) {
            ProductsPageProduct product = getAllProductsFromProductPage().get(i);
            product.scrollAndHoverToProduct();
            product.clickOnAddToCartButton();
            waitForVisibleElement(continueShoppingButton).click();
            addedProducts.add(product);
            Logging.info("Товар добавлен в корзину");
        }
        return this;
    }

    public List<ProductsPageProduct> getProductsAddedToCart() {
        if (addedProducts.get(0) == null)
            throw new IllegalStateException("Нет товаров на в корзине");

        return addedProducts;
    }
//
//    public Product parseProductFromProductsPage(WebElement element) {
//        int id = Integer.parseInt(element.findElement(By.xpath(".//div[@class='productinfo text-center']/a[contains(@class, 'add-to-cart')]")).getAttribute("data-product-id"));
//        String name = element.findElement(By.xpath(".//div[@class='productinfo text-center']/p")).getText();
//        int price = Integer.parseInt(element.findElement(By.xpath(".//div[@class='productinfo text-center']/h2")).getText().replace("Rs. ", "").trim());
//        return new Product(getDriver(), id, name, price);
//    }

    public ProductsPageProduct getProduct(int i) {
        return getProductsAddedToCart().get(i);
    }
}
