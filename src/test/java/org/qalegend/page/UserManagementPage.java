package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
    WebDriver driver;
    public UserManagementPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
