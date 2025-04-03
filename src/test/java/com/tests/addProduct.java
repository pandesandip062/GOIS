/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tests;

import com.Pages.LoginPage;
import com.Pages.ProductPage;
import com.base.BaseTest;
import com.driver.DriverFactory;
import com.properties.TestDataLoader;
import com.report.Screenshhot;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class addProduct extends BaseTest {



    @Test
    public void addProducts(){
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());

        ProductPage addPro = new ProductPage();
        addPro.addProduct();

        //Assert.assertEquals(DriverFactory.getInstance().getDriver().getTitle(),"hjehfgyafguyg");
    }

}
