/*
Класс для тестов, связанных с добавлением товара в корзину
 */

package tests;

import basic.base.BaseTest;
import basic.model.Product;
import basic.model.User;
import basic.tools.Navigate;
import basic.tools.UserFactory;
import component.ProductsListComponent;
import component.products.CartProductComponent;
import component.products.ProductCardComponent;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.checkout.CartPage;
import pages.products.ProductsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddProductsToCartTest extends BaseTest {

    final User user = UserFactory.defaultUser();

    @Test(description = "№12: Add Products in Cart", groups = {"smoke"})
    public void testAddProductsToCart() {

        final int QUANTITY = 2;

        ProductsPage page = Navigate.toProductsPage(getDriver());
        List<Product> list = page
                .getProductList()
                .getProductCards(QUANTITY)
                .stream()
                .map(ProductCardComponent::addProductsToCart)
                .map(ProductCardComponent::parseData).toList();

        List<Product> cartList = page
                .getHeader()
                .clickCartButton()
                .getAllProductsFromCart()
                .stream().map(CartProductComponent::parseData).toList();

        Assert.assertTrue(list.equals(cartList), String.format("Товары не равны! Ожидалось: %s, Получено: %s", list, cartList));
    }

    @Test(description = "№13: Verify Product quantity in Cart", groups = {"smoke"})
    public void testVerifyQuantityInCart() {

        final int PRODUCT_NUMBER = 1;
        final int QUANTITY = 4;

        Product product = Navigate.toHomePage(getDriver())
                .getProductList()
                .getProductCard(PRODUCT_NUMBER)
                .clickOnViewProductButton()
                .setQuantity(QUANTITY)
                .addProductToCart()
                .parseData();

        CartProductComponent productInCart = Navigate.toHomePage(getDriver())
                .getHeader()
                .clickCartButton()
                .getAllProductsFromCart()
                .get(0);


        Assert.assertEquals(product.getId(), productInCart.parseData().getId(), String.format("Товары разные! Ожидался id: %d, фактический: %d", product.getId(), productInCart.parseData().getId()));
        Assert.assertEquals(productInCart.getQuantity(), QUANTITY, String.format("Количество товара отличается! Ожидалось: %d, Получено: %d", productInCart.getQuantity(), QUANTITY));
    }

    @Test(description = "№17: Remove Products From Cart", groups = {"smoke"})
    public void testRemoveProductFromCart() {

        final int PRODUCT_ID = 1;
        final int QUANTITY = 2;

        List<ProductCardComponent> addedProducts = Navigate.toProductsPage(getDriver())
                .getProductList()
                .getProductCards(QUANTITY)
                .stream().map(ProductCardComponent::addProductsToCart).toList();

        CartPage cart = Navigate.toCartPage(getDriver());

        Boolean beforeRemoving = cart.isProductInCart(PRODUCT_ID);
        Boolean afterRemoving = cart.removeProduct(PRODUCT_ID)
                .isProductInCart(PRODUCT_ID);

        Assert.assertTrue(beforeRemoving, "Товара c id " + PRODUCT_ID + " отсутствует в корзине");
        Assert.assertFalse(afterRemoving, "Товара c id " + PRODUCT_ID + " не удален из корзины");
    }

    @Test(description = "№20: Search Products and Verify Cart After Login")
    public void testCheckProductsAfterLogin() {

        final String REQUEST = "Red";
        final int QUANTITY = 2;

        ProductsPage page = Navigate.toProductsPage(getDriver());

        List<Product> searchedProducts =
                page
                        .enterSearchRequest(REQUEST)
                        .getProductList()
                        .getProductCards(QUANTITY)
                        .stream()
                        .map(ProductCardComponent::addProductsToCart)
                        .map(ProductCardComponent::parseData).toList();

        List<Product> addedBeforeLoginProducts =
                page
                        .getHeader()
                        .clickCartButton()
                        .getAllProductsFromCart()
                        .stream().map(CartProductComponent::parseData).toList();

        Assert.assertTrue(searchedProducts.equals(addedBeforeLoginProducts));

        List<Product> addedAfterLoginProducts =
                page
                        .getHeader()
                        .clickSignupLoginButton()
                        .login(user)
                        .getHeader()
                        .checkUserLogin(user)
                        .clickCartButton()
                        .getAllProductsFromCart()
                        .stream().map(CartProductComponent::parseData).toList();

        Assert.assertTrue(addedBeforeLoginProducts.equals(addedAfterLoginProducts), String.format("Товары не равны! Ожидалось: %s, Получено: %s", addedBeforeLoginProducts, addedAfterLoginProducts));

    }
}
