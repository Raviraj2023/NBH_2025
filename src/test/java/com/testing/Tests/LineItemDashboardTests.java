package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Pages.PageObjectModel.LineItemDashboardPage;
import com.testing.Pages.PageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LineItemDashboardTests extends CommonToTestcases {
    WebDriver driver;
LineItemDashboardPage lt = new LineItemDashboardPage(driver);
@Test
 public void verify_lineItemDashboard_is_visible(){
    logger.info("Starting test: verify_lineItemDashboard_is_visible");
     try {
         login();
         logger.info("User logged in successfully");
         String title = lt.verifyLineItemDashboardPage();
         logger.info("Retrieved title: " + title);
         Assert.assertEquals(title, "Line Item Dashboard");
         logger.info("Assertion passed: Title matches expected value");

     }
     catch (Exception e) {
         logger.error("Test failed due to an exception: " + e.getMessage(), e);
         Assert.fail("Test failed due to an exception: " + e.getMessage());
     } finally {
         logger.info("Ending test: verify_lineItemDashboard_is_visible");
     }
 }
}
