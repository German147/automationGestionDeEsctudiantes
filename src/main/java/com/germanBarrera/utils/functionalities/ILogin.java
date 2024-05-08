package com.germanBarrera.utils.functionalities;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.germanBarrera.utils.web.pages.CIDI_Login;
import com.germanBarrera.utils.web.pages.PortalPage;

public interface ILogin extends IAbstractTest {

    default PortalPage login(String user, String pass) {
        CIDI_Login cidiLogin = new CIDI_Login(getDriver());
        PortalPage homepage = new PortalPage(getDriver());
        homepage.open();
        cidiLogin.clickIngresarButton();
        cidiLogin.clickLoginCidi(user, pass);
        return new PortalPage(getDriver());
    }
}
