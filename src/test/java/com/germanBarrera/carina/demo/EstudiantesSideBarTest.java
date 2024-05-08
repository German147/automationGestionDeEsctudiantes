package com.germanBarrera.carina.demo;

import com.germanBarrera.carina.demo.base.LoginTest;
import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.web.components.HeaderMenu;
import com.germanBarrera.utils.web.components.estudiantes.AsignarPreviasyEquivalenciasPage;
import com.germanBarrera.utils.web.components.estudiantes.EstudiantesDropdownOptions;
import com.germanBarrera.utils.web.components.estudiantes.FichaDelEstudiantePage;
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
        AsignarPreviasyEquivalenciasPage previas = options.asignarPreviaClick();
        Assert.assertTrue(previas.isTextPresent(), "The page was not opened");
    }

}
