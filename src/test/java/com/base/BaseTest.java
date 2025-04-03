
package com.base;

import com.driver.BrowserFactrory;
import com.driver.DriverFactory;
import com.properties.ConfigLoadeer;
import com.properties.TestDataLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import javax.swing.*;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        WebDriver driver = BrowserFactrory.createBrowserInstance(ConfigLoadeer.getInstance().getPropertyValue("browser"));
        DriverFactory.getInstance().setDriver(driver);

        DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());

    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().getDriver().quit();
    }
}
