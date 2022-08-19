package tests;
import java.util.logging.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.awt.Toolkit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {
    static WebDriver driver;
    static Logger logger = Logger.getLogger(SetUp.class.getName());

    public static WebDriver configurationDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        Dimension d = new Dimension(1920,1080);
        driver.manage().window().setSize(d);
        logger.info("ScreenSize " + Toolkit.getDefaultToolkit().getScreenSize() +" Selenium" +
                driver.manage().window().getSize().toString());
        return driver;
    }
}
