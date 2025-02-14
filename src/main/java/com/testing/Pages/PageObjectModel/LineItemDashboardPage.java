package com.testing.Pages.PageObjectModel;

import com.testing.Base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LineItemDashboardPage extends CommonToAllPages {

    private By Financial_Management = By.xpath("//div[contains(@class,'nb__DAYS7')]/div[text()='Financial Management']");
    private By Billing = By.xpath("//div[contains(@class,'nb__DAYS7') and text()='Billing']");
    private By Line_item_dashboard = By.xpath("//div[contains(@class,'nb__DAYS7') and text()='Line item dashboard']");
    private By Line_item_dashboard_title = By.xpath("//div[contains(@class,'nb__c7kE9') and text()='Line Item Dashboard']");
    private By Addlineitem = By.xpath("//div[@class='nb__3v4m3']");
    private By Display_Name = By.xpath("//*[@name='request']");
    private By Owner_rate = By.xpath("(//*[@class='form-control'])[2]");
    private By TaxGroup = By.xpath("//div[contains(@class,'css-dvua67') and text()='N/A']");
    private By listTaxgroup = By.xpath("//*[@class='css-11unzgr nb-select__menu-list']");
    private By submitLineitem = By.xpath("//*[@class='nb__uZlDe' and text()='Add Line Item']");
    private By sucess_popup = By.xpath("//div[@id='alertMessageBox']");
    private By Home = By.xpath("//div[@class='nb__mLFkD']");
    private By lineItemSearchField = By.xpath("//input[@placeholder='Search by Line Item Name / Ledger Code ']");
    private By success_popup = By.xpath("//div[@id='alertMessageBox']");
    private By LogoutDropdown = By.xpath("//div[@class='nb__19WIg']");
    private By Logout = By.xpath("//div[@class='nb__mOf0C' and text()='Logout']");
    String itemName;
    private void navigateToLineItemDashboard() {
        visiblityOfeElement(Home);
        logger.info("Navigating to Financial Management");
        clickElement(Financial_Management);
        logger.info("Navigating to Billing");
        clickElement(Billing);
        logger.info("Navigating to Line Item Dashboard");
        clickElement(Line_item_dashboard);
    }

    public String verifyLineItemDashboardPage() {
        navigateToLineItemDashboard();
        return getText(Line_item_dashboard_title);
    }

    public void selectTaxGroup(String tax) {
        List<WebElement> taxGroups = listofElement(listTaxgroup);
        if (taxGroups.isEmpty()) {
            throw new RuntimeException("No tax group options found.");
        }
        boolean found = false;
        try {
            for (WebElement element : taxGroups) {
                if (element.getText().contains(tax)) {
                    element.click();
                    found = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error selecting tax group: " + tax, e);
        }

        if (!found) {
            throw new RuntimeException("Tax group '" + tax + "' not found in the dropdown.");
        }
    }

    public String generateItemName() {
        String prefix = "NBH_";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return prefix + sdf.format(new Date());
    }

    public String verifyCreateLineItem(int ownerRate, String taxGroup) {
        logger.info("Starting Line Item creation...");
        navigateToLineItemDashboard();
        visiblityOfeElement(Line_item_dashboard_title);
        clickElement(Addlineitem);

         itemName = generateItemName();
        logger.info("Generated item name: " + itemName);
        sendKeys(Display_Name, itemName);

        logger.info("Entering owner rate: " + ownerRate);
        sendKeys(Owner_rate, String.valueOf(ownerRate));

        logger.info("Selecting tax group: " + taxGroup);
        clickElement(TaxGroup);
        selectTaxGroup(taxGroup);

        logger.info("Submitting the Line Item");
        clickElement(submitLineitem);
        visiblityOfeElement(sucess_popup);
        String successMessage = getText(sucess_popup);
        logger.info("Success message displayed: " + successMessage);
        visiblityOfeElement(success_popup);
        waitForInvisibility(success_popup);
        clickElement(LogoutDropdown);
        visiblityOfeElement(Logout);
        waitUntilElementIsClickable(Logout);
        clickElement(Logout);
        return successMessage;
    }
    public void verifyLineItemSearch() {
        navigateToLineItemDashboard();
        waitUntilElementIsClickable(lineItemSearchField);
        sendKeys(lineItemSearchField, itemName);
    }
}