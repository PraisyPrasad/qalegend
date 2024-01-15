package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilty;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='dropdown-toggle']//span[text()='admin KL']")
    WebElement userLoggedAccount;
    @FindBy(xpath = "/html/body/div[2]/header/nav/div/div/strong")
    WebElement loginDateElement;


    public String getTitle() {
        return driver.getTitle();
    }
    public String getUserLoggedAccount() {
        String username = WebElementUtilty.getTextFromElement(userLoggedAccount);
        return username;
    }
    public String getLoginDate() {
        String loginDate=WebElementUtilty.getTextFromElement(loginDateElement);
        return loginDate;
    }

}
