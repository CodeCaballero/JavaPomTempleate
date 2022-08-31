package pages;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestListener;

public class Base {

    WebDriverWait wait;
    protected WebDriver driver;
    public static final String PURPLE = "\033[0;35m";
    public static final String RESET = "\033[0m";  // Text Reset
    //Logger logger = Logger.getLogger(Base.class.getName());
    java.util.logging.Logger log = Logger.getLogger(TestListener.class.getName());

    public Base (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public WebElement findElement(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return  driver.findElement(locator).getText();
    }

    public String getTextWithoutException(By locator) {
        try{
            return driver.findElement(locator).getText();
        }catch(Exception e){
            return "";
        }
    }

    public String getClass (By locator){
        return driver.findElement(locator).getAttribute("class");
    }

    public void deleteTextArea(By locator){
        click(locator);
        driver.findElement(locator).clear();
    }

    public void clearElement(By locator){

    }

    public void write(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(text);
    }

    public void click (By locator){
        String methodname = StackWalker.getInstance().walk(s -> s.skip(1).findFirst()).get().getMethodName();
        log.info(PURPLE + methodname +" -> " + locator.toString() + " -> " + getText(locator).toString() + RESET);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public boolean isDisplayed (By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            //TODO: handle exception
            return false;
        }
    }

    public void visit (String url){
        driver.get(url);
    }

    public static boolean containsArray(String input, String[] words) {
        return Arrays.stream(words).allMatch(input::contains);
    }

    public void waitA(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickSelector(By locator, String seleccion){
        log.info(locator.toString());
        click(locator);
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath("//option[. = '"+seleccion+"']")).click();
        dropdown.findElement(By.xpath("//option[. = '"+seleccion+"']")).click();
    }

    public void refresh_(){
        log.info("Refresh page");
        driver.navigate().refresh();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement is = driver.findElement(locator);
            return is.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                 | org.openqa.selenium.StaleElementReferenceException
                 | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void _deteleCookies(){
        log.info("Delete Cookies");
        driver.manage().deleteAllCookies();
    }

    public void waitFinishLoad(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        log.info("Wait Load");
        wait.until(d -> (boolean)javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }

    public void waitElementIsGone(By locator){
        log.info("Wait element" + locator.getClass().getName().toString());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }
}
