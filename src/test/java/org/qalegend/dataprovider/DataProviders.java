package org.qalegend.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="verifyInvalidLoginCredentials")
    public Object[][] userCredentialsData() {
        Object[][] data=new Object[3][2];
        data[0][0]="admin";
        data[0][1]="123";

        data[1][0]="admin";
        data[1][1]="12346";

        data[2][0]="Admin";
        data[2][1]="123";
        return data;
    }
}

