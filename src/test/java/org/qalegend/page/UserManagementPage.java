package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.AppUtility;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebElementUtilty;

import java.util.List;

public class UserManagementPage {
    WebDriver driver;
    public UserManagementPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButton;
    @FindBy(xpath="//ul[@class='treeview-menu menu-open']//span[@class='title']")
    List<WebElement> userManagementMenuOptions;
    @FindBy(xpath = "//span[@class='title' and contains(text(), 'Users')]")
    WebElement usersOptionField;

    public AddUsersPage clickOnAddButton() {
        WebElementUtilty.clickOnElement(addButton);
        return new AddUsersPage(driver);
    }
    public List<String> getUserManagementOptions() {
        return AppUtility.getMenuOption(userManagementMenuOptions);
    }
    public UserPage clickOnUsersOption() {
        if (usersOptionField.isDisplayed() && usersOptionField.isEnabled()) {
            WebElementUtilty.clickOnElement(usersOptionField);
        }else  {
            // Handle the case where the element is not interactable
        }
        WaitUtility.pageLoadWait(driver,10);
        return new UserPage(driver);

    }
}
