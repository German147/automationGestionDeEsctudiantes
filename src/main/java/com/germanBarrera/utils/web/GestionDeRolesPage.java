package com.germanBarrera.utils.web;

import com.germanBarrera.utils.common.GestionDeRolesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GestionDeRolesPageBase.class)
public class GestionDeRolesPage extends GestionDeRolesPageBase {

    @FindBy(css = "[onclick=\"return GuardarIdSeqRolXUsuario('1','899612', 'Director de Servicio Educativo', '-1')\"]")
    private ExtendedWebElement directorButton;

    public GestionDeRolesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage clickOnDirectorButton() {
        directorButton.click();
        HomePage drPage = new HomePage(getDriver());
        drPage.clickConfirmAlert();
        return new HomePage(getDriver());
    }
}
