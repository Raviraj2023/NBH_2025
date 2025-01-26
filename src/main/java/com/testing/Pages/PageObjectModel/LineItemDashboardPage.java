package com.testing.Pages.PageObjectModel;

import com.testing.Base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LineItemDashboardPage extends CommonToAllPages {
    WebDriver driver;

   public LineItemDashboardPage(WebDriver driver){
        this.driver=driver;
    }

    private By Financial_Management=By.xpath("//div[contains(@class,'nb__DAYS7')]/div[text()='Financial Management']");
   private By Billing=By.xpath("//div[contains(@class,'nb__DAYS7') and text()='Billing']");
   private By Line_item_dashboard=By.xpath("//div[contains(@class,'nb__DAYS7') and text()='Line item dashboard']");
   private By Line_item_dashboard_title=By.xpath("//div[contains(@class,'nb__c7kE9') and text()='Line Item Dashboard']");


   public String verifyLineItemDashboardPage(){
       System.out.println("hello ravi");
       clickElement(Financial_Management);
       clickElement(Billing);
       clickElement(Line_item_dashboard);
       return getText(Line_item_dashboard_title);

   }
}
