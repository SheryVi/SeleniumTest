package com.syntax.Class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

        public static String url = "http://jqueryui.com/droppable";

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            driver.switchTo().frame(0);
            WebElement draggable = driver.findElement(By.id("draggable"));
            WebElement droppable = driver.findElement(By.id("droppable"));

            Actions action = new Actions(driver);
            //action.dragAndDrop(draggable, droppable).perform();
            action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

            driver.navigate().refresh();


    }
}
