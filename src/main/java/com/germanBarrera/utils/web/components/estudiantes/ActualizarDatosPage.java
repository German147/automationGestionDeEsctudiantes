package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ActualizarDatosPage extends AbstractPage {

    @FindBy(css = ".pageTitle")
    private ExtendedWebElement pageTitle;

    public ActualizarDatosPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

}
