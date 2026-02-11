package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import basic.tools.UserFactory;
import component.products.CartProduct;
import component.products.ProductDetailsPageProduct;
import component.products.ProductsPageProduct;
import component.users.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.checkout.CartPage;
import pages.products.ProductsPage;

import java.util.List;

public class AddProductsToCartTest extends BaseTest {

    final User user = UserFactory.defaultUser();

    @Test(description = "№12: Add Products in Cart", groups = {"smoke"})
    public void testAddProductsToCart() {

        final int QUANTITY = 2;

        ProductsPage page = Navigate.toProductsPage(getDriver());
        List<ProductsPageProduct> list = page
                .addProductToCart(QUANTITY)
                .getProductsAddedToCart();

        List<CartProduct> cartList = page
                .getHeader()
                .clickCartButton()
                .getAllProductsFromCart();

        Assert.assertTrue(list.equals(cartList));

    }

    @Test(description = "№13: Verify Product quantity in Cart", groups = {"smoke"})
    public void testVerifyQuantityInCart(){

        final int PRODUCT_NUMBER = 1;
        final int QUANTITY=4;

        ProductDetailsPageProduct product = Navigate.toHomePage(getDriver())
                .clickOnViewProductButton(PRODUCT_NUMBER)
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

    @Test(description = "№17: Remove Products From Cart", groups = {"smoke"})
    public void testRemoveProductFromCart(){

        final int PRODUCT_ID = 1;
        final int QUANTITY=2;

        ProductsPage page = Navigate.toProductsPage(getDriver())
                .addProductToCart(QUANTITY);

        CartPage cart = Navigate.toCartPage(getDriver());

        Boolean beforeRemoving = cart.isProductInCart(PRODUCT_ID);
        Boolean afterRemoving = cart.removeProduct(PRODUCT_ID)
                        .isProductInCart(PRODUCT_ID);

        Assert.assertTrue(beforeRemoving, "Товара c id " + PRODUCT_ID + " отсутствует в корзине");
        Assert.assertFalse(afterRemoving, "Товара c id " + PRODUCT_ID + " не удален из корзины");
    }

    @Test (description = "№20: Search Products and Verify Cart After Login")
    public void testCheckProductsAfterLogin(){

        final String REQUEST = "Red";
        final int QUANTITY=2;

        ProductsPage page = Navigate.toProductsPage(getDriver());

        List<ProductsPageProduct> searchedProducts =
                page
                        .enterSearchRequest(REQUEST)
                        .addProductToCart(QUANTITY)
                        .getProductsAddedToCart();

        List<CartProduct> addedBeforeLoginProducts =
                page
                        .getHeader()
                        .clickCartButton()
                        .getAllProductsFromCart();

        Assert.assertTrue(searchedProducts.equals(addedBeforeLoginProducts));

        List<CartProduct> addedAfterLoginProducts =
                page
                        .getHeader()
                        .clickSignupLoginButton()
                        .login(user.getEmail(),user.getPassword())
                        .getHeader()
                        .clickCartButton()
                        .getAllProductsFromCart();

        Assert.assertTrue(addedBeforeLoginProducts.equals(addedAfterLoginProducts));


    }
}
