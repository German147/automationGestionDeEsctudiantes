package com.germanBarrera.carina.demo;

import com.germanBarrera.utils.common.WindowsManagerBase;
import com.zebrunner.carina.utils.R;
import com.germanBarrera.utils.functionalities.ILogin;
import com.germanBarrera.utils.web.DefaultDirectorPage;
import com.germanBarrera.utils.web.GestionDeRolesPage;
import com.germanBarrera.utils.web.HomePage;
import com.germanBarrera.utils.web.WindowsManager;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlatformCidiTests implements IAbstractTest, ILogin {

    HomePage homePage = new HomePage(getDriver());
    @Test
    public void loginCidiTest() {
        homePage = login(R.CONFIG.TESTDATA.get("cidi_username"), R.CONFIG.TESTDATA.get("cidi_password"));
        Assert.assertTrue(homePage.isUserNamePresent(), "Home page is not opened");
    }

    @Test(dependsOnMethods = "loginCidiTest")
    public void loginDirectorOption(){
        GestionDeRolesPage roles = homePage.clickOnGestionDeEstudiantesButton();
        WindowsManagerBase tab = initPage(getDriver(), WindowsManagerBase.class);
        tab.switchTabs();
        DefaultDirectorPage directorPage = roles.clickOnDirectorButton();

        Assert.assertTrue(directorPage.isTrayectoriasPresent(), "The Director login was NOT successful");
    }
}
