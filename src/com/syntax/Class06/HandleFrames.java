package com.syntax.Class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.id("name"));
        textbox.sendKeys("Vikki");

        driver.switchTo().defaultContent();

        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.switchTo().frame("iframe_a");
        textbox.clear();
        textbox.sendKeys("hello Vikki!");

        driver.switchTo().defaultContent();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));
        driver.switchTo().frame(frameElement);
        textbox.clear();
        textbox.sendKeys("GoodBay");

        //Interview question:
       // How do you handle alerts in selenium?
       // We handle alerts by using Alert interface

        // HW
        //1.Navigate to https://syntaxprojects.com/bootstrap-iframe.php
        //verify the header text "Sorry, We Couldn't Find Anything For "Askan"" is displayed
        //verify enroll today button is enabled

        //HW
        //Go to https://syntaxprojects.com/javascript-alert-box-demo.php
        //click on each button and handle the alert accordingly





    }
}