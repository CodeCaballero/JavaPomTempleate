package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestListener implements AfterTestExecutionCallback,BeforeTestExecutionCallback
{
    static WebDriver driver;
    Logger logger = Logger.getLogger(TestListener.class.getName());

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception
    {
        Boolean passed = context.getExecutionException().isEmpty();
        String result = passed ? "PASSED" : "FAILED";
        Object test = context.getRequiredTestInstance();
        Field a = test.getClass().getDeclaredField("driver");
        a.setAccessible(true);
        driver = (WebDriver) a.get(test);
        if (!passed){
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String time = System.currentTimeMillis()+"";
            String filePath = "C:\\tmp\\Capturas_borrar\\homePageScreenshot"+time+".png";
            logger.info("Save file path" + filePath);
            try {
                FileUtils.copyFile(screenshotFile, new File(filePath));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        String methodname = context.getDisplayName();
        String classname = context.getRequiredTestClass().toString();
        logger.info( Cons.BLUE + "==================== STOP Test class: "+classname+" Test method: "+methodname+
                " Result: "+result+ " ===================="+ Cons.RESET);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception
    {
        String methodname = context.getDisplayName();
        String classname = context.getRequiredTestClass().toString();
        logger.info( Cons.GREEN + "==================== START Test class: "+classname+" Test method: "+methodname+
                " ====================" + Cons.RESET);
    }
}
