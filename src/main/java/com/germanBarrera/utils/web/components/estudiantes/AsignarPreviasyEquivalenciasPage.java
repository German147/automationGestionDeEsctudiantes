package com.germanBarrera.utils.web.components.estudiantes;

import com.germanBarrera.utils.web.components.estudiantes.enums.AsignarPreviasDropdowns;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AsignarPreviasyEquivalenciasPage extends AbstractPage {

    @FindBy(css = "#MainContent_divSeleccionEstudiantes")
    private ExtendedWebElement mainContent;

    @FindBy(css = ".pageTitle")
    private ExtendedWebElement pageTitle;

    @FindBy(css = "#Insc #MainContent_ddlCurso")
    private ExtendedWebElement cursos;

    @FindBy(css = ".main-footer")
    private ExtendedWebElement footer;

    @FindBy(css = "#Insc #MainContent_btnBuscar")
    private ExtendedWebElement consultarBtn;

    @FindBy(css = "#MainContent_rptAlumnos_lblEstado_0")
    private ExtendedWebElement inscriptos;

    @FindBy(css = "#MainContent_rptAlumnos_lnkSeleccionar_0")
    private ExtendedWebElement seleccionarBtn;

    @FindBy(css = "#divPrincipal #ddlGraaniTeduc")
    private ExtendedWebElement cursoOptions;

    @FindBy(css = "#divPrincipal #ddlPlanEstudio1")
    private ExtendedWebElement planDeEstudios;

    @FindBy(css = "#lblDetalleAlumno")
    private WebElement alumnosDataTitle;

    @FindBy(css = "#divPrincipal #ddlAsignatura1")
    private ExtendedWebElement espacioCurricular;

    @FindBy(css = "#divPrincipal #ddlAdeudaPor")
    private ExtendedWebElement adeudaPor;

    @FindBy(css = "#divPrincipal #ddlEsTercerMateria")
    private ExtendedWebElement tercerMateriaDropdown;

    @FindBy(css = "#btnAgregarPrevia")
    private ExtendedWebElement agregarbutton;

    @FindBy(css = "#rptListado_lblNasignatura_0")
    private ExtendedWebElement asignaturaBiologia;

    @FindBy(xpath = "//*[@id=\"tblPrevias\"]/tbody/tr")
    private ExtendedWebElement materiasList;


    public AsignarPreviasyEquivalenciasPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTextPresent() {
        return mainContent.isElementPresent();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }


    public void scrollDownAsignarPrevias() {
        String scripts = "scroll(0,400);";
        ((JavascriptExecutor) getDriver()).executeScript(scripts);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> footer.isElementPresent());
    }

    public void clickConsultarButton() {
        consultarBtn.click();
    }

    public boolean isInscriptosElementPresent() {
        return inscriptos.isElementPresent();
    }

    public void clickOnSeleccionarbutton() {
        seleccionarBtn.click();
    }

    public void scrollDownPadding() {
        String scripts = "scroll(0,400);";
        ((JavascriptExecutor) getDriver()).executeScript(scripts);
    }
    //Inscriptos select Curso

    public void clickOnCursoInscriptos() {
        WebElement element = getDriver().findElement(cursos.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void selectCurso(int index) {
        findCursoInscriptos().selectByIndex(index);
    }

    private Select findCursoInscriptos() {
        return new Select(getDriver().findElement(cursos.getBy()));
    }

    public String getSelectedInscriptosCursoText() {
        WebElement selectedElement = findCursoInscriptos().getFirstSelectedOption();
        return selectedElement.getText();
    }

    //generics inner methods for Student Selected padd

    public void clickOnDropdown(AsignarPreviasDropdowns asignarPreviasDropdowns) {
        switchToPadd();
        WebElement element = getDriver().findElement(By.cssSelector(asignarPreviasDropdowns.getCssLocator()));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        switchToParentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findDropDownOptions(AsignarPreviasDropdowns asignarPreviasDropdowns) {
        switch (asignarPreviasDropdowns) {
            case CURSO -> {
                return new Select(getDriver().findElement(By.cssSelector(AsignarPreviasDropdowns.CURSO.getCssLocator())));
            }
            case PLAN_DE_ESTUDIO -> {
                return new Select(getDriver().findElement(By.cssSelector(AsignarPreviasDropdowns.PLAN_DE_ESTUDIO.getCssLocator())));
            }
            case ESPACIO_CURRICULAR -> {
                return new Select(getDriver().findElement(By.cssSelector(AsignarPreviasDropdowns.ESPACIO_CURRICULAR.getCssLocator())));
            }
            case ADEUDA_POR -> {
                return new Select(getDriver().findElement(By.cssSelector(AsignarPreviasDropdowns.ADEUDA_POR.getCssLocator())));
            }
            case TERCER_MATERIA -> {
                return new Select(getDriver().findElement(By.cssSelector(AsignarPreviasDropdowns.TERCER_MATERIA.getCssLocator())));
            }
            default -> throw new IllegalStateException("Unexpected value: " + asignarPreviasDropdowns);
        }
    }


    private void switchToPadd() {
        getDriver().switchTo().frame(0);
    }

    private void switchToParentFrame() {
        getDriver().switchTo().parentFrame();
    }

    //cursos

//    private Select findDropDownCurso() {
//        return new Select(getDriver().findElement(cursoOptions.getBy()));
//
//    }

    public void selectCursoPadd(String curso) {
        switchToPadd();
        findDropDownOptions(AsignarPreviasDropdowns.CURSO).selectByVisibleText(curso);
        switchToParentFrame();
    }

//    public String getSelectedCursoOption() {
//        switchToPadd();
//        WebElement element = findDropDownOptions(AsignarPreviasDropdowns.CURSO).getFirstSelectedOption();
//        String selectedElement = element.getText();
//        switchToParentFrame();
//        return selectedElement;
//    }

    public String getSelectedDropDownOption(AsignarPreviasDropdowns asignarPreviasDropdowns) {
        WebElement element;
        switch (asignarPreviasDropdowns) {
            case CURSO -> {

                element = findDropDownOptions(AsignarPreviasDropdowns.CURSO).getFirstSelectedOption();
                return element.getText();
            }
            case PLAN_DE_ESTUDIO -> {
                element = findDropDownOptions(AsignarPreviasDropdowns.PLAN_DE_ESTUDIO).getFirstSelectedOption();
                return element.getText();
            }
            case ESPACIO_CURRICULAR -> {
                element = findDropDownOptions(AsignarPreviasDropdowns.ESPACIO_CURRICULAR).getFirstSelectedOption();
                return element.getText();
            }
            case ADEUDA_POR -> {
                element = findDropDownOptions(AsignarPreviasDropdowns.ADEUDA_POR).getFirstSelectedOption();
                return element.getText();
            }
            case TERCER_MATERIA -> {
                element = findDropDownOptions(AsignarPreviasDropdowns.TERCER_MATERIA).getFirstSelectedOption();
                return element.getText();
            }
            default -> throw new IllegalStateException("Unexpected value: " + asignarPreviasDropdowns);
        }
    }

    //Plan de estuios

    private Select findDropDownPlanDeEstudios() {
        return new Select(getDriver().findElement(planDeEstudios.getBy()));
    }

    public void selectPlanDeEstudios(int option) {
        switchToPadd();
        findDropDownPlanDeEstudios().selectByIndex(option);
        switchToParentFrame();
    }

    public String getSelectedPlanDeEstuios() {
        switchToPadd();
        WebElement element = findDropDownPlanDeEstudios().getFirstSelectedOption();
        String selectedElement = element.getText();
        switchToParentFrame();
        return selectedElement;
    }

    //Espacio Curricular

    private Select findDropDownEspacioCurriculares() {
        return new Select(getDriver().findElement(espacioCurricular.getBy()));
    }

    public void selectEspacioCurricular(String subject) {
        switchToPadd();
        findDropDownEspacioCurriculares().selectByVisibleText(subject);
        switchToParentFrame();
    }

    public String getSelectedEspacioCurricular() {
        switchToPadd();
        WebElement element = findDropDownEspacioCurriculares().getFirstSelectedOption();
        String selectedElement = element.getText();
        switchToParentFrame();
        return selectedElement;
    }

    //Adeuda por

    private Select findDropDownAdeudaPor() {
        return new Select(getDriver().findElement(adeudaPor.getBy()));
    }

    public void selectAdeudaPorDropdown(String condicion) {
        switchToPadd();
        findDropDownAdeudaPor().selectByVisibleText(condicion);
        switchToParentFrame();
    }

    public String getSelectedAdeudaPor() {
        switchToPadd();
        WebElement element = findDropDownAdeudaPor().getFirstSelectedOption();
        String selectedElement = element.getText();
        switchToParentFrame();
        return selectedElement;
    }

    // Tercer Materia

    private Select findDropDownTercerMateria() {
        return new Select(getDriver().findElement(tercerMateriaDropdown.getBy()));
    }

    public void selectTercerMateria(String yes_no) {
        switchToPadd();
        findDropDownTercerMateria().selectByVisibleText(yes_no);
        switchToParentFrame();
    }

    public String getTercerMateriaSelected() {
        switchToPadd();
        WebElement element = findDropDownTercerMateria().getFirstSelectedOption();
        String selectedElement = element.getText();
        switchToParentFrame();
        return selectedElement;
    }
//****************************************************

    public void clickOnAgregarMateriaBtn() {
        agregarbutton.click();
    }

    public boolean isAsignaturaAdded() {
        return asignaturaBiologia.isElementPresent();
    }

    public List<WebElement> getMateriasList() {
        switchToPadd();
        List<WebElement> asignaturasLists = getDriver().findElements(materiasList.getBy());
        return asignaturasLists;
    }

    public boolean searchMateriaInList(List<String> stringList, String word) {
        // Iterate through the list
        for (String str : stringList) {
            // Check if the specific word is present in the current string
            if (str.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
