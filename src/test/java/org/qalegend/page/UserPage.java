package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
    WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
