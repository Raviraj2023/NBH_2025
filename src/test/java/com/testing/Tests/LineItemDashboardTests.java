package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Pages.PageObjectModel.LineItemDashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LineItemDashboardTests extends CommonToTestcases {
    LineItemDashboardPage line = new LineItemDashboardPage();

    @Test

    public void verify_Line_Item_Dashboard() {
        lg.loginWithValidCredentials();
        String title = line.verifyLineItemDashboardPage();
        Assert.assertEquals(title, "Line Item Dashboard");
    }

    @Test
    public void verify_Add_Line_Item() {
        lg.loginWithValidCredentials();

        String msg = line.verifyCreateLineItem(2000, "GST 18%");
        Assert.assertEquals(msg, "Line-item created successfully");

    }

    @Test(dependsOnMethods = "verify_Add_Line_Item")
    public void verify_Line_Item_Search() {
        logger.info("Initializing POM objects...");

        lg.loginWithValidCredentials();
        line.verifyLineItemSearch();
    }
}