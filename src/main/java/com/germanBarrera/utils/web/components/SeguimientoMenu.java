package com.germanBarrera.utils.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SeguimientoMenu extends AbstractUIObject {

    @FindBy(css = ".nav-link#liCicloRT ")
    private ExtendedWebElement cambioDeCicloBtn;

    @FindBy(css = ".nav #liIpeRT   ")
    private ExtendedWebElement IPE_E1_Btn;

    @FindBy(css = ".nav #liIpe2RT")
    private ExtendedWebElement IPE_E2_Btn;

    @FindBy(css = ".nav #liPasesRT")
    private ExtendedWebElement pasesBtn;

    @FindBy(css = ".nav #liInasistenciaRT")
    private ExtendedWebElement inasistenciDiariaBtn;

    @FindBy(css = ".nav #liVinculoFamiliarRT")
    private ExtendedWebElement vinculoFamiliarBtn;

    @FindBy(css = ".nav #alertasT")
    private ExtendedWebElement seguimientoDeCargaTextBtn;

    @FindBy(css = "#canvasCiclo")
    private ExtendedWebElement cambioCicloDiagram;

    @FindBy(css = "#canvasIPE1")
    private ExtendedWebElement IPE_E1_Diagram;

    @FindBy(css = "#canvasIPE2")
    private ExtendedWebElement IPE_E2_Diagram;

    @FindBy(css = "#canvasPases")
    private ExtendedWebElement pasesDiagram;

    @FindBy(css = "#canvasInasistencias")
    private ExtendedWebElement inasistensiasDiagram;

    @FindBy(css = "#canvasVinculoFamiliar")
    private ExtendedWebElement vinculoFamiliarDiagram;

    public SeguimientoMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickOnCambioDeCicloBtn() {
        cambioDeCicloBtn.click();
    }

    public void clickOnIPE_E1_Btn() {
        IPE_E1_Btn.click();
    }

    public void clickOnIPE_E2_Btn() {
        IPE_E2_Btn.click();
    }

    public void clickOnPasesBtn() {
        pasesBtn.click();
    }

    public void clickOnInastenciaDiariaBtn() {
        inasistenciDiariaBtn.click();
    }

    public void clickOnVinculoFamiliarBtn() {
        vinculoFamiliarBtn.click();
    }

    public void clickOnSeguimientoDeCargaBtn() {
        seguimientoDeCargaTextBtn.click();
    }

    public boolean isCambioCicloDiagramPresent() {
        return cambioCicloDiagram.isElementPresent();
    }

    public boolean is_IPE_E1_DiagramPresent() {
        return IPE_E1_Diagram.isElementPresent();
    }

    public boolean is_IPE_E2_DiagramPresent() {
        return IPE_E2_Diagram.isElementPresent();
    }

    public boolean isPasesDiagramPresent() {
        return pasesDiagram.isElementPresent();
    }

    public boolean isInasistensiasDiagramPresent() {
        return inasistensiasDiagram.isElementPresent();
    }

    public boolean isVinculoFamiliarDiagramPresent() {
        return vinculoFamiliarDiagram.isElementPresent();
    }
}
