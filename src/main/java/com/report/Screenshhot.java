/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.report;

import com.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshhot {

    public static void takesScreen() throws IOException {
        TakesScreenshot s = (TakesScreenshot) DriverFactory.getInstance().getDriver();
        File source = s.getScreenshotAs(OutputType.FILE);
        File dest = new File(".//screenshots//.jpg");
        FileHandler.copy(source,dest);
    }
}
