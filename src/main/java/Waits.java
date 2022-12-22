import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class Waits {
    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = InitializeDriver.initializeDriver();
        //IMPLICITAMENTE
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By alertViews = AppiumBy.accessibilityId("Alert Views");
        By okeyCancel = AppiumBy.accessibilityId("Okey / Cancel");

        //EXPLICITAMENTE
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews)).click();

        //driver.findElement(alertViews).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okeyCancel)).click();
        //driver.findElement(okeyCancel).click();

        //REGRESAR VALOR IMPLICITO A VALOR ORIGINAL 30s

    }
}
