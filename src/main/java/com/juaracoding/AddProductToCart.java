package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {
    public static void main(String[] args) {
        String webDriver = "webdriver.chrome.driver";
        String path = "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
        System.setProperty(webDriver,path);

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://shop.demoqa.com/");
        System.out.println("Open Browser, Open URL : https://shop.demoqa.com/");
        driver.manage().window().maximize();
        System.out.println("Memaksimalkan jendela saat ini");
        driver.findElement(By.linkText("Dismiss")).click();
        System.out.println("Click dismiss");
        driver.findElement(By.linkText("My Account")).click();
        System.out.println("Click my account");
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll down");
        driver.findElement(By.id("username")).sendKeys("josepedrofebian");
        System.out.println("Input username");
        driver.findElement(By.id("password")).sendKeys("Password190299$");
        System.out.println("Input password");
        driver.findElement(By.name("login")).click();
        System.out.println("Click Login");
        driver.findElement(By.className("cart-button")).click();
        System.out.println("Click cart");
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll down");
        driver.findElement(By.xpath("//a[contains(text(),'Return to shop')]")).click();
        System.out.println("Click return to shop");
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll down");
        driver.findElement(By.className("noo-product-inner")).click();
        System.out.println("Pilih product");
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll down");
        driver.findElement(By.id("pa_color")).sendKeys("Beige");
        System.out.println("Memilih Color");
        driver.findElement(By.id("pa_size")).sendKeys("Large");
        System.out.println("Memilih Size");
        driver.findElement(By.className("single_add_to_cart_button")).click();
        System.out.println("Click Button Add To Cart");
        String addToCartSuccess = driver.findElement(By.className("woocommerce-message")).getText();
        System.out.println(addToCartSuccess);
        delay();
        System.out.println("Delay 3 detik");
        driver.quit();
        System.out.println("Close Browser");

        System.out.println("Test case add product to cart success");
        if (addToCartSuccess.equalsIgnoreCase("View cart\n" +
                "“Black Cross Back Maxi Dress” has been added to your cart.")){
            System.out.println("status : Pass");
        }else {
            System.out.println("status : Fail");
        }
    }
    public static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
