package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandPage;
import pages.CategoryPage;


public class HomePageTest extends BaseTest {
    public static final String URL_MAIN = "https://automationexercise.com/";

    @Test(description = "Open Product Page", groups = {"smoke"})
    public void testViewProductButton() {

        int itemNumber = 5;

        String productURL = Navigate.toHomePage(getDriver())
                .clickOnViewProductButton(itemNumber)
                .getCurrentUrl();

        String expectedUrl = URL_MAIN + "product_details/" + itemNumber;

        Assert.assertEquals(productURL, expectedUrl);
    }

    @Test(description = "Test Case №18: View Category Products")
    public void testCategoryPage() {
        final String FIRST_CATEGORY = "Kids";
        final String FIRST_SUBCATEGORY = "Dress";
        final String SECOND_CATEGORY = "Men";
        final String SECOND_SUBCATEGORY = "Tshirts";

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
        final String FIRST_BRAND= "Polo";
        final String SECOND_BRAND = "Madame";

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


