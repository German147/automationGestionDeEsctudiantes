package com.germanBarrera.carina.demo;

import com.germanBarrera.utils.web.WindowsManager;
import com.germanBarrera.utils.common.CidiLoginBase;
import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.web.DefaultDirectorPage;
import com.germanBarrera.utils.web.GestionDeRolesPage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {
    HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

    @Test
    public void loginCidiTest() {
        CidiLoginBase loginPage = initPage(getDriver(), CidiLoginBase.class);
        loginPage.open();
        loginPage.clickIngresarButton();
        loginPage.clickLoginCidi(R.CONFIG.TESTDATA.get("cidi_username"), R.CONFIG.TESTDATA.get("cidi_password"));

        Assert.assertTrue(homePage.isUserNamePresent(), "Home page is not opened");
    }

    @Test(dependsOnMethods = "loginCidiTest")
    public void loginDirectorOption(){
        GestionDeRolesPage roles = homePage.clickOnGestionDeEstudiantesButton();

        WindowsManager tab = new WindowsManager(getDriver());
        tab.switchTabs();
        DefaultDirectorPage directorPage = roles.clickOnDirectorButton();

        Assert.assertTrue(directorPage.isTrayectoriasPresent(), "The Director login was NOT successful");
    }


}
