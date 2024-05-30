package com.germanBarrera.carina.demo;

import com.germanBarrera.carina.demo.base.FichaDelEstudianteBaseTest;
import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.web.components.SideBarMenu;
import com.germanBarrera.utils.web.components.estudiantes.EstudiantesDropdownOptions;
import com.germanBarrera.utils.web.components.estudiantes.FichaDelEstudiantePage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;

public class FichaDelEstudianteTests extends FichaDelEstudianteBaseTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "estudiantesOptionTest", value = {"web", "functionalTesting"})
    public void getfichaDelEstudiantePage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        FichaDelEstudiantePage ficha = options.fichaEstudianteClick();
        Assert.assertTrue(ficha.isFichaPageOpened(), "The page was not opened");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "breveDescriptionTest", value = {"web", "functionalTesting"})
    public void breveDescriptionTest() {
        FichaDelEstudiantePage fichaDelEstudiantePage = new FichaDelEstudiantePage(getDriver());
        fichaDelEstudiantePage.openDescription();
        String modalTitle = fichaDelEstudiantePage.descriptionGetText();

        softAssert.assertTrue(fichaDelEstudiantePage.descriptionGetText().contains(modalTitle), "The modal panel was not opened");
        fichaDelEstudiantePage.closeModal();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "cicloLectivoDropdownTest", value = {"web", "functionalTesting"})
    public void cicloLectivoDropdownTest() {
        FichaDelEstudiantePage fichaDelEstudiantePage = new FichaDelEstudiantePage(getDriver());
        fichaDelEstudiantePage.selectOptionFromCicloLectivo("2022");
        String years = fichaDelEstudiantePage.getSelectedOption();
        LOGGER.info("The year selected is " + years);
        softAssert.assertTrue(fichaDelEstudiantePage.getSelectedOption().contains("2022"),"Wrong year selected");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "selectCursoTest", value = {"web", "functionalTesting"})
    public void selectCursoTest() {
        FichaDelEstudiantePage fichaDelEstudiantePage = new FichaDelEstudiantePage(getDriver());
        fichaDelEstudiantePage.scrollDownFichaEstudiante();
        fichaDelEstudiantePage.clickOnCurso();
        fichaDelEstudiantePage.selectCurso(3);
        String selectedCurso = fichaDelEstudiantePage.getSelectedCursoText();
        LOGGER.info("This is the inner text from index 3: " + selectedCurso);
        softAssert.assertTrue(fichaDelEstudiantePage.getSelectedCursoText().contains("SEGUNDO AÑO \"A\" MAÑANA (687197747)"), "Incorrect option selected in cursos");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "numDocTest", value = {"web", "functionalTesting"})
    public void numDocTest() {
        FichaDelEstudiantePage fichaDelEstudiantePage = new FichaDelEstudiantePage(getDriver());
        fichaDelEstudiantePage.dniFillin("25068320");
        String dniNumber = fichaDelEstudiantePage.getDnitext();

        softAssert.assertTrue(fichaDelEstudiantePage.getDnitext().contains(dniNumber), "The DNI is incorrect");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "searchStudentTest", value = {"web", "functionalTesting"})
    public void searchStudentTest() {
        FichaDelEstudiantePage fichaDelEstudiantePage = new FichaDelEstudiantePage(getDriver());
        fichaDelEstudiantePage.clickOnFiltrar();
        String surname = fichaDelEstudiantePage.getStudentSurname();

        softAssert.assertTrue(fichaDelEstudiantePage.getStudentSurname().contains(surname), "Selected Student is incorrect");
        softAssert.assertAll();
    }


}
