package com.germanBarrera.utils.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DefaultDirectorPageBase extends AbstractPage {

    public DefaultDirectorPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void clickConfirmAlert();

    public abstract boolean isTrayectoriasPresent();

}
