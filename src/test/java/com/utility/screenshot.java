/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.utility;

import com.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshot {

    public static void screenshotMethod() throws IOException {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("MM-dd-yy & HH-mm-ss");
        String newDate = format.format(date);

        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getInstance().getDriver();
        File Source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File ("C:\\Users\\Admin\\Desktop\\GOIS\\Shippment\\screenshots "+newDate+".jpg");
        FileHandler.copy(Source,dest);
    }
/*  public static void screenshotMethod(String testName) throws IOException {
      // Get the current date and time for screenshot filename
      Date date = new Date();
      DateFormat format = new SimpleDateFormat("MM-dd-yy & HH-mm-ss");
      String newDate = format.format(date);

      // Capture the screenshot
      TakesScreenshot ts = (TakesScreenshot) DriverFactory.getInstance().getDriver();
      File source = ts.getScreenshotAs(OutputType.FILE);

      // Construct the screenshot file name with the test name
      String fileName = testName + "_" + newDate + ".jpg";
      File dest = new File("C:\\Users\\Admin\\Desktop\\GOIS\\Shippment\\screenshots\\" + fileName);

      // Copy the screenshot to the destination
      FileHandler.copy(source, dest);
      System.out.println("Screenshot saved as: " + fileName);
  }*/



}
