package org.qalegend.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AppUtility {
    public static List<String> getMenuOption(List<WebElement> options) {
        List<String> menuValues = new ArrayList<>();
        for (WebElement option : options) {
            String value = option.getText();
            menuValues.add(value);
        }
        return menuValues;
    }
}
