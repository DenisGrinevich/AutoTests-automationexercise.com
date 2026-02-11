package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.products.BrandPage;
import pages.products.CategoryPage;


public class HomePageTest extends BaseTest {

    private static final String URL_MAIN = "https://automationexercise.com/";
    private static final int itemNumber = 5;
    private static final String FIRST_CATEGORY = "Kids";
    private static final String FIRST_SUBCATEGORY = "Dress";
    private static final String SECOND_CATEGORY = "Men";
    private static final String SECOND_SUBCATEGORY = "Tshirts";
    private static final String FIRST_BRAND= "Polo";
    private static final String SECOND_BRAND = "Madame";


    @Test(description = "Open Product Page", groups = {"smoke"})
    public void testViewProductButton() {

        String productURL = Navigate.toHomePage(getDriver())
                .clickOnViewProductButton(itemNumber)
                .getCurrentUrl();

        String expectedUrl = URL_MAIN + "product_details/" + itemNumber;

        Assert.assertEquals(productURL, expectedUrl);
    }

    @Test(description = "Test Case №18: View Category Products")
    public void testCategoryPage() {

        CategoryPage checkPage = Navigate.toHomePage(getDriver())
                .getSidebar()
                .clickOnCategory(FIRST_CATEGORY)
                .clickOnSubCategory(FIRST_SUBCATEGORY);

        Assert.assertTrue(checkPage.checkCategoryPage(FIRST_CATEGORY, FIRST_SUBCATEGORY));

        checkPage.
                getSidebar().
                clickOnCategory(SECOND_CATEGORY).
                clickOnCategory(SECOND_SUBCATEGORY);

        Assert.assertTrue(checkPage.checkCategoryPage(SECOND_CATEGORY, SECOND_SUBCATEGORY));
    }

    @Test(description = "Test Case №19: View & Cart Brand Products")
    public void testBrandPage(){

        BrandPage brandPage = Navigate.toHomePage(getDriver())
                .getSidebar()
                .clickOnBrand(FIRST_BRAND);

        Assert.assertTrue(brandPage.checkBrandPage(FIRST_BRAND));
        Assert.assertFalse(brandPage.getAllProductsFromProductPage().isEmpty());

        brandPage
                .getSidebar()
                .clickOnBrand(SECOND_BRAND);

        Assert.assertTrue(brandPage.checkBrandPage(SECOND_BRAND));
        Assert.assertFalse(brandPage.getAllProductsFromProductPage().isEmpty());
    }

}


