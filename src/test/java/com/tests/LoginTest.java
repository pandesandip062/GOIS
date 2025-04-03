/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tests;

import com.Pages.LoginPage;
import com.base.BaseTest;
import com.driver.DriverFactory;
import com.properties.TestDataLoader;
import com.report.Screenshhot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {


    @Test
    public void loginWithValidateUserNameAndValidPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());
        try {
            Screenshhot.takesScreen();
            System.out.println("took screenshot");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Assert.assertEquals(DriverFactory.getInstance().getDriver().getTitle(),"hjehfgyafguyg");
    }
}
