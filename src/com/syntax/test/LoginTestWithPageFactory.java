package com.syntax.test;

import com.syntax.pages.DashboardPage;
import com.syntax.pages.LoginWithPageFactory;
import com.syntax.testbase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class LoginTestWithPageFactory {

    public static void main(String[] args) {
        BaseClass.openWithSpecificUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        LoginWithPageFactory loginWithPageFactory = new LoginWithPageFactory();
        DashboardPage dashboardPage = new DashboardPage();
        loginWithPageFactory.username.sendKeys("Admin");
        loginWithPageFactory.password.sendKeys("Hum@nhrm123");
        loginWithPageFactory.loginButton.click();

        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(sourceFile, new File("screenshots/HRMS/dashboard.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
        String welcomeText  = dashboardPage.welcomeAdmin.getText();
        System.out.println(welcomeText);

        BaseClass.tearDown();

    }
}
