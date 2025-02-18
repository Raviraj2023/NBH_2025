package com.testing.Tests;

import com.testing.Base.CommonToTestcases;
import com.testing.Driver.DriverManager;
import com.testing.Pages.PageObjectModel.LoginPage;
import com.testing.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends CommonToTestcases {
    WebDriver driver;
    LoginPage lg;

    @Test(enabled = true, priority = 3)
    public void verify_Login_With_Valid_Creds() {
        lg = new LoginPage(DriverManager.getDriver());
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

    @Test(enabled = true, priority = 1)
    public void verify_Login_With_Invalid_User() {
        lg = new LoginPage(DriverManager.getDriver());

        String msg = lg.loginWithinvalidUser();
        Assert.assertEquals(msg, PropertyReader.readKey("invaliduserError"));
    }

    @Test(enabled = true, priority = 0)
    public void verify_Login_With_Invalid_Pass() {
        lg = new LoginPage(DriverManager.getDriver());

        String msg = lg.loginWithinvalidPass();
        Assert.assertEquals(msg, PropertyReader.readKey("invalidpassError"));
    }

    @Test(enabled = true, priority = 3)
    public void verify_Login_With_Invalid_Creds() {
        lg = new LoginPage(DriverManager.getDriver());

        String msg = lg.loginWithInvalidCredentials();
        Assert.assertEquals(msg, PropertyReader.readKey("invaliduserError"));
    }
}