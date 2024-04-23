package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DefaultDirectorPage extends AbstractPage {
    public DefaultDirectorPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#btnCambiarRolAceptar")
    private ExtendedWebElement confirmButton;

    @FindBy(css="#aTrayectoriasCuidadas")
    private ExtendedWebElement trayectoriasElement;

    public void clickConfirmAlert(){
        confirmButton.click();
    }

    public boolean isTrayectoriasPresent() {
       return trayectoriasElement.isElementPresent();
    }


}
