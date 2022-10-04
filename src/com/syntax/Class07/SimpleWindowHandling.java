package com.syntax.Class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;


//click on Help link
//switch between tabs
//
public class SimpleWindowHandling {
    public static String url = "http://accounts.google.com/signup";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        String maimPageHandle = driver.getWindowHandle();  // get window handle for the main page
        System.out.println(maimPageHandle);
        WebElement helpLink = driver.findElement(By.linkText("Справка"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles();   // store all the handles in a set
        System.out.println(allWindowHandles.size());

        Iterator<String> it = allWindowHandles.iterator();  // have an iterator through the handles
        maimPageHandle = it.next();         // take the first step and assign the main handle
        String childHandle = it.next();     //take the second step and have a child handle
        System.out.println(childHandle);
        Thread.sleep(2000);
       // driver.switchTo().window(maimPageHandle);

        driver.close();
        driver.switchTo().window(maimPageHandle);
        helpLink.click();

        driver.quit();








    }

}
