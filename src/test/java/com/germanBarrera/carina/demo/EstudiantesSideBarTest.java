package com.germanBarrera.carina.demo;

import com.germanBarrera.carina.demo.base.LoginTest;
import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.web.components.HeaderMenu;
import com.germanBarrera.utils.web.components.estudiantes.*;
import com.germanBarrera.utils.web.components.SideBarMenu;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class EstudiantesSideBarTest extends LoginTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(priority = 1)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "estudiantesOptionTest", value = {"web", "functionalTesting"})
    public void fichaDelEstudianteTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        FichaDelEstudiantePage ficha = options.fichaEstudianteClick();
        Assert.assertTrue(ficha.isFichaPageOpened(), "The page was not opened");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "asignarMateriasPreviasPageTest", value = {"web", "functionalTesting"})
    public void asignarMateriasPreviasPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        AsignarPreviasyEquivalenciasPage previas = options.asignarPreviaClick();
        Assert.assertTrue(previas.isTextPresent(), "The page was not opened");
    }

    @Test(priority = 3)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "actualizarPadronPageTest", value = {"web", "functionalTesting"})
    public void actualizarPadronPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        ActualizarPadronPage padronPage = options.actualizarPadronClick();
        String title = padronPage.getTitlePage();

        Assert.assertTrue(padronPage.getTitlePage().contains(title), "Page was not opened");
    }

    @Test(priority = 4)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "aprobarPorEximicionPageTest", value = {"web", "functionalTesting"})
    public void aprobarPorEximicionPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        AprobarPorEximicionPage eximicionPage = options.aprobarPorEximicionClick();
        String pageTitle = eximicionPage.getPageTitleAprobarPorEximicion();
        Assert.assertTrue(eximicionPage.getPageTitleAprobarPorEximicion().contains(pageTitle), "The Eximicion page was not opened");
    }

    @Test(priority = 5)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "asignarOptativasPageTest", value = {"web", "functionalTesting"})
    public void asignarOptativasPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        HeaderMenu header = homePage.getHeader();
        header.clickBurgerBtn();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        AsignarOptativasPage optativas = options.asignarOptativasClick();
        String title = optativas.getPageTitle();

        Assert.assertTrue(optativas.getPageTitle().contains(title), "The page was not opened");
    }

    @Test(priority = 6)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "actualizarDatosPersonalesPageTest", value = {"web", "functionalTesting"})
    public void actualizarDatosPersonalesPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        HeaderMenu header = homePage.getHeader();
        header.clickBurgerBtn();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        ActualizarDatosPage actualizarDatos = options.actualizarDatosPersonalesClick();
        String title = actualizarDatos.getPageTitle();

        Assert.assertTrue(actualizarDatos.getPageTitle().contains(title), "The page was not opened");
    }

    @Test(priority = 7)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "gestionarLegajoDigitalPageTest", value = {"web", "functionalTesting"})
    public void gestionarLegajoDigitalPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        GestionarLegajosPage gestionarLegajosPage = options.gestionarLegajoClick();
        String pageTitle = gestionarLegajosPage.getPageTitle();

        Assert.assertTrue(gestionarLegajosPage.getPageTitle().contains(pageTitle),"The page was not opened");
    }


}
