package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTanpaPassword {
    public static void main(String[] args) {

        String webDriver = "webdriver.chrome.driver";
        String path = "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
        System.setProperty(webDriver, path);

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
        driver.findElement(By.id("password")).sendKeys("Password190299$");
        System.out.println("Input password");
        driver.findElement(By.name("login")).click();
        System.out.println("Click Login");
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll down");
        String messageError = driver.findElement(By.className("woocommerce-notices-wrapper")).getText();
        System.out.println(messageError);
        delay();
        System.out.println("Delay 3 detik");
        driver.quit();
        System.out.println("Close Browser");

        System.out.println("Test case login without input password");
        if (messageError.equalsIgnoreCase("Error: Username is required.")) {
            System.out.println("status : Pass");
        } else {
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


