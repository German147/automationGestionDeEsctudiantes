package com.germanBarrera.utils.web;

import com.germanBarrera.utils.common.WindowsManagerBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

import java.util.Set;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = WindowsManagerBase.class)
public class WindowsManager extends WindowsManagerBase {

    WebDriver.Navigation navigate = getDriver().navigate();

    public WindowsManager(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToRoles() {
        getDriver().navigate().to("https://gestionestudiantes.cba.gov.ar/GestionarRoles.aspx");
    }
    @Override
    public void refreshPage() {
        navigate.refresh();
    }
    @Override
    public void goForward() {
        navigate.forward();
    }
    @Override
    public void switchTabs() {
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String windowHandle : windowHandles){
            getDriver().switchTo().window(windowHandle);
        }
    }
}
