package com;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class SearchPage extends MainPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    private Logger logger = LoggerFactory.getLogger(getClass());

    public SearchPage openThePageSecond()throws InterruptedException{
        Thread.sleep(3000);
        clickButtonByCss("a[title='2. sayfa']");
        return new SearchPage(driver);
    }

    public ProductPage getRandomProduct() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> items = driver.findElements(By.cssSelector("a[type='hover']"));
        Random rnd = new Random(items.size());
        int randomValue = rnd.nextInt(items.size());
        items.get(randomValue).click();

        return new ProductPage(driver);
    }




}
