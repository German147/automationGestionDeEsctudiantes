package com.germanBarrera.utils.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TrayectoriasMenu extends AbstractUIObject {

    public TrayectoriasMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(css = ".nav-link#liTrayectoriasCuidadas")
    private ExtendedWebElement gradoRiesgoBtn;

    @FindBy(css = ".liRiesgoxDivisionClass#liRiesgoxDivision")
    private ExtendedWebElement riesgoSecionBtn;

    @FindBy(css = ".liRiesgoxCicloEduClass#liRiesgoxCicloEdu")
    private ExtendedWebElement riesgoOrientadoBtn;

    @FindBy(css = ".liCargaIntervencionesClass#liCargaIntervenciones")
    private ExtendedWebElement cargaIntervencionesBtn;

    @FindBy(css = ".liIntervencionesClass#liIntervenciones")
    private ExtendedWebElement intervencionesBtn;

    @FindBy(css = "#canvasEstudiantesxRiesgo")
    private ExtendedWebElement gradoRiesgoDiagram;

    @FindBy(css = "#canvasEstudiantesxRiesgoxDivision")
    private ExtendedWebElement riesgoSeccionDiagram;

    @FindBy(css = "#canvasEstudiantesxRiesgoxCicloEdu")
    private ExtendedWebElement riesgoOrientacionDiagram;

    @FindBy(css = "#canvasExisteValidarRiesgo")
    private ExtendedWebElement cargaIntervencionesDiagram;

    @FindBy(css = "#canvasTiposIntervenciones")
    private ExtendedWebElement intervencionesDiagram;

    public void clickOnGradoRiesgoButton() {
        gradoRiesgoBtn.click();
    }

    public void clickOnRiesgoSeccionButton() {
        riesgoSecionBtn.click();
    }

    public void clickOnRiesgoOrientacionButton() {
        riesgoOrientadoBtn.click();
    }

    public void clickOnCargaIntervencionesButton() {
        cargaIntervencionesBtn.click();
    }

    public void clickOnIntervencionesButton() {
        intervencionesBtn.click();
    }

    public boolean isGradoRiesgoDiagramPresent() {
        return gradoRiesgoDiagram.isElementPresent();
    }

    public boolean isRiesgoSeccionDiagramPresent() {
        return riesgoSeccionDiagram.isElementPresent();
    }

    public boolean isRiesgoOrientacionDiagramPresent() {
        return riesgoOrientacionDiagram.isElementPresent();
    }

    public boolean isCargaIntervencionesDiagramPresent() {
        return cargaIntervencionesDiagram.isElementPresent();
    }

    public boolean isIntervencionesDiagramPresent() {
        return intervencionesDiagram.isElementPresent();
    }

}
