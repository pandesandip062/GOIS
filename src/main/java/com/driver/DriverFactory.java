package com.driver;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverFactory(){

    }

    @Getter
    private static DriverFactory instance = new DriverFactory();


    public void setDriver(WebDriver driverObj){
        driver.set(driverObj);
    }
    public WebDriver getDriver(){
        return driver.get();
    }

}
