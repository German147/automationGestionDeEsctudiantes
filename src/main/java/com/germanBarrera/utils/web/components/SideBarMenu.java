package com.germanBarrera.utils.web.components;

import com.germanBarrera.utils.web.components.estudiantes.EstudiantesDropdownOptions;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SideBarMenu extends AbstractUIObject {
    public SideBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(css = "[class='sidebar-menu tree'] .treeview")
    private ExtendedWebElement sideBarList;

    @FindBy(xpath = "//a/span[contains(text(), 'Estudiantes')]")
    private ExtendedWebElement estudiantesBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Prematricular / Matricular')]")
    private ExtendedWebElement prematricularBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Reportes')]")
    private ExtendedWebElement reportesBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Progreso')]")
    private ExtendedWebElement progresoBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Institucional')]")
    private ExtendedWebElement institucionalBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Analíticos y Títulos')]")
    private ExtendedWebElement analiticosBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Infraestructura')]")
    private ExtendedWebElement infraestructuraBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Módulo Limpieza')]")
    private ExtendedWebElement limpiezaBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Seguridad')]")
    private ExtendedWebElement seguridadBtn;

    @FindBy(xpath = "//a[contains(span/text(), 'Tutoriales')]")
    private ExtendedWebElement tutorialesBtn;

    public EstudiantesDropdownOptions clickEstudiantesDropdownBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> estudiantesBtn.isElementPresent());
        estudiantesBtn.click();
        return new EstudiantesDropdownOptions(getDriver());
    }
}
