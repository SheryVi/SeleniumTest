package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.testbase.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPageTest  {

    public static void main(String[] args) {
        BaseClass.openWithSpecificUrl("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/login.aspx");
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("Tester");
        loginPage.password.sendKeys("test");
        loginPage.loginButton.click();

        BaseClass.tearDown();
    }
}
