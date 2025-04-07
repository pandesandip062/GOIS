package com.report;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.driver.DriverFactory;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ExtentFactory {

    // Using ThreadLocal to store ExtentTest instances
    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    private ExtentFactory() {}

    // Singleton instance of ExtentFactory
    @Getter
    private static ExtentFactory instance = new ExtentFactory();

    // Set the ExtentTest for the current thread
    public void setExtent(ExtentTest obj) {
        extent.set(obj);
    }
    public static ExtentFactory getInstance() {
        return instance;
    }

    // Get the ExtentTest for the current thread
    public ExtentTest getExtentTest() {
        return extent.get(); // Ensure this is not null
    }

    // Remove the ExtentTest for the current thread
    public void removeTest() {
        extent.remove();
    }

    // Capture screenshot as Base64
    public static String captureApplicationScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getInstance().getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        byte[] fileContent = null;

        try {
            fileContent = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileContent == null) {
            System.out.println("Screenshot capture failed.");
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }

    // Methods for passing and failing actions
    public static void clickPass(String btnName) {
        if (getInstance().getExtentTest() != null) {
            getInstance().getExtentTest().pass(btnName + " button is clicked ");
        }
    }

    public static void clickFail(String btnName) {
        if (getInstance().getExtentTest() != null) {
            getInstance().getExtentTest().fail("Error while clicking " + btnName);
        }
    }

    public static void sendKeysPass(String value, String elementName) {
        if (getInstance().getExtentTest() != null) {
            getInstance().getExtentTest().pass(value + " entered in " + elementName);
        }
    }

    public static void sendKeysFail(String value, String elementName) {
        if (getInstance().getExtentTest() != null) {
            getInstance().getExtentTest().fail(value + " is not entered due to error in " + elementName);
        }
    }

    public static void passTest(String message) {
        if (getInstance().getExtentTest() != null) {
            getInstance().getExtentTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));

        }
    }

    public static void failTest(String message) {
        if (getInstance().getExtentTest() != null) {
            String screenshotBase64 = captureApplicationScreenshot();
            getInstance().getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
        }
    }
}
