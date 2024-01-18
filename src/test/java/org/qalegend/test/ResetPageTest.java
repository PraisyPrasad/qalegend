package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.LoginPage;
import org.qalegend.page.ResetPage;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.qalegend.utilities.ExcelUtility.readData;

public class ResetPageTest extends Base {
    @Test(groups = "Sanity")
    public void verifyResetPageTitle(){
        LoginPage login = new LoginPage(driver);
        ResetPage reset=login.clickOnforgotPassWordMenu();
        String actualPageTitle = login.getPageTitle();
        ArrayList<String> data = readData(Constants.TEST_DATA_EXCEL_PATH,Constants.RESET_PAGE);
        String expectedPageTitle= data.get(1);
        Assert.assertEquals(actualPageTitle,expectedPageTitle, Messages.TITLE_MISMATCH);

    }
    @Test(groups = "Regression")
    public void verifyErrorMesssageWithInvalidCredentials(){
        LoginPage login=new LoginPage(driver);
        ResetPage reset=login.clickOnforgotPassWordMenu();
        ArrayList<String> data= ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.RESET_PAGE);
        String emailID= data.get(2);
        reset.enterEmailAdress(emailID);
        reset.clickOnSendPassWordRestLink();
        String actualErrorMessage= reset.getText();
        String expectedErrorMessage= data.get(3);
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,Messages.WRONG_USER_EMAIL);
    }
}
