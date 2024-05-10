package com.germanBarrera.utils.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(css = ".navbar [role=\"button\"]")
    private ExtendedWebElement burgerBtn;

    public void clickBurgerBtn(){
        burgerBtn.click();
    }


}
