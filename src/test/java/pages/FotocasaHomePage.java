package pages;

import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IdealistaHomePage extends Base{

    public IdealistaHomePage (WebDriver driver){
        super(driver);
    }
    //Locators
    By searchBox = By.xpath("//input[@id='campoBus']");
    By select = By.xpath("//a[@href='/en/venta-viviendas/madrid-provincia/mapa']");

    //Actions

    public void clickOnSearch(String city) {
        click(searchBox);
        click(select);
    }
}
