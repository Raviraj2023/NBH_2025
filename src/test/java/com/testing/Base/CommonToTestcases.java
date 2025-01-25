package com.testing.Base;

import com.testing.Driver.DriverManager;
import com.testing.Utils.PropertyReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.apache.log4j.*;

public class CommonToTestcases {
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
