package com.testing.Base;

import com.testing.Driver.DriverManager;
import com.testing.Pages.PageObjectModel.LoginPage;
import com.testing.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.apache.log4j.*;

import static com.testing.Driver.DriverManager.driver;

public class CommonToTestcases {
    protected static  LoginPage lg = new LoginPage(driver);
    @BeforeTest
    public void setup(){
        DriverManager.initialise(PropertyReader.readKey("browser"));
    }

    @AfterTest
    public void teardown(){
        DriverManager.quitDriver();
    }

    public Logger logger=Logger.getLogger(getClass().getSimpleName());
}