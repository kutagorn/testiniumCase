package com;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static com.ProductPage.priceAtProductDetail;

public class CartPage extends MainPage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static String  priceAtCart = "";

    public CartPage getProductPriceAtCart()throws InterruptedException{
        Thread.sleep(3000);
        priceAtCart = driver.findElement(By.cssSelector("div[class='total-price']")).getText();
        logger.trace("Urun fiyati alindi");
        return new CartPage(driver);
    }
    public CartPage comparePrices()throws InterruptedException{
        Thread.sleep(3000);
        Assert.assertEquals("Fiyatlar ayni degil",priceAtProductDetail,priceAtCart);
        logger.trace("Fiyatlar karsilastirildi");
        return new CartPage(driver);
    }

    public CartPage increaseProductToTwo()throws InterruptedException{
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.cssSelector("select[class='amount']")));
        select.selectByValue("2");
        logger.trace("Urun adededi arttirildi");
        return new CartPage(driver);
    }
    public CartPage assertAmountAfterIncrease()throws InterruptedException{
        Thread.sleep(3000);
        String amount = driver.findElement(By.cssSelector("select[class='amount']")).getAttribute("value");
        Assert.assertEquals("Urun adeti arttirimi basarisiz oldu",amount,"2");
        logger.trace("Urun adetleri karsilastirildi");
        return new CartPage(driver);
    }

    public CartPage removeProductFromCart()throws InterruptedException{
        Thread.sleep(3000);
        clickButtonByCss(".update-buttons-container .gg-icon");
        logger.trace("Urun sepetten cıkartıldı");
        return new CartPage(driver);
    }




}
