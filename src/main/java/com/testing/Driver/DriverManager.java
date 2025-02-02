package com.testing.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }
    public static void initialise(String browserType){

        if(getDriver()==null){
            try{
                if(browserType.equalsIgnoreCase("chrome")){
                     driver=new ChromeDriver();
                } else if (browserType.equalsIgnoreCase("firefox")){
                     driver=new FirefoxDriver();
                }else {
                    throw new IllegalArgumentException("Browser Type not supported: " + browserType);
                }
                driver.manage().window().maximize();
                setDriver(driver);
            } catch (Exception e) {
                System.err.println("Failed to initialize WebDriver: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void quitDriver(){
        if(getDriver()!=null){
            getDriver().quit();
            setDriver(null);
        }
    }
}