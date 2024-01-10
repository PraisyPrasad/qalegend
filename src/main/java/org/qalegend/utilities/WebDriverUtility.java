package org.qalegend.utilities;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
    public static void loadUrl(WebDriver driver,String URL){
        driver.get(URL);
    }
    public static String getTitle(WebDriver driver){
        String status = driver.getTitle();
        return status;
    }
    public static String getPagesource(WebDriver driver){
        String status = driver.getPageSource();
        return status;
    }
    public static String WindowHandle(WebDriver driver) {
        String status = driver.getPageSource();
        return status;
    }
    public static String currentURL(WebDriver driver) {
        String status = driver.getCurrentUrl();
        return status;
    }
}
