package com.syntax.Class11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RightAndDoubleClickActions {
    public static String url = "http://demo.guru99.com/test/simple_context_menu.html";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement rightButton = driver.findElement(By.xpath("//span[text() = 'right click me']"));
        Actions action = new Actions(driver);
        action.contextClick(rightButton).perform();

        WebElement editOption = driver.findElement(By.xpath("//span[text() = 'Edit']"));
        //editOption.click();
        action.click(editOption).perform();
        //Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement doubleClickOption = driver.findElement(By.xpath("//button[text() = 'Double-Click Me To See Alert']"));
        action.doubleClick(doubleClickOption).perform();
        System.out.println(alert.getText());
        alert.accept();









    }
}
