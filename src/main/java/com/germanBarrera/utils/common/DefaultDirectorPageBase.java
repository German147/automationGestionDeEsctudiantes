package com.germanBarrera.utils.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DefaultDirectorPageBase extends AbstractPage {

    public DefaultDirectorPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void clickConfirmAlert();

    public abstract boolean isTrayectoriasPresent();

    public abstract void clickOnGradoRiesgoButton();

    public abstract void clickOnRiesgoSeccionButton();

    public abstract void clickOnRiesgoOrientacionButton();

    public abstract void clickOnCargaIntervencionesButton();

    public abstract void clickOnIntervencionesButton();

    public abstract boolean isGradoRiesgoDiagramPresent();

    public abstract boolean isRiesgoSeccionDiagramPresent();

    public abstract boolean isRiesgoOrientacionDiagramPresent();

    public abstract boolean isCargaIntervencionesDiagramPresent();

    public abstract boolean isIntervencionesDiagramPresent();


}
