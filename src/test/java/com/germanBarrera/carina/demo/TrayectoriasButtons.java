package com.germanBarrera.carina.demo;

import com.germanBarrera.utils.common.DefaultDirectorPageBase;
import com.germanBarrera.utils.common.WindowsManagerBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.germanBarrera.utils.functionalities.ILogin;
import com.germanBarrera.utils.web.GestionDeRolesPage;
import com.germanBarrera.utils.web.HomePage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TrayectoriasButtons implements IAbstractTest, ILogin {

    HomePage homePage = new HomePage(getDriver());
    DefaultDirectorPageBase principalPage = initPage(getDriver(), DefaultDirectorPageBase.class);

    @BeforeSuite
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "loginCidiTest", value = {"web", "functionalTesting"})
    public void loginCidiTest() {
        homePage = login(R.CONFIG.TESTDATA.get("cidi_username"), R.CONFIG.TESTDATA.get("cidi_password"));
        Assert.assertTrue(homePage.isUserNamePresent(), "Home page is not opened");
    }

    @BeforeTest
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "loginDirectorOption", value = {"web", "functionalTesting"})
    public void loginDirectorOption() {
        GestionDeRolesPage roles = homePage.clickOnGestionDeEstudiantesButton();
        WindowsManagerBase tab = initPage(getDriver(), WindowsManagerBase.class);
        tab.switchTabs();
        principalPage = roles.clickOnDirectorButton();

        Assert.assertTrue(principalPage.isTrayectoriasPresent(), "The Director login was NOT successful");
    }

    @Test(priority = 1)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "gradoRiesgoButtonTest", value = {"web", "functionalTesting"})
    public void gradoRiesgoButtonTest() {
        principalPage.clickOnGradoRiesgoButton();
        Assert.assertTrue(principalPage.isGradoRiesgoDiagramPresent(), "The Grados Riesgo button was not clicked");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "riesgoSeccionButtonTest", value = {"web", "functionalTesting"})
    public void riesgoSeccionButtonTest() {
        principalPage.clickOnRiesgoSeccionButton();
        Assert.assertTrue(principalPage.isRiesgoSeccionDiagramPresent(), "The Riesgo Seccion button was not clicked");
    }

    @Test(priority = 3)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "riesgoOrientacionButtonTest", value = {"web", "functionalTesting"})
    public void riesgoOrientacionButtonTest() {
        principalPage.clickOnRiesgoOrientacionButton();
        Assert.assertTrue(principalPage.isRiesgoOrientacionDiagramPresent(), "The Riesgo Orientacion button was not clicked");
    }

    @Test(priority = 4)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "cargaIntervencionesButtonTest", value = {"web", "functionalTesting"})
    public void cargaIntervencionesButtonTest() {
        principalPage.clickOnCargaIntervencionesButton();
        Assert.assertTrue(principalPage.isCargaIntervencionesDiagramPresent(), "The Carga Intervenciones button was not clicked");
    }

    @Test(priority = 5)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "intervencionesButtonTest", value = {"web", "functionalTesting"})
    public void intervencionesButtonTest() {
        principalPage.clickOnIntervencionesButton();
        Assert.assertTrue(principalPage.isIntervencionesDiagramPresent(), "The Intervenciones button was not clicked");
    }

}
