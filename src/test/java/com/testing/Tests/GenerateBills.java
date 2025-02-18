package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Pages.PageObjectModel.GenerateBillsPage;
import com.testing.Pages.PageObjectModel.LoginPage;
import org.testng.annotations.Test;

public class GenerateBills extends CommonToTestcases {
    GenerateBillsPage gb;
    LoginPage lg;
    @Test
    public void generateBillsRecurring(){
        logger.info("Initializing POM objects...");
        lg=new LoginPage();
        gb=new GenerateBillsPage();

        lg.loginWithValidCredentials();
        gb.createBills("April","test//","Electricity");


    }
}