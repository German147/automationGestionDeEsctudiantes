package com.germanBarrera.utils.web.components.estudiantes;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AprobarPorEximicionPage extends AbstractPage {

    @FindBy(css = ".pageTitle")
    private ExtendedWebElement infoPanel;

    public AprobarPorEximicionPage(WebDriver driver) {
        super(driver);
    }

    public  String getPageTitleAprobarPorEximicion(){
        return infoPanel.getText();
    }
}
