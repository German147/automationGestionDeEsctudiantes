package com.germanBarrera.utils.common;

import com.germanBarrera.utils.web.pages.PortalPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CidiLoginBase extends AbstractPage {

    public CidiLoginBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickIngresarButton();

    public abstract PortalPage clickLoginCidi(String user, String pass);

    public abstract void setUser(String user);

    public abstract void  setPass(String password);
}
