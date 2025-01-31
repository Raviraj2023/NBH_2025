package com.testing.Pages.PageObjectModel;

import com.testing.Base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class LineitemDashboard extends CommonToAllPages {
    WebDriver driver;

    public LineitemDashboard(WebDriver driver) {
        this.driver = driver;
    }

    private By Financial_Management = By.xpath("//div [contains(@class,'nb__DAYS7')] /div [text()='Financial Management']");
    private By Billing = By.xpath("//div [contains(@class,'nb__DAYS7') and text()='Billing']");
    private By Line_item_dashboard = By.xpath("//div [contains(@class,'nb__DAYS7') and text()='Line item dashboard']");
    private By Line_item_dashboard_text = By.xpath("//div [@class='nb__c7kE9 nb__1feGz']");
    private By Addlineitem = By.xpath("//div[@class='nb__3v4m3']");
    private By Display_Name = By.xpath("//*[@name='request']");
    private By Owner_rate=By.xpath(" (//*[@class='form-control'])[2]");
    private By TaxGroup=By.xpath("(//*[@class='css-1hwfws3 nb-select__value-container nb-select__value-container--has-value'])[3]");
private By listTaxgroup=By.xpath("//div[contains(@id, 'react-select-5-option')]");
private By submitLineitem=By.xpath("//*[@class='nb__uZlDe']");

    public void selectTaxGroup(String Tax){
        List<WebElement> listofElements=listofElement(listTaxgroup);
        for(WebElement element:listofElements){
            if(element.getText().contains(Tax));
            element.click();
        }
    }

    public String Additemname(){
        String SD="NBH";
        Date currentDate=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyy");
        String formattedDate = sdf.format(currentDate);
        return SD+formattedDate;
    }

    public String checkDisplayLineItemDash() {
        String LineItDashTitle = null;
        clickElement(Financial_Management);
        clickElement(Billing);
        clickElement(Line_item_dashboard);
        visiblityOfeElement(Line_item_dashboard_text);
        return LineItDashTitle = getText(Line_item_dashboard_text);
    }

    public void createLineitem(){
        clickElement(Financial_Management);
        clickElement(Billing);
        clickElement(Line_item_dashboard);
        visiblityOfeElement(Line_item_dashboard_text);
        clickElement(Addlineitem);
        sendKeys(Display_Name,Additemname());
        sendKeys(Owner_rate,"2000");
        clickElement(TaxGroup);
//        selectTaxGroup("GST 18%");
        clickElement(submitLineitem);
    }
}
