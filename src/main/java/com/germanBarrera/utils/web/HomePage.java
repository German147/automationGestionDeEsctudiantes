package com.germanBarrera.utils.web;

import com.germanBarrera.utils.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//*[text()='Gestión Estudiantes']")
    private ExtendedWebElement gestionEstudiantesIcon;

    @FindBy(css = ".mat-tooltip-trigger .user-nombre")
    private ExtendedWebElement username;

    public HomePage(WebDriver driver) {
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
