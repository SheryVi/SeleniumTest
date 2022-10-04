package com.syntax.Class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingPagination {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");

        WebElement loginButton = driver.findElement(By.xpath(" //input[@type = 'submit']"));
        loginButton.click();

        WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimButton.click();

        WebElement addButton = driver.findElement(By.id("menu_pim_addEmployee"));
        addButton.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Hero");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Victory");

        WebElement employeeID = driver.findElement(By.id("employeeId"));
        String empId = employeeID.getAttribute("value");

        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();

        WebElement employeeListButton = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        employeeListButton.click();

        boolean flag = true;
        while (flag) {
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));//reinitialize all the elements because the page gets refreshed after each next click
            for (int i = 0; i < tableRows.size(); i++) {                                    //повторно инициализируйте все элементы, потому что страница обновляется после каждого следующего клика
                String rowText = tableRows.get(i).getText();
                if (rowText.contains(empId)) {
                    flag = false;
                    System.out.println(rowText);
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr[" + i + "]/td[1]"));
                    checkBox.click();
                    WebElement deleteButton = driver.findElement(By.id("btnDelete"));
                    deleteButton.click();
                    WebElement confirmDelete = driver.findElement(By.id("dialogDeleteBtn"));
                    confirmDelete.click();
                    break;
                }

            }
            if(flag){
                WebElement nextButton = driver.findElement(By.linkText("Next"));
                nextButton.click();
            }

        }


    }

}
