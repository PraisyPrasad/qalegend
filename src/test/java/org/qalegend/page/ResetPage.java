package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebElementUtilty;

public class ResetPage {
    WebDriver driver;
    public ResetPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//button[@type='submit']")
    WebElement sendPassWordResetLinkButton;

    @FindBy(xpath = "//*[contains(text(), \"We can't find a user with that e-mail address.\")]")
    WebElement resetPassWordErrorMessageField;

    @FindBy(id = "email")
    WebElement emailAdressField;
    public String getPageTitle() {
        return driver.getTitle();
    }
    public void clickOnSendPassWordRestLink() {
        WebElementUtilty.clickOnElement(sendPassWordResetLinkButton);
    }
    public String getText() {
        String errorMessageText=WebElementUtilty.getTextFromElement(resetPassWordErrorMessageField);
        return errorMessageText;
    }
    public void enterEmailAdress(String emailID) {
        WebElementUtilty.enterValue(emailAdressField,emailID);

    }
}
