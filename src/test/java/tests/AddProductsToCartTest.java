package tests;

import basic.BaseTest;
import component.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

import java.util.List;

public class AddProductsToCartTest extends BaseTest {
    @Test
    public void testAddProductsToCart() {
        ProductsPage page = new ProductsPage(getDriver());
        List<Product> list = page
                .getHeader()
                .clickProductsButton()
                .addProductToCart(1)
                .getProductsAddedToCart();

        List<Product> cartList = page
                .getHeader()
                .clickCartButton()
                .getProductsAddedToCart();

        Assert.assertTrue(list.equals(cartList));

    }

    @Test
    public void testVerifyQuantityInCart(){
        final int QUANTITY=4;

        Product product = new HomePage(getDriver())
                .clickOnViewProductButton(1)
                .setQuantity(QUANTITY)
                .addProductToCart()

                .parseProductFromProductPage();

        Product productInCart = new HomePage(getDriver())
                .getHeader()
                .clickCartButton()
                .getProductsAddedToCart()
                .get(0);

        Assert.assertEquals(product.getId(), productInCart.getId());
        Assert.assertEquals(productInCart.getQuantity(), QUANTITY);
    }
}
