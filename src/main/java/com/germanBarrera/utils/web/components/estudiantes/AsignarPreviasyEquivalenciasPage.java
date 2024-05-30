package com.germanBarrera.utils.web.components.estudiantes;

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


    public AsignarPreviasyEquivalenciasPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTextPresent() {
        return mainContent.isElementPresent();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void clickOnCurso() {
        WebElement element = getDriver().findElement(cursos.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findCurso() {
        return new Select(getDriver().findElement(cursos.getBy()));
    }

    public void selectCurso(int index) {
        findCurso().selectByIndex(index);
    }

    public String getSelectedCursoText() {
        WebElement selectedElement = findCurso().getFirstSelectedOption();
        return selectedElement.getText();
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

    public void clickOnCursoPadd() {
        switchToPadd();
        WebElement element = getDriver().findElement(cursoOptions.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findDropDownCurso() {
        return new Select(getDriver().findElement(cursoOptions.getBy()));
    }

    public void selectOptionFromCurso(int option) {
        findDropDownCurso().selectByIndex(option);
    }

    public String getSelectedOption() {
        WebElement element = findDropDownCurso().getFirstSelectedOption();
        String selectedElement = element.getText();
        return selectedElement;
    }

    private void switchToPadd() {
        getDriver().switchTo().frame(0);
    }

    public boolean isEspaciosCurricularesOpened() {
        switchToPadd();
        WebElement element = getDriver().findElement(cursoOptions.getBy());
        return element.isDisplayed();
    }

    //Plan de estuios
    public void clickOnPlanDeEstudio() {
        WebElement element = getDriver().findElement(planDeEstudios.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findDropDownPlanDeEstudios() {
        return new Select(getDriver().findElement(planDeEstudios.getBy()));
    }

    public void selectPlanDeEstudios(int option) {
        findDropDownPlanDeEstudios().selectByIndex(option);
    }

    public String getSelectedPlanDeEstuios() {
        WebElement element = findDropDownPlanDeEstudios().getFirstSelectedOption();
        String selectedElement = element.getText();
        return selectedElement;
    }

    //Espacio Curricular
    public void clickOnEspacioCurricular() {
        WebElement element = getDriver().findElement(espacioCurricular.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findDropDownEspacioCurriculares() {
        return new Select(getDriver().findElement(espacioCurricular.getBy()));
    }

    public void selectEspacioCurricular(String subject) {
        findDropDownEspacioCurriculares().selectByVisibleText(subject);
    }

    public String getSelectedEspacioCurricular() {
        WebElement element = findDropDownEspacioCurriculares().getFirstSelectedOption();
        String selectedElement = element.getText();
        return selectedElement;
    }

    //Adeuda por
    public void clickOnAdeudaPorDropdown() {
        WebElement element = getDriver().findElement(adeudaPor.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findDropDownAdeudaPor() {
        return new Select(getDriver().findElement(adeudaPor.getBy()));
    }

    public void selectAdeudaPorDropdown(String condicion) {
        findDropDownAdeudaPor().selectByVisibleText(condicion);
    }

    public String getSelectedAdeudaPor() {
        WebElement element = findDropDownAdeudaPor().getFirstSelectedOption();
        String selectedElement = element.getText();
        return selectedElement;
    }

    // Tercer Materia

    public void clickOnTercerMateriaDropdown() {
        WebElement element = getDriver().findElement(tercerMateriaDropdown.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findDropDownTercerMateria() {
        return new Select(getDriver().findElement(tercerMateriaDropdown.getBy()));
    }

    public void selectTercerMateria(String yes_no) {
        findDropDownTercerMateria().selectByVisibleText(yes_no);
    }

    public String getTercerMateriaSelected() {
        WebElement element = findDropDownTercerMateria().getFirstSelectedOption();
        String selectedElement = element.getText();
        return selectedElement;
    }

    public void clickOnAgregarMateria() {
        agregarbutton.click();
    }
    public boolean isAsignaturaAdded(){
        return asignaturaBiologia.isElementPresent();
    }
//    public List<WebElement> getAsignaturasList() {
//        List<WebElement> asignaturasLists = getDriver().findElements(prices.getBy());
//        return asignaturasLists;
//    }
}
