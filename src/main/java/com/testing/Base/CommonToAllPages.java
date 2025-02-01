package com.testing.Base;

import com.testing.Utils.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.testing.Driver.DriverManager.getDriver;

public class CommonToAllPages {

    public CommonToAllPages() {
    }

    public Logger logger = Logger.getLogger(getClass().getSimpleName());

    public void openUrl() {
        getDriver().get(PropertyReader.readKey("url"));
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void sendKeys(By by, String value) {
        getDriver().findElement(by).sendKeys(value);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public WebElement visiblityOfeElement(By location) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(7)).
                until(ExpectedConditions.visibilityOfElementLocated(location));
    }

    public List<WebElement> listofElement(By list) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(list));
    }
}
