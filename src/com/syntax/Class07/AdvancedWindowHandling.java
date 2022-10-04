package com.syntax.Class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {
            //click on buttons and open new windows(tabs)
            //switch to windows and perform different actions
            //нажимайте на кнопки и открывайте новые окна (вкладки)
            //переключитесь на Windows и выполните различные действия

    public static String url = "http://syntaxprojects.com/window-popup-modal-demo.php";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        String mainPageHandle = driver.getWindowHandle();
        WebElement idButton = driver.findElement(By.linkText("Follow On Instagram"));
        WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement idAndButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));
        idButton.click();
        fbButton.click();
        idAndButton.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()){         //start iterating through the handles
            String handle = it.next();      //get the next handle
            if(!mainPageHandle.equals(handle)){       //set a condition
                driver.switchTo().window(handle);     //switch to a window which is not equal to main handle
                //driver.manage().window().maximize();
                String title = driver.getTitle();
                System.out.println(title);
                driver.close();
            }
        }
        driver.switchTo().window(mainPageHandle);  //switching back to parent handle
        idButton.click();

    }
}
