package com.germanBarrera.carina.demo;

import com.germanBarrera.carina.demo.base.LoginTest;
import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.functionalities.ILogin;
import com.germanBarrera.utils.web.components.TrayectoriasMenu;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;

import org.testng.annotations.Test;

public class TrayectoriasComponentTest extends LoginTest implements IAbstractTest, ILogin {

    HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
    TrayectoriasMenu trayectoriasMenu = homePage.getTrayectoriasMenu();

    @Test(priority = 1)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "gradoRiesgoDiagramTest", value = {"web", "functionalTesting"})
    public void gradoRiesgoDiagramTest() {
        trayectoriasMenu.clickOnGradoRiesgoButton();
        Assert.assertTrue(trayectoriasMenu.isGradoRiesgoDiagramPresent(), "The Grados Riesgo button was not clicked");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "riesgoSeccionDiagramTest", value = {"web", "functionalTesting"})
    public void riesgoSeccionDiagramTest() {
        trayectoriasMenu.clickOnRiesgoSeccionButton();
        Assert.assertTrue(trayectoriasMenu.isRiesgoSeccionDiagramPresent(), "The Riesgo Seccion button was not clicked");
    }

    @Test(priority = 3)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "riesgoOrientacionDiagramTest", value = {"web", "functionalTesting"})
    public void riesgoOrientacionDiagramTest() {
        trayectoriasMenu.clickOnRiesgoOrientacionButton();
        Assert.assertTrue(trayectoriasMenu.isRiesgoOrientacionDiagramPresent(), "The Riesgo Orientacion button was not clicked");
    }

    @Test(priority = 4)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "cargaIntervencionesDiagramTest", value = {"web", "functionalTesting"})
    public void cargaIntervencionesDiagramTest() {
        trayectoriasMenu.clickOnCargaIntervencionesButton();
        Assert.assertTrue(trayectoriasMenu.isCargaIntervencionesDiagramPresent(), "The Carga Intervenciones button was not clicked");
    }

    @Test(priority = 5)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "intervencionesDiagramTest", value = {"web", "functionalTesting"})
    public void intervencionesDiagramTest() {
        trayectoriasMenu.clickOnIntervencionesButton();
        Assert.assertTrue(trayectoriasMenu.isIntervencionesDiagramPresent(), "The Intervenciones button was not clicked");
    }
}
