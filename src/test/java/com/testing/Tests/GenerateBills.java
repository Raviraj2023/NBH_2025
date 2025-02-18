package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Driver.DriverManager;
import com.testing.Pages.PageObjectModel.GenerateBillsPage;
import com.testing.Pages.PageObjectModel.LoginPage;
import org.testng.annotations.Test;

public class GenerateBills extends CommonToTestcases {
    GenerateBillsPage gb;
    LoginPage lg;
    @Test
    public void generateBillsRecurring(){
        lg=new LoginPage(DriverManager.getDriver());
        gb= new GenerateBillsPage(DriverManager.getDriver());
        logger.info("Initializing POM objects...");
        lg=new LoginPage(DriverManager.getDriver());
        gb=new GenerateBillsPage(DriverManager.getDriver());

        lg.loginWithValidCredentials();
        gb.createBills("April","test//","Electricity");


    }
}