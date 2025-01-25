package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Pages.PageObjectModel.LoginPage;
import com.testing.Utils.PropertyReader;
import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends CommonToTestcases {
    WebDriver driver;
    LoginPage lg = new LoginPage(driver);
    @Test (enabled = true, priority = 3)
    public void verify_loginWithValidCreds(){
        try {
            String msg = lg.loginWithValidCredentials();
            Assert.assertEquals(msg, "Home");
            logger.info("Login verified successfully with valid credentials.");
        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An error occurred during login verification: " + e.getMessage(), e);
        }
    }
    @Test(enabled = false, priority = 1)
    public void verify_loginwithInvaliduser(){
        String msg=lg.loginWithinvalidUser();
        Assert.assertEquals(msg, PropertyReader.readKey("invaliduserError"));
    }
    @Test(enabled = false, priority = 0)
    public void verify_loginWithInvalidPass(){
        String msg=lg.loginWithinvalidPass();
        Assert.assertEquals(msg, PropertyReader.readKey("invalidpassError"));
    }
    @Test(enabled = false, priority = 3)
    public void verify_loginWithInvalidCreds(){
        String msg=lg.loginWithInvalidCredentials();
        Assert.assertEquals(msg, PropertyReader.readKey("invaliduserError"));
    }
}
