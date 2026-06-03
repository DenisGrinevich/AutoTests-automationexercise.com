/*
Класс для тестов, связанных со страницей конкретного товара
 */

package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsPageTest extends BaseTest {

    private static final String REVIEW_NAME = "jack";
    private static final String REVIEW_EMAIL = "jack@test.com";
    private static final String REVIEW_Text = "good";

    @Test
    public void testAddReview(){

        Boolean review = Navigate.toProductsPage(getDriver())
                .getProductList()
                .getProductCard(1)
                .clickOnViewProductButton()
                .enterReviewName(REVIEW_NAME)
                .enterReviewEmail(REVIEW_EMAIL)
                .enterReviewText(REVIEW_Text)
                .clickSubmitReview()
                .isReviewMessageDisplayed();

        Assert.assertTrue(review);
    }
}
