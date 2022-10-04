package com.syntax.Class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearCommandDemo {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testComplete11/WebOrders/Login.aspx");

        WebElement username = driver.findElement(By.xpath("//input[contains(@id, 'username')]"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[contains(@id, 'password')]"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.className("button"));
        Thread.sleep(2000);
        username.clear();
        password.clear();
        driver.quit();




    }
}
