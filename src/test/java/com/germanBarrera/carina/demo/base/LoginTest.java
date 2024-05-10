package com.germanBarrera.carina.demo.base;

import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.common.PortalPageBase;
import com.germanBarrera.utils.common.WindowsManagerBase;
import com.germanBarrera.utils.functionalities.ILogin;
import com.germanBarrera.utils.web.components.HeaderMenu;
import com.germanBarrera.utils.web.pages.GestionDeRolesPage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest implements IAbstractTest, ILogin {


    @BeforeSuite
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "loginCidiTest", value = {"web", "functionalTesting"})
    public void loginCidiTest() {
        PortalPageBase portalPage;
        portalPage = login(R.CONFIG.TESTDATA.get("cidi_username"), R.CONFIG.TESTDATA.get("cidi_password"));
        Assert.assertTrue(portalPage.isUserNamePresent(), "Home page is not opened");
    }

    @BeforeTest
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "loginDirectorOption", value = {"web", "functionalTesting"})
    public void loginDirectorOption() {
        PortalPageBase portalPage = initPage(getDriver(), PortalPageBase.class);
        HomePageBase homePage;
        GestionDeRolesPage roles = portalPage.clickOnGestionDeEstudiantesButton();
        getDriver().manage().timeouts().getPageLoadTimeout();
        WindowsManagerBase tab = initPage(getDriver(), WindowsManagerBase.class);
        tab.switchTabs();
        homePage = roles.clickOnDirectorButton();

        Assert.assertTrue(homePage.isTrayectoriasPresent(), "The Director login was NOT successful");
    }

    @AfterMethod
    public void setupEstudiantesDropdown() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        HeaderMenu header = homePage.getHeader();
        header.clickBurgerBtn();
    }

}
