package com.germanBarrera.utils.web;

import com.germanBarrera.utils.common.DefaultDirectorPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DefaultDirectorPageBase.class)
public class DefaultDirectorPage extends DefaultDirectorPageBase {

    @FindBy(css = "#btnCambiarRolAceptar")
    private ExtendedWebElement confirmButton;

    @FindBy(css = "#aTrayectoriasCuidadas")
    private ExtendedWebElement trayectoriasElement;

    @FindBy(css = ".nav-link#liTrayectoriasCuidadas  ")
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

    public DefaultDirectorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickConfirmAlert() {
        confirmButton.click();
    }

    @Override
    public boolean isTrayectoriasPresent() {
        return trayectoriasElement.isElementPresent();
    }

    @Override
    public void clickOnGradoRiesgoButton() {
        gradoRiesgoBtn.click();
    }

    @Override
    public void clickOnRiesgoSeccionButton() {
        riesgoSecionBtn.click();
    }

    @Override
    public void clickOnRiesgoOrientacionButton() {
        riesgoOrientadoBtn.click();
    }

    @Override
    public void clickOnCargaIntervencionesButton() {
        cargaIntervencionesBtn.click();
    }

    @Override
    public void clickOnIntervencionesButton() {
        intervencionesBtn.click();
    }

    @Override
    public boolean isGradoRiesgoDiagramPresent() {
        return gradoRiesgoDiagram.isElementPresent();
    }

    @Override
    public boolean isRiesgoSeccionDiagramPresent() {
        return riesgoSeccionDiagram.isElementPresent();
    }

    @Override
    public boolean isRiesgoOrientacionDiagramPresent() {
        return riesgoOrientacionDiagram.isElementPresent();
    }

    @Override
    public boolean isCargaIntervencionesDiagramPresent() {
        return cargaIntervencionesDiagram.isElementPresent();
    }

    @Override
    public boolean isIntervencionesDiagramPresent() {
        return intervencionesDiagram.isElementPresent();
    }

}
