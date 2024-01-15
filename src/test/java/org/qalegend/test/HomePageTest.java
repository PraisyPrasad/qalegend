package org.qalegend.test;

import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.HomePage;
import org.qalegend.page.LoginPage;
import org.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.qalegend.utilities.ExcelUtility.readData;

public class HomePageTest extends Base {
    @Test
    public void verifyHomePageTitle() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.HOME_PAGE);
        String userName = data.get(2);
        login.enterUserName(userName);
        String passWord = data.get(3);
        login.enterPassWord(passWord);
        HomePage home = login.clickOnLoginButtonElement();
        String actualHomePageTitle = home.getTitle();
        String expectedHomePageTitle = data.get(1);
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, Messages.TITLE_MISMATCH);
    }

    @Test
    public void verifyUserLoginDate() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username = data.get(2);
        login.enterUserName(username);
        String password = data.get(3);
        login.enterPassWord(password);
        HomePage home = login.clickOnLoginButtonElement();
        String actualLoginDate = home.getLoginDate();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        String expectedLoginDate = dateFormat.format(currentDate);
        Assert.assertEquals(actualLoginDate, expectedLoginDate, Messages.LOGIN_DATE_FAILED);
    }
}
