package com.testing.Pages.PageObjectModel;

import com.testing.Base.CommonToAllPages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class GenerateBillsPage extends CommonToAllPages {
    private WebDriver driver;

    // Locators
    private final By outside = By.xpath("//div[@class='nb__1IRDo']");
    private final By Home = By.xpath("//div[@class='nb__mLFkD']");
    private final By FinancialManagement = By.xpath("//div[text()='Financial Management']");
    private final By Billing = By.xpath("//div[contains(@class, 'nb__DAYS7') and text()='Billing']");
    private final By GenerateBillsPage = By.xpath("//div[contains(@class, 'nb__DAYS7') and text()='Generate Bills']");
    private final By InvoiceName = By.xpath("//input[@placeholder='Enter Invoice Name ( Max 40 characters allowed )']");
    private final By PeriodDrpDown = By.xpath("//div[contains(text(),'Select Period')]");
    private final By DRPDWNLIST = By.xpath("//div[contains(@class,'css-11unzgr')]");
    private final By SelectSeries = By.xpath("//div[contains(text(),'Select Invoice Series')]");
    private final By CreateSeries = By.xpath("//div[text()='Test// (###) ']");
    private final By LineItemDrpDwn = By.xpath("//div[contains(@class,'nb-select__placeholder') and text()='Select lineItem']");

    public GenerateBillsPage(WebDriver driver) {

        super(driver);
        this.driver=driver;
    }

    private void navigateToGenerateBillsPage() {
        try {
            visiblityOfeElement(Home);
            logger.info("Navigating to Financial Management...");
            clickWhenClickable(FinancialManagement);

            logger.info("Navigating to Billing...");
            clickWhenClickable(Billing);

            logger.info("Navigating to Generate Bills Page...");
            clickWhenClickable(GenerateBillsPage);
        } catch (Exception e) {
            logger.error("Error navigating to Generate Bills Page", e);
        }
    }

    private String generateInvoiceName() {
        try {
            String prefix = "NBH_INV_";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String invoiceName = prefix + sdf.format(new Date());
            logger.info("Generated Invoice Name: " + invoiceName);
            return invoiceName;
        } catch (Exception e) {
            logger.error("Error generating invoice name", e);
            return "NBH_ERROR";
        }
    }

    private void selectPeriod(String period, By PeriodList) {
        try {
            visiblityOfeElement(PeriodList);
            List<WebElement> elements = listofElement(PeriodList);

            if (elements == null || elements.isEmpty()) {
                logger.warn("No periods available in the dropdown.");
                return;
            }

            for (WebElement element : elements) {
                if (element.getText().contains(period)) {
                    logger.info("Selecting period: " + period);
                    Thread.sleep(2000);
                    By periodButton = By.xpath("//div[contains(text(),'" + period + "')]");
                    clickWhenClickable(periodButton);
                    return;
                }
            }
            logger.warn("Specified period '" + period + "' not found.");
        } catch (NoSuchElementException e) {
            logger.error("Period dropdown not found.", e);
        } catch (TimeoutException e) {
            logger.error("Timeout while selecting period.", e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void scrollToBottomUsingActions() {
        try {
            new Actions(driver).sendKeys(Keys.CONTROL, Keys.END).perform();
            logger.info("Scrolled to the bottom using Actions class.");
        } catch (Exception e) {
            logger.error("Error while scrolling with Actions", e);
        }
    }

    private void clickWhenClickable(By locator) {
        try {
            waitUntilElementIsClickable(locator);
            driver.findElement(locator).click();
            logger.info("Clicked on element: " + locator);
        } catch (ElementClickInterceptedException e) {
            logger.warn("Click intercepted. Using JavaScript click as fallback.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
        } catch (TimeoutException e) {
            logger.error("Timeout waiting for element to be clickable: " + locator, e);
        }
    }

    public void createBills(String period, String billSeries, String lineItemName) {
        try {
            navigateToGenerateBillsPage();
            sendKeys(InvoiceName, generateInvoiceName());
            clickElement(outside);

            waitUntilElementIsClickable(PeriodDrpDown);
            clickElement(PeriodDrpDown);
            selectPeriod(period, DRPDWNLIST);

            clickElement(SelectSeries);
            // clickElement(CreateSeries);
            selectPeriod(billSeries,DRPDWNLIST);

            scrollToBottomUsingActions();
            clickWhenClickable(LineItemDrpDwn);
            selectPeriod(lineItemName, DRPDWNLIST);
        } catch (Exception e) {
            logger.error("Error while creating bills", e);
        }
    }
}