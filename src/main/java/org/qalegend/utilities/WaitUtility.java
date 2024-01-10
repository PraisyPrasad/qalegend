package org.qalegend.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    public static void pageLoadWait(WebDriver driver,int time){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }
    public static void impliciteWait(WebDriver driver,int time){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }
    public static void explicitWait(WebDriver driver,int time,String locatorvalue) {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public static void fluentWait(WebDriver driver,int time,String locatorvalue) {
        FluentWait wait=new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(time));
        wait.pollingEvery(Duration.ofSeconds(time));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
