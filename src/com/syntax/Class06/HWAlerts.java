package com.syntax.Class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWAlerts {
    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";
    public static void main(String[] args) throws InterruptedException {
        //HW
        //Go to https://syntaxprojects.com/javascript-alert-box-demo.php
        //click on each button and handle the alert accordingly
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement elem1 = driver.findElement(By.xpath("//button[@class = 'btn btn-default']"));
        elem1.click();

        Thread.sleep(2000);
        Alert alrt1 = driver.switchTo().alert();
        alrt1.accept();

        Thread.sleep(2000);
        WebElement elem2 = driver.findElement(By.xpath("//button[@class = 'btn btn-default btn-lg']"));
        elem2.click();

        Thread.sleep(2000);
        Alert alrt2 = driver.switchTo().alert();
        alrt2.accept();

        Thread.sleep(2000);
        WebElement elem3 = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[3]/div[2]/button"));
        elem3.click();


        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();

        String textAlert =  promptAlert.getText();
        System.out.println(textAlert);
        if(textAlert.equals("Enter name")){
            promptAlert.sendKeys("Victoria");
        }else{
            System.out.println("Nothing");
        }


       // System.out.println(textAlert);
    //    promptAlert.sendKeys("Victoria");
     //   Thread.sleep(3000);
       // promptAlert.accept();

        //driver.close();





    }
}
