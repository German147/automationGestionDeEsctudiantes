package com.germanBarrera.carina.demo.base;

import com.germanBarrera.utils.common.CidiLoginBase;
import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.functionalities.ILogin;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest implements IAbstractTest, ILogin {

    HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

    @Test
    public void loginCidiTest() {
        homePage = login(R.CONFIG.TESTDATA.get("cidi_username"), R.CONFIG.TESTDATA.get("cidi_password"));
        Assert.assertTrue(homePage.isUserNamePresent(), "Home page is not opened");
        Assert.assertTrue(homePage.isUserNamePresent(), "Home page is not opened");
    }
}
