package com.germanBarrera.utils.web.pages;

import com.germanBarrera.utils.common.HomePageBase;
import com.germanBarrera.utils.web.components.HeaderMenu;
import com.germanBarrera.utils.web.components.SeguimientoMenu;
import com.germanBarrera.utils.web.components.SideBarMenu;
import com.germanBarrera.utils.web.components.TrayectoriasMenu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(css = "#btnCambiarRolAceptar")
    private ExtendedWebElement confirmButton;

    @FindBy(css = "#aTrayectoriasCuidadas")
    private ExtendedWebElement trayectoriasElement;

    @FindBy(css = "#MainContent_panelTrayectoriasCuidadas")
    private TrayectoriasMenu trayectoriasMenu;

    @FindBy(css = "#MainContent_panelAlertas")
    private SeguimientoMenu seguimientoMenu;

    @FindBy(css = "#ulAccionesDirectorMenu")
    private SideBarMenu menuOptions;

    @FindBy(css = ".navbar-static-top")
    private HeaderMenu header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickConfirmAlert() {
        confirmButton.click();
    }

    @Override
    public boolean isTrayectoriasPresent() {
        return trayectoriasElement.isElementPresent();
    }

    @Override
    public SideBarMenu getSidebarMenu() {
        return menuOptions;
    }

    @Override
    public HeaderMenu getHeader() {
        return header;
    }

    @Override
    public TrayectoriasMenu getTrayectoriasMenu() {
        return trayectoriasMenu;
    }

    @Override
    public SeguimientoMenu getSeguimientoMenu() {
        return seguimientoMenu;
    }

}
