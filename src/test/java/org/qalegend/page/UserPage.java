package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilty;

public class UserPage {
    WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButtonField;
    @FindBy(xpath = "//table//tr//td[4][contains(text(), 'shifana123@gmail.com')]")
    WebElement actualMailIdOfNewlyAddedUser;

    @FindBy(xpath="//a[@class='dropdown-toggle']//span[text()='admin KL']")
    WebElement usersLoggedUserName;

    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signOutButton;

    @FindBy(xpath="//table//tr[1]/td[4]")
    WebElement loggedUsersEmailID;

    public AddUsersPage clickOnAddButton() {
        WebElementUtilty.clickOnElement(addButtonField);
        return new AddUsersPage(driver);
    }
    public String getTextOfMailID() {
        String emailText=WebElementUtilty.getTextFromElement(actualMailIdOfNewlyAddedUser);
        return emailText;
    }
    public  void clickOnUsersLoggedUserName() {
        WebElementUtilty.clickOnElement(usersLoggedUserName);
    }
    public LoginPage clickOnSignOutButton(){
        WebElementUtilty.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
    public String getTextFromLoggedUsersMailID() {
        return WebElementUtilty.getTextFromElement(loggedUsersEmailID);
    }
}

