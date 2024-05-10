package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ActualizarPadronPage extends AbstractPage {

    @FindBy(css = ".pageTitle")
    private ExtendedWebElement title;

    public ActualizarPadronPage(WebDriver driver) {
        super(driver);
    }

    public String getTitlePage(){
        return title.getText();
    }

}
