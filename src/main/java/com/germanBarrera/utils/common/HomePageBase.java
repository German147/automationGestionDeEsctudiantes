package com.germanBarrera.utils.common;

import com.germanBarrera.utils.web.components.HeaderMenu;
import com.germanBarrera.utils.web.components.SeguimientoMenu;
import com.germanBarrera.utils.web.components.SideBarMenu;
import com.germanBarrera.utils.web.components.TrayectoriasMenu;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TrayectoriasMenu getTrayectoriasMenu();

    public abstract SeguimientoMenu getSeguimientoMenu();

    public abstract void clickConfirmAlert();

    public abstract boolean isTrayectoriasPresent();

    public abstract SideBarMenu getSidebarMenu();

    public abstract HeaderMenu getHeader();
}
