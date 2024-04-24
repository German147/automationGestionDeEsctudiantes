package com.germanBarrera.utils.web;

import com.germanBarrera.utils.common.DashBoardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = DashBoardPageBase.class)
public class DashBoardPage extends DashBoardPageBase {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }
}
