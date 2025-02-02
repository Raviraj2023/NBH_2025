package com.testing.Pages.PageObjectModel;

import com.testing.Base.CommonToAllPages;
import com.testing.Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends CommonToAllPages {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By SocietyLoginButton = By.xpath("//div[@class='nb__GGkUH']");
    private By EmailField = By.xpath("//input[@placeholder='Email']");
    private By PassWordField = By.xpath("//input[@placeholder='Password']");
    private By LoginButton = By.xpath("//div[@class='nb__1Zwxx']");
    private By ErrorMessage = By.id("alertMessageBox");
    private By HomePage = By.xpath("//a[@title='Home']");

    public String loginWithValidCredentials() {
        String homePageText = null;

        try {
            openUrl();
            logger.info("Opened URL successfully.");
            clickElement(SocietyLoginButton);
            logger.info("Clicked on Society Login Button.");

            String validEmail = PropertyReader.readKey("validEmail");
            String validPass = PropertyReader.readKey("validPass");

            if (validEmail == null || validPass == null) {
                logger.info("Email or Password is not configured Properly");
                logger.info("Error: Invalid credential configured");
            }
            sendKeys(EmailField, validEmail);
            logger.info("Entered valid email.");
            sendKeys(PassWordField, validPass);
            logger.info("Entered valid password.");
            clickElement(LoginButton);
            logger.info("Clicked on Login Button.");
            try {
                visiblityOfeElement(HomePage);
                logger.info("Home Page is visible.");
            } catch (Exception e) {
                logger.error("Home page not visible" + e.getMessage(), e);
            }
            homePageText = getText(HomePage);
            logger.info("Retrieved text from Home Page: " + homePageText);
        } catch (Exception e) {
            logger.error("An error occurred during login: " + e.getMessage(), e);
        }
        return homePageText;
    }

    public String loginWithinvalidUser() {
        openUrl();
        clickElement(SocietyLoginButton);
        sendKeys(EmailField, PropertyReader.readKey("invalidEmail"));
        sendKeys(PassWordField, PropertyReader.readKey("validPass"));
        clickElement(LoginButton);
        visiblityOfeElement(ErrorMessage);
        return getText(ErrorMessage);
    }

    public String loginWithinvalidPass() {
        openUrl();
        clickElement(SocietyLoginButton);
        sendKeys(EmailField, PropertyReader.readKey("validEmail"));
        sendKeys(PassWordField, PropertyReader.readKey("invalidPass"));
        clickElement(LoginButton);
        visiblityOfeElement(ErrorMessage);
        return getText(ErrorMessage);
    }

    public String loginWithInvalidCredentials() {
        openUrl();
        clickElement(SocietyLoginButton);
        sendKeys(EmailField, PropertyReader.readKey("invalidEmail"));
        sendKeys(PassWordField, PropertyReader.readKey("invalidPass"));
        clickElement(LoginButton);
        visiblityOfeElement(ErrorMessage);
        return getText(ErrorMessage);
    }

}