package com.germanBarrera.utils;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsManager extends AbstractPage {
    public WindowsManager(WebDriver driver) {
        super(driver);
    }

    WebDriver.Navigation navigate = getDriver().navigate();

    public void goToRoles() {
        getDriver().navigate().to("https://gestionestudiantes.cba.gov.ar/GestionarRoles.aspx");
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goForward() {
        navigate.forward();
    }

    public void switchTabs() {
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String windowHandle : windowHandles){
            getDriver().switchTo().window(windowHandle);
        }
    }
}
