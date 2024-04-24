package com.germanBarrera.utils.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WindowsManagerBase extends AbstractPage {

    public WindowsManagerBase(WebDriver driver) {
        super(driver);
    }

    public abstract void goToRoles();

    public abstract void refreshPage();

    public abstract void goForward();

    public abstract void switchTabs();
}
