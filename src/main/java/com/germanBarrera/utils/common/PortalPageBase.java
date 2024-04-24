package com.germanBarrera.utils.common;

import com.germanBarrera.utils.web.GestionDeRolesPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PortalPageBase extends AbstractPage {

    public PortalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GestionDeRolesPage clickOnGestionDeEstudiantesButton();

    public abstract boolean isUserNamePresent();
}
