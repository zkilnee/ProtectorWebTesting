package com.automation.testClass;

import com.automation.driverManager.Driver;
import com.automation.propertyReader.PropertyFileReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by vikas.kumar1 on 01-01-2018.
 */
public class BaseTest {
    public  static ExtentHtmlReporter extentReporter;
    public  static ExtentReports extentReport;
    public WebDriver driver;

    @BeforeSuite
    public void initSuit() throws Exception {
        initReport();
        driver = Driver.getDriver();
        Driver.getUrl();
    }

    public void closeBrowser(){
        Driver.close();
    }

    public void initReport() throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddHH-mm-ss") ;
        Date date = new Date() ;
        extentReporter = new ExtentHtmlReporter(PropertyFileReader.getProperty("pathOfReport")+"TestReport"+dateFormat.format(date)+".html" );
        extentReport = new ExtentReports();
        extentReport.attachReporter(extentReporter);
    }



}
