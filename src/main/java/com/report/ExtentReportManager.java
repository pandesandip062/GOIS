package com.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.constants.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.constants.Constants.EXECUTION_REPORT_PATH;

public class ExtentReportManager {

    public static ExtentReports setUpExtentReport(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("MM-dd-yy & HH-mm-ss");
        String newDate = format.format(date);
        ExtentSparkReporter reporter = new ExtentSparkReporter(".//reports//execution"+newDate+".html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}
