package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GestionDeRolesPage extends AbstractPage {

    public GestionDeRolesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[onclick=\"return GuardarIdSeqRolXUsuario('1','899612', 'Director de Servicio Educativo', '-1')\"]")
    private ExtendedWebElement directorButton;

    public DefaultDirectorPage clickOnDirectorButton() {
        directorButton.click();
        DefaultDirectorPage drPage = new DefaultDirectorPage(getDriver());
        drPage.clickConfirmAlert();
        return new DefaultDirectorPage(getDriver());
    }
}
