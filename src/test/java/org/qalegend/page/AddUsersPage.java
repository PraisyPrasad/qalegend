package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddUsersPage {
    WebDriver driver;
    public AddUsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
