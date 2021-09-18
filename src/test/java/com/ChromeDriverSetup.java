package com;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class ChromeDriverSetup {

    WebDriver driver;
    WebDriverWait driverWait;
    @Before
    public void beforeCreateWebDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gittigidiyor.com/");
    }

    @After
    public void afterQuitWebDriver(){
        driver.quit();
    }




}
