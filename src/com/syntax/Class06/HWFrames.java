package com.syntax.Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWFrames {

    public static String url = "https://syntaxprojects.com/bootstrap-iframe.php";
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().window().maximize();

        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.xpath("//h1[contains(@class, 'heading-13')]"));

        String str = text.getText();
        //System.out.println(str);

        if(str.equals("Sorry, We Couldn't Find Anything For “Asksn”")){
            System.out.println("This header is correct");
        }else{
            System.out.println("This header is not correct");
        }

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);

        WebElement textButton = driver.findElement(By.xpath("(//div[@class= 'text-block-2'])[1]"));
        textButton.click();

        WebElement displayText = driver.findElement(By.xpath("//h1[@class = 'heading-33']"));
        String textVisible = displayText.getText();
        if(textVisible.equals("Let's get started!")){
            System.out.println("Enroll Button is working");
        }else {
            System.out.println("It Button don't work");
        }







        //iframe[@name='FrameOne']
        // HW
        //1.Navigate to https://syntaxprojects.com/bootstrap-iframe.php
        //verify the header text "Sorry, We Couldn't Find Anything For "Askan"" is displayed
        //verify enroll today button is enabled
    }
}
