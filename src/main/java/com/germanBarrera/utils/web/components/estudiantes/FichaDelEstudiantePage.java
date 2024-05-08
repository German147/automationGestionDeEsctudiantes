package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FichaDelEstudiantePage extends AbstractPage {
    @FindBy(css = "#MainContent_lblTitulo")
    private ExtendedWebElement tituloFicha;

    public FichaDelEstudiantePage(WebDriver driver) {
        super(driver);
    }

    public  boolean isFichaPageOpened(){
        return tituloFicha.isElementPresent();
    }
}
