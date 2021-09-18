package com;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase extends ChromeDriverSetup {

    //Gittigidiyorda otomasyonla login olurken kabul etmiyor bununla alakalı geliştirme yapmış olabilir
    @Test
    public void testCaseWtihLogin(){
        try {
            new MainPage(driver)
                    .checkTheMainPageCorrect("https://www.gittigidiyor.com/")
                    .openLoginPage()
                    .login("kutaytest@test.com","test123")
                    .checkTheLogin()
                    .searchProduct()
                    .openThePageSecond()
                    .getRandomProduct()
                    .getProductPrice()
                    .addToCart()
                    .goToCart()
                    .getProductPriceAtCart()
                    .comparePrices()
                    .increaseProductToTwo()
                    .assertAmountAfterIncrease()
                    .removeProductFromCart();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testCaseWtihOutLogin(){
        try {
            new MainPage(driver)
                    .checkTheMainPageCorrect("https://www.gittigidiyor.com/")
                    .searchProduct()
                    .openThePageSecond()
                    .getRandomProduct()
                    .getProductPrice()
                    .addToCart()
                    .goToCart()
                    .getProductPriceAtCart()
                    .comparePrices()
                    .increaseProductToTwo()
                    .assertAmountAfterIncrease()
                    .removeProductFromCart();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
