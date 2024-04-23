package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CIDI_Login extends AbstractPage {

    public CIDI_Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ingreso  .mat-button-wrapper")
    private ExtendedWebElement ingresarButton;

    @FindBy(css = "[form~=\"my-form\"]")
    private ExtendedWebElement ingresarData;

    @FindBy(css = "[formcontrolname~=\"cuil\"]")
    private ExtendedWebElement cuil;

    @FindBy(css = "[type~=\"password\"]")
    private ExtendedWebElement pass;

    public void clickIngresarButton() {
        ingresarButton.click();
    }

    public HomePage clickLoginCidi(String user, String pass) {

        setUser(user);
        setPass(pass);
        ingresarData.click();
        return new HomePage(getDriver());
    }
     public void setUser(String user){
        cuil.type(user);
     }
     public void  setPass(String password){
        pass.type(password);
     }
}
