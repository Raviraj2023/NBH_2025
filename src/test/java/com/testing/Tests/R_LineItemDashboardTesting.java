package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Pages.PageObjectModel.LineitemDashboard;
import com.testing.Pages.PageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class R_LineItemDashboardTesting extends CommonToTestcases {

    WebDriver driver;
 LoginPage lg=new LoginPage(driver);
 LineitemDashboard line=new LineitemDashboard(driver);

 @Test
    public void checkLineItemDashboardTitle(){
     lg.loginWithValidCredentials();
     line.checkDisplayLineItemDash();
//     System.out.print(line.checkDisplayLineItemDash());
     logger.info("case success");
 }
@Test
    public void AddLineItem(){
     lg.loginWithValidCredentials();
     line.createLineitem();
}
}
