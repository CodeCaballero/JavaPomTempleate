package tests;

import java.util.logging.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.FotocasaHomePage;
import pages.FotocasaHouseViewer;
import utils.Cons;
import static org.junit.jupiter.api.Assertions.*;
import utils.TestListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class NumberHomes {

    Logger logger = Logger.getLogger(NumberHomes.class.getName());
    FotocasaHomePage inFotocasaHomePage;
    FotocasaHouseViewer inFotocasaHouseViewer;
    static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        driver = new ChromeDriver(options);
        Dimension d = new Dimension(1920,1080);
        driver.manage().window().setSize(d);
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void t0_navigate(){
        driver.get(Cons.URL);
        inFotocasaHomePage = new FotocasaHomePage(driver);
        inFotocasaHomePage.acceptCookies();
    }

    @Test
    public void t1_search(){
        inFotocasaHomePage = new FotocasaHomePage(driver);
        inFotocasaHomePage.clickOnSearch("Madrid Provin");
        assertTrue(inFotocasaHomePage.isListCityVisible());
        inFotocasaHomePage.selectCity(1);
    }

    @Test
    public void t2_getNumberHouse(){
        inFotocasaHouseViewer = new FotocasaHouseViewer(driver);
        System.out.println(inFotocasaHouseViewer.getHouses());
    }

}
