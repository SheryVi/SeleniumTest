package com.syntax.Class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HWExplicitWait {
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        //установите флажок и нажмите удалить

        WebElement checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
        checkBox.click();

        WebElement removeButton = driver.findElement(By.xpath("//button[text() = 'Remove']"));
        removeButton.click();

        //проверьте текст
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'message']")));

        WebElement message = driver.findElement(By.xpath("//p[@id = 'message']"));
        String stringMessage = message.getText();

        if(stringMessage.equalsIgnoreCase("It's gone!")){
            System.out.println("Message is correct");
        } else {
            System.out.println("Message is not correct");
        }

        //нажмите включить убедитесь что текстовое поле включено

        WebElement enableButton = driver.findElement(By.xpath("//button[text() = 'Enable']"));
        enableButton.click();

       Thread.sleep(5000);

        WebElement textBox = driver.findElement(By.xpath("//input[@type = 'text']"));
        textBox.sendKeys("it's working!");

        Thread.sleep(2000);
        textBox.clear();

        Thread.sleep(2000);
        WebElement disableButton = driver.findElement(By.xpath("//button[text() = 'Disable']"));
        disableButton.click();

        Thread.sleep(5000);

        //textBox.sendKeys("hello!");


        boolean isDisTextBox = textBox.isEnabled();
        System.out.println(isDisTextBox);


        if(!isDisTextBox){
            System.out.println("TextBox is Not Enabled");
        }else {
            System.out.println("Enabled");

        }
    }
}




        /*
        Перейти к https://the-internet.herokuapp.com/dynamic_controls
установите флажок и нажмите удалить
проверьте текст
нажмите включить убедитесь что текстовое поле включено
введите текст и нажмите отключить
убедитесь что текстовое поле отключено
         */

