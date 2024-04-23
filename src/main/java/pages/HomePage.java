package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Gestión Estudiantes']")
    private ExtendedWebElement gestionEstudiantesIcon;

    @FindBy(css = ".mat-tooltip-trigger .user-nombre")
    private ExtendedWebElement username;



    public GestionDeRolesPage clickOnGestionDeEstudiantesButton() {
        gestionEstudiantesIcon.click();
        return new GestionDeRolesPage(getDriver());
    }

    public boolean isUserNamePresent(){
        return username.isElementPresent();
    }

}
