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
    private  By HomePage=By.xpath("//a[@title='Home']");

    public String loginWithValidCredentials(){
        openUrl();
        clickElement(SocietyLoginButton);
        sendKeys(EmailField, PropertyReader.readKey("validEmail"));
        sendKeys(PassWordField, PropertyReader.readKey("validPass"));
        clickElement(LoginButton);
        visiblityOfeElement(HomePage);
        return getText(HomePage);
    }

    public String loginWithinvalidUser(){
        openUrl();
        clickElement(SocietyLoginButton);
        sendKeys(EmailField, PropertyReader.readKey("invalidEmail"));
        sendKeys(PassWordField,PropertyReader.readKey("validPass"));
        clickElement(LoginButton);
        visiblityOfeElement(ErrorMessage);
        return getText(ErrorMessage);
    }

    public String loginWithinvalidPass(){
        openUrl();
        clickElement(SocietyLoginButton);
        sendKeys(EmailField, PropertyReader.readKey("validEmail"));
        sendKeys(PassWordField, PropertyReader.readKey("invalidPass"));
        clickElement(LoginButton);
        visiblityOfeElement(ErrorMessage);
        return getText(ErrorMessage);
    }

    public String loginWithInvalidCredentials(){
        openUrl();
        clickElement(SocietyLoginButton);
        sendKeys(EmailField, PropertyReader.readKey("invalidEmail"));
        sendKeys(PassWordField, PropertyReader.readKey("invalidPass"));
        clickElement(LoginButton);
        visiblityOfeElement(ErrorMessage);
        return getText(ErrorMessage);
    }

}
