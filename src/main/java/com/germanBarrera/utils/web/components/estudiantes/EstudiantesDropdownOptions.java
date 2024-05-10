package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstudiantesDropdownOptions extends AbstractPage {

    @FindBy(css = ".menu-open li")
    private ExtendedWebElement alumnoOptions;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:first-child > a")
    private ExtendedWebElement fichaDelEstudianteLink;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(2) > a")
    private ExtendedWebElement asignarPreviasyEquivalenciasLink;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(3) > a")
    private ExtendedWebElement actualizarPadronLink;

    @FindBy(css = ".fa-exchange")
    private ExtendedWebElement aprobarPorEximicionLink;

    @FindBy(xpath = "//ul[@id='ulAccionesDirectorMenu']//a[@href='/Escuelas/AsignaturasOptativasEstudiantes.aspx']")
    private ExtendedWebElement asignarOptativas;

    @FindBy(xpath = "//ul[@id='ulAccionesDirectorMenu']//a[@href='/Escuelas/AsignaturasOptativasEstudiantes.aspx']")
    private WebElement asignarOptativasVisible;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(6) > a")
    private ExtendedWebElement actualizarDatos;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(7) > a")
    private ExtendedWebElement gestionarLegajo;

    @FindBy(css = ".bg-teal .inner")
    private WebElement elementToAppear;

    public EstudiantesDropdownOptions(WebDriver driver) {
        super(driver);
    }

    public void scrollDown() {
        String scripts = "scroll(0,400);";
        ((JavascriptExecutor) getDriver()).executeScript(scripts);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> asignarOptativas.isElementPresent());
    }

    public FichaDelEstudiantePage fichaEstudianteClick() {
        fichaDelEstudianteLink.click();
        return new FichaDelEstudiantePage(getDriver());
    }

    public AsignarPreviasyEquivalenciasPage asignarPreviaClick() {
        asignarPreviasyEquivalenciasLink.click();
        return new AsignarPreviasyEquivalenciasPage(getDriver());
    }

    public ActualizarPadronPage actualizarPadronClick() {
        actualizarPadronLink.click();
        return new ActualizarPadronPage(getDriver());
    }

    public AprobarPorEximicionPage aprobarPorEximicionClick() {
        aprobarPorEximicionLink.click();
        return new AprobarPorEximicionPage(getDriver());
    }

    public AsignarOptativasPage asignarOptativasClick() {
        asignarOptativas.click();
        return new AsignarOptativasPage(getDriver());
    }


}
