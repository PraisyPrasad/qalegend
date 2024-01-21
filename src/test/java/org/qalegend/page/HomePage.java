package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.DateUtility;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebElementUtilty;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='dropdown-toggle']//span[text()='admin KL']")
    WebElement userLoggedAccount;
    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']/strong[text()='19-01-2024']")
    WebElement loginDateElement;
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagementOptionField;
    @FindBy(xpath = "//span[@class='title' and contains(text(), 'Users')]")
    WebElement usersOptionField;
    @FindBy(xpath = "//span[@class='title' and contains(text(), 'Roles')]")
    WebElement rolesOptionField;

    @FindBy(xpath = "//span[@class='title' and contains(text(), 'Sales Commission Agents')]")
    WebElement salesCommissionAgentOptionField;
    @FindBy(xpath="//h1[contains(text(), 'Welcome Praisy')]")
    WebElement registeredUserNameText;

    @FindBy(xpath="//a[@class='dropdown-toggle']//span[text()='Shifana S']")
    WebElement newlyAddedUsersUserName;

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
    public String getCurrentDate() {
        String currentDate = DateUtility.getCurrentDateFormatted("dd-MM-yyyy");
        return currentDate;
    }
    public UserManagementPage clickOnUserManagement() {
        WebElementUtilty.clickOnElement(userManagementOptionField);
        return new UserManagementPage(driver);
    }

    public UserPage clickOnUsersOption() {
        WebElementUtilty.isElementDisplayed(usersOptionField);
        if (usersOptionField.isDisplayed() && usersOptionField.isEnabled()) {
            WebElementUtilty.clickOnElement(usersOptionField);
        }else  {
            // Handle the case where the element is not interactable
        }
        WaitUtility.pageLoadWait(driver,10);
        return new UserPage(driver);
    }
    public void isRolesFieldDisplayed() {
        WebElementUtilty.isElementDisplayed(rolesOptionField);
    }
    public void isSalesCommissionAgentFieldDisplayed() {
        WebElementUtilty.isElementDisplayed(salesCommissionAgentOptionField);
    }
    public String getTextFromLoggedUserName() {
        return WebElementUtilty.getTextFromElement(registeredUserNameText);
    }
    public String getTextNewlyAddedUserName() {
        return WebElementUtilty.getTextFromElement(newlyAddedUsersUserName);
    }
}
