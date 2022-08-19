package tests;

import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import pages.IdealistaHomePage;
import utils.TestListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestNumberHomes extends SetUp{

    Logger logger = Logger.getLogger(TestNumberHomes.class.getName());
    IdealistaHomePage InIdealistaHomePage;
    static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        driver = configurationDriver();
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void t0_search(){
        driver.get("https://www.idealista.com/es/");
        InIdealistaHomePage = new IdealistaHomePage(driver);
        InIdealistaHomePage.clickOnSearch("Madrid");
    }
}
