package com.germanBarrera.utils.common;

import com.germanBarrera.utils.web.pages.HomePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GestionDeRolesPageBase extends AbstractPage {

    public GestionDeRolesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePage clickOnDirectorButton();
}
