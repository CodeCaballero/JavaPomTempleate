package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FotocasaHomePage extends Base{

    public FotocasaHomePage(WebDriver driver){
        super(driver);
    }
    //Locators
    By searchBox = By.xpath("//input[@placeholder='Find homes in town, neighborhood...']");
    By selectCity = By.xpath("//li[@tabindex='0']");
    By acceptCookies = By.xpath("//button[@data-testid='TcfAccept']");
    By btnSearch = By.xpath("//button[@type='submit']");


    //Actions
    public void acceptCookies(){
        click(acceptCookies);
    }
    public void clickOnSearch(String city) {
        click(searchBox);
        do {
            write(searchBox, city);
            System.out.println("YEPPPPPPPPPP");
        } while (getText(searchBox).contains(city));

    }
    public void selectCity(int i) {
        findElements(selectCity).get(i).click();
    }
    public void clickbtnSearch(){
        click(btnSearch);
    }
    public boolean isListCityVisible() {
        return isElementDisplayed(selectCity);
    }
}
