package tests;

import java.util.logging.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.IdealistaHomePage;
import utils.TestListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class NumberHomes {

    Logger logger = Logger.getLogger(NumberHomes.class.getName());
    IdealistaHomePage InIdealistaHomePage;
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
   //     driver.close();
   //     driver.quit();
    }

    @Test
    public void t0_search(){
        driver.get("https://amazon.es/");
   //     InIdealistaHomePage = new IdealistaHomePage(driver);
   //     InIdealistaHomePage.clickOnSearch("Madrid");
    }
}
