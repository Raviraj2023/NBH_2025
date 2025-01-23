package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Pages.PageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends CommonToTestcases {
    WebDriver driver;
    LoginPage lg = new LoginPage(driver);
    @Test
    public void verify_loginWithValidCreds(){
       String msg= lg.loginWithValidCredentials();
        Assert.assertEquals(msg,"Home");
    }
}
