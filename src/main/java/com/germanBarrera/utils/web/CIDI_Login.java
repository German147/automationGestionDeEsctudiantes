package com.germanBarrera.utils.web;

import com.germanBarrera.utils.common.CidiLoginBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = CidiLoginBase.class)
public class CIDI_Login extends CidiLoginBase {

    @FindBy(css = ".ingreso  .mat-button-wrapper")
    private ExtendedWebElement ingresarButton;

    @FindBy(css = "[form~=\"my-form\"]")
    private ExtendedWebElement ingresarData;

    @FindBy(css = "[formcontrolname~=\"cuil\"]")
    private ExtendedWebElement cuil;

    @FindBy(css = "[type~=\"password\"]")
    private ExtendedWebElement pass;

    public CIDI_Login(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickIngresarButton() {
        ingresarButton.click();
    }

    @Override
    public PortalPage clickLoginCidi(String user, String pass) {
        setUser(user);
        setPass(pass);
        ingresarData.click();
        return new PortalPage(getDriver());
    }

    @Override
    public void setUser(String user) {
        cuil.type(user);
    }

    @Override
    public void setPass(String password) {
        pass.type(password);
    }
}
