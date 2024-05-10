package com.germanBarrera.utils.web.pages;

import com.germanBarrera.utils.common.PortalPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = PortalPageBase.class)
public class PortalPage extends PortalPageBase {

    @FindBy(xpath = "//*[text()='Gestión Estudiantes']")
    private ExtendedWebElement gestionEstudiantesIcon;

    @FindBy(css = ".mat-tooltip-trigger .user-nombre")
    private ExtendedWebElement username;

    @FindBy(css = "[onclick=\"return GuardarIdSeqRolXUsuario('1','899612', 'Director de Servicio Educativo', '-1')\"]")
    private WebElement directorButton;

    public PortalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GestionDeRolesPage clickOnGestionDeEstudiantesButton() {
        gestionEstudiantesIcon.click();
        return new GestionDeRolesPage(getDriver());
    }

    @Override
    public boolean isUserNamePresent() {
        return username.isElementPresent();
    }

}
