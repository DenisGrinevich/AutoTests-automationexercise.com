package tests;

import basic.BaseTest;
import component.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.products.ProductsPage;

import java.util.List;

public class AddToCartTest extends BaseTest {
    @Test
    public void testone() {
        ProductsPage page = new ProductsPage(getDriver());
        List<Product> list = page
                .getHeader()
                .clickProductsButton()
                .addProductToCart(3)
                .getProductsAddedToCart();

        List<Product> cartList = page
                .getHeader()
                .clickCartButton()
                .getProductsAddedToCart();

        Assert.assertTrue(list.equals(cartList));

    }
}
