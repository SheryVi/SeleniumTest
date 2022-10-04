package com.syntax.Class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesWithPagination {
    public static String url = "http://syntaxprojects.com/table-pagination-demo.php";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List <WebElement> rows = driver.findElements(By.xpath("//table[@class = 'table table-hover']/tbody/tr"));
        WebElement nextButton = driver.findElement(By.xpath("//a[@class = 'next_link']"));

        boolean flag = true;
        while (flag){
            for(WebElement row: rows){
                String rowText = row.getText();
                if(rowText.contains("Archy J")){
                    flag=false;
                    System.out.println(rowText);
                    break;
                }

        }
            if(flag) {
                nextButton.click();
            }

        }
    }
}
