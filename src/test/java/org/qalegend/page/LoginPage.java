package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilty;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passWordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButtonField;

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/form/div[1]/div/span/strong")
    WebElement errorMessageField;

    @FindBy(xpath = "//a[@class='btn btn-link']")
    WebElement forgotPassWordMenu;
    public String getPageTitle() {
        return driver.getTitle();
    }

    public ResetPage clickOnforgotPassWordMenu() {
        WebElementUtilty.clickOnElement(forgotPassWordMenu);
        return new ResetPage(driver);
    }

    public void enterUserName(String username) {
        WebElementUtilty.enterValue(userNameField, username);
    }

    public void enterPassWord(String password) {
        WebElementUtilty.enterValue(passWordField, password);
    }

    public HomePage clickOnLoginButtonElement() {
        WebElementUtilty.clickOnElement(loginButtonField);
        return new HomePage(driver);
    }
    public String getText() {
        String errorMessageText = WebElementUtilty.getTextFromElement(errorMessageField);
        return errorMessageText;
    }
}