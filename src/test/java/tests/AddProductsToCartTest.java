package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import component.products.CartProduct;
import component.products.ProductDetailsPageProduct;
import component.products.ProductsPageProduct;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

import java.util.List;

public class AddProductsToCartTest extends BaseTest {

    @Test(description = "№12: Add Products in Cart")
    public void testAddProductsToCart() {
        ProductsPage page = Navigate.toProductsPage(getDriver());
        List<ProductsPageProduct> list = page
                .getHeader()
                .clickProductsButton()
                .addProductToCart(2)
                .getProductsAddedToCart();

        List<CartProduct> cartList = page
                .getHeader()
                .clickCartButton()
                .getAllProductsFromCart();

        Assert.assertTrue(list.equals(cartList));

    }

    @Test(description = "№13: Verify Product quantity in Cart")
    public void testVerifyQuantityInCart(){
        final int QUANTITY=4;

        ProductDetailsPageProduct product = Navigate.toHomePage(getDriver())
                .clickOnViewProductButton(1)
                .setQuantity(QUANTITY)
                .addProductToCart()
                .getProductAddedToCart()
                .get(0);

        CartProduct productInCart = Navigate.toHomePage(getDriver())
                .getHeader()
                .clickCartButton()
                .getAllProductsFromCart()
                .get(0);

        Assert.assertEquals(product.getId(), productInCart.getId());
        Assert.assertEquals(productInCart.getQuantity(), QUANTITY);
    }
}
