package tests;

import basic.base.BaseTest;
import basic.tools.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    private static final String REVIEW_NAME = "jack";
    private static final String REVIEW_EMAIL = "jack@test.com";
    private static final String REVIEW_Text = "good";

    @Test
    public void testAddReview(){

        Boolean review = Navigate.toProductsPage(getDriver())
                .clickOnViewProductButton(1)
                .enterReviewName(REVIEW_NAME)
                .enterReviewEmail(REVIEW_EMAIL)
                .enterReviewText(REVIEW_Text)
                .clickSubmitReview()
                .isReviewMessageDisplayed();

        Assert.assertTrue(review);

    }
}
