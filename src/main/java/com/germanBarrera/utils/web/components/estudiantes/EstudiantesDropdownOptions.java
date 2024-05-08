package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EstudiantesDropdownOptions extends AbstractPage {

    @FindBy(css = ".menu-open li")
    private ExtendedWebElement alumnoOtions;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:first-child > a")
    private ExtendedWebElement fichaDelEstudianteLink;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(2) > a")
    private ExtendedWebElement  asignarPreviasyEquivalenciasLink;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(3) > a")
    private ExtendedWebElement  actualizarPadronLink;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(4) > a")
    private ExtendedWebElement  aprobarPorEximicionLink;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(5) > a")
    private ExtendedWebElement  asignarOptativas;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(6) > a")
    private ExtendedWebElement  actualizarDatos;

    @FindBy(css = "li.treeview.menu-open ul.treeview-menu > li:nth-child(7) > a")
    private ExtendedWebElement  gestionarLegajo;


    public EstudiantesDropdownOptions(WebDriver driver) {
        super(driver);
    }

    public FichaDelEstudiantePage fichaEstudianteClick() {
        fichaDelEstudianteLink.click();
        return new FichaDelEstudiantePage(getDriver());
    }
    public AsignarPreviasyEquivalenciasPage asignarPreviaClick() {
        asignarPreviasyEquivalenciasLink.click();
        return new AsignarPreviasyEquivalenciasPage(getDriver());
    }


}
