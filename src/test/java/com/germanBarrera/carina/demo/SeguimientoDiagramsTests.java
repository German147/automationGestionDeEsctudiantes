package com.germanBarrera.carina.demo;

import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.functionalities.ILogin;
import com.germanBarrera.utils.web.components.SeguimientoMenu;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeguimientoDiagramsTests implements IAbstractTest, ILogin {

    HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
    SeguimientoMenu seguimientoMenu = homePage.getSeguimientoMenu();

    @Test(priority = 1)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "cambioDeCicloDiagramTest", value = {"web", "functionalTesting"})
    public void cambioDeCicloDiagramTest() {
        seguimientoMenu.clickOnCambioDeCicloBtn();
        Assert.assertTrue(seguimientoMenu.isCambioCicloDiagramPresent(), "The button Cambio de ciclo was not clicked");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "iPE_E1_DiagramTest", value = {"web", "functionalTesting"})
    public void iPE_E1_DiagramTest() {
        seguimientoMenu.clickOnIPE_E1_Btn();
        Assert.assertTrue(seguimientoMenu.is_IPE_E1_DiagramPresent(), "The button IPE_E1 was not clicked");
    }

    @Test(priority = 3)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "iPE_E2_DiagramTest", value = {"web", "functionalTesting"})
    public void iPE_E2_DiagramTest() {
        seguimientoMenu.clickOnIPE_E2_Btn();
        Assert.assertTrue(seguimientoMenu.is_IPE_E2_DiagramPresent(), "The button IPE_E2 was not clicked");
    }

    @Test(priority = 4)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "pasesDiagramTest", value = {"web", "functionalTesting"})
    public void pasesDiagramTest() {
        seguimientoMenu.clickOnPasesBtn();
        Assert.assertTrue(seguimientoMenu.isPasesDiagramPresent(), "The button Pases was not clicked");
    }

    @Test(priority = 5)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "asistenciaDiariaDiagramTest", value = {"web", "functionalTesting"})
    public void asistenciaDiariaDiagramTest() {
        seguimientoMenu.clickOnInastenciaDiariaBtn();
        Assert.assertTrue(seguimientoMenu.isInasistensiasDiagramPresent(), "The button Astencia Diaria was not clicked");
    }
    @Test(priority = 6)
    @MethodOwner(owner = "barreraGerman")
    @TestLabel(name = "vinculoFamiliarDiagramTest", value = {"web", "functionalTesting"})
    public void vinculoFamiliarDiagramTest() {
        seguimientoMenu.clickOnVinculoFamiliarBtn();
        Assert.assertTrue(seguimientoMenu.isVinculoFamiliarDiagramPresent(), "The button Vinculo Familiar was not clicked");
    }



}
