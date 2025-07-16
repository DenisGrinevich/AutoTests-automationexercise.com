package tests;

import basic.BaseModel;
import basic.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.main.MainPage;


import static basic.Constants.Urls.URL_MAIN;

public class MainTest extends BaseTest {
    @Test
    public void viewProductButtonTest() throws InterruptedException {
 String productURL = new MainPage(getDriver())
         .clickOnViewProductButton()
         .getCurrentUrl();

        String expectedUrl = URL_MAIN + "product_details/1";
        Assert.assertEquals(productURL, expectedUrl);

    }


//    public void searchTest() throws InterruptedException {
//
//
//        WebDriver driver = getDriver();
//
//        driver.get("https://automationexercise.com/products");
//
//        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_product']"));
//        WebElement searchButton = driver.findElement(By.xpath("//button[@id='submit_search']"));
//
//        searchBox.sendKeys("Dress");
//        searchButton.click();
//
//        String productName = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")).getText();
//        Thread.sleep(1000);
//
//        String searchRequest = "Dress";
//        Assert.assertTrue(productName.trim().toLowerCase().contains(searchRequest.trim().toLowerCase()));
//
//        driver.quit();
//    }
}


