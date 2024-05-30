package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FichaDelEstudiantePage extends AbstractPage {
    @FindBy(css = "#MainContent_lblTitulo")
    private ExtendedWebElement tituloFicha;

    @FindBy(css = "#MainContent_lnkBreveDescripcion")
    private ExtendedWebElement breveDescriptionBtn;

    @FindBy(css = ".modal-content .headPrimary")
    private ExtendedWebElement modalTitle;

    @FindBy(css = ".close")
    private ExtendedWebElement cerrarBtn;

    @FindBy(css = ".col-lg-2 .form-control ")
    private ExtendedWebElement cicloDropdown;

    @FindBy(css = "#MainContent_ddlGradoAnio")
    private ExtendedWebElement cursoDropdown;

    @FindBy(css = "#MainContent_txtDni")
    private ExtendedWebElement dni;

    @FindBy(css = "#MainContent_txtDni")
    private ExtendedWebElement dniText;

    @FindBy(css = "#MainContent_rptListadoEstudiantes_lblApellido_0")
    private ExtendedWebElement surname;

    @FindBy(css = ".main-footer")
    private ExtendedWebElement footer;

    @FindBy(css = "#MainContent_lnkFiltrar")
    private ExtendedWebElement filtrarBtn;

    public FichaDelEstudiantePage(WebDriver driver) {
        super(driver);
    }

    public boolean isFichaPageOpened() {
        return tituloFicha.isElementPresent();
    }

    public void openDescription() {
        breveDescriptionBtn.click();
    }

    public String descriptionGetText() {
        return modalTitle.getText();
    }

    public void closeModal() {
        cerrarBtn.click();
    }

    public void cicloLectivoOptionMenu() {
        cicloDropdown.click();
    }

    public void selectOptionFromCicloLectivo(String option) {
        findDropDownCicloElement().selectByVisibleText(option);
    }

    private Select findDropDownCicloElement() {
        return new Select(getDriver().findElement(cicloDropdown.getBy()));
    }

    public String getSelectedOption() {
        WebElement element = findDropDownCicloElement().getFirstSelectedOption();
        String selectedElement = element.getText();
        return selectedElement;
    }

    public void clickOnCurso() {
        WebElement element = getDriver().findElement(cursoDropdown.getBy());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private Select findCurso() {
        return new Select(getDriver().findElement(cursoDropdown.getBy()));
    }

    public void selectCurso(int index) {
        findCurso().selectByIndex(index);
    }

    public String getSelectedCursoText() {
        WebElement selectedElement = findCurso().getFirstSelectedOption();
        return selectedElement.getText();
    }

    public void dniFillin(String numberDNI) {
        dni.type(numberDNI);
    }

    public String getDnitext() {
        return dniText.getText();
    }

    public String getStudentSurname() {
        return surname.getText();
    }

    public void scrollDownFichaEstudiante() {
        String scripts = "scroll(0,400);";
        ((JavascriptExecutor) getDriver()).executeScript(scripts);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> footer.isElementPresent());
    }

    public void clickOnFiltrar() {
        filtrarBtn.click();
    }
}
