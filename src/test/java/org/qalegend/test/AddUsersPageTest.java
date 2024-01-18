package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.*;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.RandomUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AddUsersPageTest extends Base {
    @Test(groups = "Sanity")
    public void verifyAddUserTitle() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username = data.get(2);
        login.enterUserName(username);
        String password = data.get(3);
        login.enterPassWord(password);
        login.clickOnLoginButtonElement();
        HomePage home = login.clickOnEndTourButton();
        home.clickOnUserManagement();
        UserPage userPage = home.clickOnUsersOption();
        AddUsersPage addPage = userPage.clickOnAddButton();
        String actualUserPageTitle = addPage.getTitle();
        ArrayList<String> userPageData = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.ADD_USER_PAGE);
        String expectedUserPageTitle = userPageData.get(1);
        Assert.assertEquals(actualUserPageTitle, expectedUserPageTitle, Messages.TITLE_MISMATCH);
    }

    @Test(groups = "Smoke")
    public void verifyAddUser() {
        String firstName = RandomUtility.getFirstName();
        String lastName = RandomUtility.getLastName();
        String emailID = firstName + "." + lastName + "123@yahoo.com";
        String password = firstName + "." + lastName;
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String loginUsername = data.get(2);
        login.enterUserName(loginUsername);
        String loginPassword = data.get(3);
        login.enterPassWord(loginPassword);
        login.clickOnLoginButtonElement();
        HomePage home = login.clickOnEndTourButton();
        home.clickOnUserManagement();
        UserPage userPage = home.clickOnUsersOption();
        AddUsersPage adduser = userPage.clickOnAddButton();
        adduser.enterFirstName(firstName);
        adduser.enterLastName(lastName);
        adduser.enterEmailId(emailID);
        adduser.enterUserName(firstName);
        adduser.enterPassWord(password);
        adduser.enterconfirmPassWord(password);
        adduser.clickOnSaveButton();
    }

    @Test(groups = "Smoke")
    public void verifyUserLoginNewlyAddUser() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.ADD_USER_PAGE);
        String loginUsername = data.get(2);
        login.enterUserName(loginUsername);
        String loginPassword = data.get(3);
        login.enterPassWord(loginPassword);
        login.clickOnLoginButtonElement();
        HomePage home = login.clickOnEndTourButton();
        String actualRegisteredUserPageNameTest = home.getTextFromLoggedUserName();
        String expectedRegisteredUserPageNameTest = "Welcome " + data.get(5) + ",";
        Assert.assertEquals(actualRegisteredUserPageNameTest,expectedRegisteredUserPageNameTest,Messages.USER_MANAGEMENT_OPTIONS_NOT_VISIBLE);
    }
}
