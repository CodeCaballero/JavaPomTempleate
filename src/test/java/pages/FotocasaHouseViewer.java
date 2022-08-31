package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FotocasaHouseViewer extends Base {

    public FotocasaHouseViewer(WebDriver driver) {
        super(driver);
    }
    By txtHouses = By.xpath("//h2[@class='re-SearchPage-counterTitle']");

    //Actions
    public String getHouses(){
        isElementDisplayed(txtHouses);
        return getText(txtHouses);
    }
}
