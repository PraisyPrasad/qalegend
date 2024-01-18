package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.HomePage;
import org.qalegend.page.LoginPage;
import org.qalegend.page.UserManagementPage;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UsersManagementPageTest extends Base {
    @Test(groups = "Smoke")
    public void verifyUserManagementOptions(){
        LoginPage login=new LoginPage(driver);
        ArrayList<String> data= ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username=data.get(2);
        login.enterUserName(username);
        String password=data.get(3);
        login.enterPassWord(password);
        login.clickOnLoginButtonElement();
        HomePage home=login.clickOnEndTourButton();
        UserManagementPage userManagement = home.clickOnUserManagement();
        List<String> actualUserManagementOptions=userManagement.getUserManagementOptions();
        List<String> values = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.USER_MANAGEMENT_PAGE);
        Assert.assertEquals(actualUserManagementOptions,values,Messages.USER_MANAGEMENT_OPTIONS_NOT_VISIBLE);
    }
}
