package org.qalegend.utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtilty {
    public static boolean isElementSelected(WebElement element){
        boolean status =element.isSelected();
        return status;
    }
    public static void clickOnElement(WebElement element){
        element.click();
    }
    public static String getTextFromElement(WebElement element){
        return element.getText();
    }
    public static void enterValue(WebElement element, String valueToEnter){
        element.sendKeys(valueToEnter);
    }
    public static Boolean isElementDisplayed(WebElement element){
        Boolean status= element.isDisplayed();
        return status;
    }
    public static Boolean isElementEnabled(WebElement element){
        Boolean status= element.isEnabled();
        return status;
    }
}
