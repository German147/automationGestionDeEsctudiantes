package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AsignarPreviasyEquivalenciasPage extends AbstractPage {

    @FindBy(css = "#MainContent_divSeleccionEstudiantes")
    private ExtendedWebElement mainContent;

    public AsignarPreviasyEquivalenciasPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTextPresent(){
        return mainContent.isElementPresent();
    }

}
