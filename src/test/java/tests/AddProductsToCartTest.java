package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import component.products.CartProduct;
import component.products.ProductDetailsPageProduct;
import component.products.ProductsPageProduct;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

import java.util.List;

public class AddProductsToCartTest extends BaseTest {

    @Test(description = "№12: Add Products in Cart")
    public void testAddProductsToCart() {
        ProductsPage page = Navigate.toProductsPage(getDriver());
        List<ProductsPageProduct> list = page
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

    @Test(description = "№17: Remove Products From Cart")
    public void testRemoveProductFromCart(){
        final int productId = 1;
        ProductsPage page = Navigate.toProductsPage(getDriver())
                .addProductToCart(2);

        CartPage cart = Navigate.toCartPage(getDriver());

        Boolean beforeRemoving = cart.isProductInCart(productId);
        Boolean afterRemoving = cart.removeProduct(productId)
                        .isProductInCart(productId);

        Assert.assertTrue(beforeRemoving, "Товара c id " + productId + " отсутствует в корзине");
        Assert.assertFalse(afterRemoving, "Товара c id " + productId + " не удален из корзины");
    }
}
