package functionalities;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;
import pages.CIDI_Login;
import pages.HomePage;

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
