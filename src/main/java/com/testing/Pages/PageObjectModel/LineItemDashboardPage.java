package com.testing.Pages.PageObjectModel;

import com.testing.Base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LineItemDashboardPage extends CommonToAllPages {
    WebDriver driver;

    public LineItemDashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    private By Financial_Management = By.xpath("//div[contains(@class,'nb__DAYS7')]/div[text()='Financial Management']");
    private By Billing = By.xpath("//div[contains(@class,'nb__DAYS7') and text()='Billing']");
    private By Line_item_dashboard = By.xpath("//div[contains(@class,'nb__DAYS7') and text()='Line item dashboard']");
    private By Line_item_dashboard_title = By.xpath("//div[contains(@class,'nb__c7kE9') and text()='Line Item Dashboard']");

    public String verifyLineItemDashboardPage() {
        logger.info("Starting verification of Line Item Dashboard Page");

        try {
            logger.info("Clicking on Financial Management menu");
            clickElement(Financial_Management);
            logger.info("Clicked on Financial Management menu");
            logger.info("Clicking on Billing menu");
            clickElement(Billing);
            logger.info("Clicked on Billing menu");
            logger.info("Clicking on Line Item Dashboard");
            clickElement(Line_item_dashboard);
            logger.info("Clicked on Line Item Dashboard");
        } catch (Exception e) {
            logger.error("Error while navigating to Line Item Dashboard: " + e.getMessage(), e);
        }
        logger.info("waiting for Line_item_dashboard_title to be visible ");
        try {
            visiblityOfeElement(Line_item_dashboard_title);
        } catch (TimeoutException e) {
            logger.error("Timeout while waiting for an element: " + e.getMessage(), e);
        }
        String title = getText(Line_item_dashboard_title);
        logger.info("Retrieved Line Item Dashboard title: " + title);
        return title;
    }
}
