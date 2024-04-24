package com.germanBarrera.utils.functionalities;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.germanBarrera.utils.web.CIDI_Login;
import com.germanBarrera.utils.web.HomePage;

public interface ILogin extends IAbstractTest {

    default HomePage login(String user, String pass) {
        CIDI_Login cidiLogin = new CIDI_Login(getDriver());
        HomePage homepage = new HomePage(getDriver());
        homepage.open();
        cidiLogin.clickIngresarButton();
        cidiLogin.clickLoginCidi(user, pass);
        return new HomePage(getDriver());
    }
}
