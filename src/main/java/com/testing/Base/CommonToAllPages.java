package com.testing.Base;

import com.testing.Utils.PropertyReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CommonToAllPages {
    WebDriver driver;
    public CommonToAllPages(WebDriver driver) {
    this.driver=driver;
    }

    public Logger logger = LogManager.getLogger(getClass().getSimpleName());

    public void openUrl() {
        driver.get(PropertyReader.readKey("url"));
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public WebElement visiblityOfeElement(By location) {
        return new WebDriverWait(driver, Duration.ofSeconds(7)).
                until(ExpectedConditions.visibilityOfElementLocated(location));
    }

    public List<WebElement> listofElement(By list) {
        return new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(list));
    }
    public WebElement waitUntilElementIsClickable(By elementLocation) {
        return new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(elementLocation));
    }
    public Boolean waitForInvisibility(By elementLocation) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.invisibilityOfElementLocated(elementLocation));
        } catch (Exception e) {
            logger.warn("Element did not become invisible: " + elementLocation, e);
        }
        return null;
    }
}