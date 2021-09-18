package com;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends MainPage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static String  priceAtProductDetail = "";

    public ProductPage getProductPrice() throws InterruptedException {
        Thread.sleep(3000);
        priceAtProductDetail = driver.findElement(By.cssSelector(".individual-installment-table .bank-info-con-bonus tr:nth-of-type(2) > td:nth-of-type(3)")).getText();
        return new ProductPage(driver);
    }

    public ProductPage addToCart() throws InterruptedException {
        Thread.sleep(3000);
        clickButtonByCss("button[id='add-to-basket']");
        Thread.sleep(3000);
        return new  ProductPage(driver);
    }
    public CartPage goToCart() throws InterruptedException {
        clickButtonByCss("span[class='basket-title']");
        return new  CartPage(driver);
    }


}
