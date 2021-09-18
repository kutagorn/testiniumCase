package com;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class MainPage {
    WebDriver driver;
    WebDriverWait driverWait;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    public MainPage(WebDriver driver){
        this.driver=driver;
        this.driverWait= new WebDriverWait(driver,15,150);
    }

    //Ana sayfanın açıldığı kontrol edilir.
    public MainPage checkTheMainPageCorrect(String _expectedUrl) throws InterruptedException{
        getCurrentUrlAndCheck(_expectedUrl);
        logger.trace("Anasayfa doğru adresle geldi.");
        return new MainPage(driver);
    }
    //Siteye login olunur- Login Sayfasına Gidilir
    public LoginPage openLoginPage(){
        logger.trace("Login Sayfasına gidilir.");
        mouseHoverWithCss("div[data-cy='header-user-menu']");
        clickButtonByCss("a[data-cy='header-login-button']");
        return new LoginPage(driver);
    }
    //Login işlemi kontrol edilir Hesabim elementini görene kadar bekler
    public MainPage checkTheLogin(){
        //driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='Hesabım']")));
        logger.trace("Login kontrol ediliir.");
        return new MainPage(driver);
    }


    //Urun Aranir
    public SearchPage searchProduct(){
        logger.trace("Urun aranir");
        sendKeysWithCss("input[data-cy='header-search-input']","Bilgisayar");
        clickButtonByCss("button[data-cy='search-find-button']");
        return new SearchPage(driver);
    }


    protected void clickButtonByCss(String param){
        WebElement element = driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(param)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }
    protected void clickButtonById(String param){
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id(param))).click();
    }
    protected void clickButtonByXpath(String param){
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(param))).click();
    }

    protected void sendKeysWithCss(String path,String param){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path))).sendKeys(param);
    }
    protected void sendKeysWithId(String path,String param){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(path))).sendKeys(param);
    }
    protected void sendKeysWithXpath(String path,String param){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path))).sendKeys(param);
    }

    protected void mouseHoverWithCss(String param){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector(param));
        action.moveToElement(we).build().perform();
    }

    protected void getCurrentUrlAndCheck(String _expectedUrl){
        String pageUrl = driver.getCurrentUrl();
        System.out.println("Beklenen url: "+ _expectedUrl);
        System.out.println("Gelen Url: "+ pageUrl);
        Assert.assertEquals("Gelen url adresi beklendigi gibi degil.",pageUrl,_expectedUrl);
    }


}
