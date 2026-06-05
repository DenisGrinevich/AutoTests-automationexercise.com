/*
Класс листенер для логирования прохождения прогона и скриншотов
 */

package basic;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;

@Slf4j
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.info("Запущен тест: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Пройден тест: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.error("Провален тест:  {}", result.getMethod().getMethodName());
        log.error("По причине : {}", result.getThrowable().getMessage());
        takeScreenshot(result);

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        log.warn("Пропущен кейс: {}", result.getMethod().getMethodName());
        log.warn("По причине: {}", result.getThrowable().getMessage());

    }

    public void takeScreenshot(ITestResult result) {

        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        String fileName = String.format("%s_%d.png", result.getName(), System.currentTimeMillis());

        if (driver == null) {
            log.warn("️Драйвер равен нулю, скриншот не сделан");
            return;
        }
        try {

            String screenshotPath = String.format("target/screenshots/%s", fileName);

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(screenshotPath));

            log.error("Скриншот сохранён: {}", screenshotPath);
            log.error("URL в момент падения: {}", driver.getCurrentUrl());

            Allure.addAttachment(fileName, new FileInputStream(screenshotPath));

        } catch (Exception e) {
            log.error("Скриншот не сделан: {}", e.getMessage(), e);
        }
    }
}

