package com.germanBarrera.carina.demo;

import com.germanBarrera.carina.demo.base.FichaDelEstudianteBaseTest;
import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.web.components.SideBarMenu;
import com.germanBarrera.utils.web.components.estudiantes.AsignarPreviasyEquivalenciasPage;
import com.germanBarrera.utils.web.components.estudiantes.EstudiantesDropdownOptions;
import com.germanBarrera.utils.web.components.estudiantes.enums.AsignarPreviasDropdowns;
import com.germanBarrera.utils.web.components.estudiantes.enums.CourseEnum;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class AsignarPrevias_EquivalenciasTest extends FichaDelEstudianteBaseTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void openAsignarPrevias_EquivalenciasPageTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        SideBarMenu sideBar = homePage.getSidebarMenu();
        EstudiantesDropdownOptions options = sideBar.clickEstudiantesDropdownBtn();
        options.scrollDownHomePage();
        AsignarPreviasyEquivalenciasPage previas = options.asignarPreviaClick();
        String title = previas.getPageTitle();
        LOGGER.info("this is the title" + title);
        Assert.assertTrue(previas.getPageTitle().contains(title), "The page was not opened");
    }

    @Test(priority = 2)
    public void selectCursoTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.scrollDownAsignarPrevias();
        asignarPrevias.clickOnCursoInscriptos();
        asignarPrevias.selectCurso(5);
        String selectedCursoName = asignarPrevias.getSelectedInscriptosCursoText();
        Assert.assertTrue(asignarPrevias.getSelectedInscriptosCursoText().contains(selectedCursoName), "The course was not selected");
        LOGGER.info("The selected curso is " + selectedCursoName);
    }

    @Test(priority = 3)
    public void consultarInscriptosTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.clickConsultarButton();
        asignarPrevias.scrollDownAsignarPrevias();
        Assert.assertTrue(asignarPrevias.isInscriptosElementPresent());
    }


    @Test(priority = 4)
    public void seleccionarCursoTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.clickConsultarButton();
        asignarPrevias.clickOnSeleccionarbutton();
        asignarPrevias.clickOnDropdown(AsignarPreviasDropdowns.CURSO);
        asignarPrevias.selectCursoPadd(CourseEnum.SEGUNDO_AÑO.getCurso());
        String selectedCourse = asignarPrevias.getSelectedDropDownOption(AsignarPreviasDropdowns.CURSO);
        LOGGER.info("This is the course selected " + selectedCourse);

        Assert.assertTrue(asignarPrevias.getSelectedDropDownOption(AsignarPreviasDropdowns.CURSO).contains(selectedCourse), "The course was not selected");
    }


//    @Test(priority = 4)
//    public void seleccionarCursoTest() {
//        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
//        asignarPrevias.clickOnSeleccionarbutton();
//        asignarPrevias.clickOnCursoPadd();
//        asignarPrevias.selectOptionFromCurso(3);
//        String selectedCourse = asignarPrevias.getSelectedCursoOption();
//        LOGGER.info("This is the course selected " + selectedCourse);
//
//        Assert.assertTrue(asignarPrevias.getSelectedCursoOption().contains(selectedCourse), "The course was not selected");
//    }

    @Test(priority = 4)
    public void seleccionarPlanDeEstudioTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.clickOnDropdown(AsignarPreviasDropdowns.PLAN_DE_ESTUDIO);
        asignarPrevias.selectPlanDeEstudios(1);
        String planDeEstudiosSelected = asignarPrevias.getSelectedPlanDeEstuios();
        LOGGER.info("This is the plan de estudios selected " + planDeEstudiosSelected);

        Assert.assertTrue(asignarPrevias.getSelectedPlanDeEstuios().contains(planDeEstudiosSelected), "The Plan de Estudios was not Selected");
    }

    @Test(priority = 5)
    public void seleccionarEspacioCurricularTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.clickOnDropdown(AsignarPreviasDropdowns.ESPACIO_CURRICULAR);
        asignarPrevias.selectEspacioCurricular("BIOLOGÍA");
        String espacioCurricular = asignarPrevias.getSelectedEspacioCurricular();
        LOGGER.info("Espacio curricular es " + espacioCurricular);

        Assert.assertTrue(asignarPrevias.getSelectedEspacioCurricular().contains(espacioCurricular), "The espacio curricular was not selected");
    }

    @Test(priority = 6)
    public void adeudaPorEquivalencia_PreviaTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.clickOnDropdown(AsignarPreviasDropdowns.ADEUDA_POR);
        asignarPrevias.selectAdeudaPorDropdown("EQUIVALENCIA");
        String adeudaPor = asignarPrevias.getSelectedAdeudaPor();
        LOGGER.info("La condicion de espacio curricular adeudado es " + adeudaPor);

        Assert.assertTrue(asignarPrevias.getSelectedAdeudaPor().contains(adeudaPor), "The subject condicion is incorrect");
    }

    @Test(priority = 7)
    public void tercerMateriaDropdownTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.clickOnDropdown(AsignarPreviasDropdowns.TERCER_MATERIA);
        asignarPrevias.selectTercerMateria("NO");
        String siOno = asignarPrevias.getTercerMateriaSelected();
        LOGGER.info("Es tercer materia : " + siOno);

        Assert.assertTrue(asignarPrevias.getTercerMateriaSelected().contains(siOno), "The 'condicion' was not selected");
    }

    @Test(priority = 8)
    public void agregarPreviaTest() {
        AsignarPreviasyEquivalenciasPage asignarPrevias = new AsignarPreviasyEquivalenciasPage(getDriver());
        asignarPrevias.clickOnDropdown(AsignarPreviasDropdowns.TERCER_MATERIA);
        List<WebElement> list = asignarPrevias.getMateriasList();
        List<String> materias = new ArrayList<>();
        for (WebElement data : list) {
            materias.add(data.getText());
        }
        LOGGER.info("This is the info " + materias.toString());

        Assert.assertTrue(asignarPrevias.searchMateriaInList(materias, "BIOLOGÍA"), "The subject was not added");
    }

}
