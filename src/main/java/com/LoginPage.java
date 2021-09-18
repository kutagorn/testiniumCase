package com;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends MainPage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    private Logger logger = LoggerFactory.getLogger(getClass());
    public MainPage login(String _userName,String _password) throws InterruptedException{
        sendKeysWithId("L-UserNameField",_userName);
        Thread.sleep(1000);
        sendKeysWithId("L-PasswordField",_password);
        Thread.sleep(1000);
        clickButtonByCss("input[id='gg-login-enter']");

        System.out.println(_userName+ "  ve "+_password+" ile login olundu.");

        logger.trace("Basarili Login olundu.");
        driver.navigate().to("https://www.gittigidiyor.com");
        return new MainPage(driver);
    }



}
