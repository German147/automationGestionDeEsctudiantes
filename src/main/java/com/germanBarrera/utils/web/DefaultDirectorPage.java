package com.germanBarrera.utils.web;

import com.germanBarrera.utils.common.DefaultDirectorPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DefaultDirectorPageBase.class)
public class DefaultDirectorPage extends DefaultDirectorPageBase {

    @FindBy(css = "#btnCambiarRolAceptar")
    private ExtendedWebElement confirmButton;

    @FindBy(css = "#aTrayectoriasCuidadas")
    private ExtendedWebElement trayectoriasElement;

    public DefaultDirectorPage(WebDriver driver) {
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

}
