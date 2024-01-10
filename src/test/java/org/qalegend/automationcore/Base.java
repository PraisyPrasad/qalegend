package org.qalegend.automationcore;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qalegend.utilities.WebDriverUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class Base {
    public WebDriver driver;

    public void initializeBrowser(String browser) {
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Invalid Browser");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        initializeBrowser("Chrome");
        WebDriverUtility.loadUrl(driver,"https://qalegend.com/billing/public/login");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE) {
            takeScreenshot(result);
        }
        driver.close();
    }
    public void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File screenshot=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("./Screenshots/"+result.getName()+".png"));

    }

}

