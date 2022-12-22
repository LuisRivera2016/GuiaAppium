import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InteractsWithApps {
    public static void main (String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver =  InitializeDriver.initializeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();


        Thread.sleep(5000);
        //CERRAR LA APLICACION
        //((AndroidDriver) driver).terminateApp("io.appium.android.apis");

        //INSTALAR APLICACION
       // ((AndroidDriver) driver).
              // installApp("C:/Users/BDGSA/Documents/S7/ApiDemos-debug.apk", new AndroidInstallApplicationOptions().withReplaceEnabled());

        //SABER SI ESTA INSTALADA LA APP
        //((AndroidDriver) driver).isAppInstalled("io.appium.android.apis");

        //MANDAR A UNA APP EN SEGUNDO PLANO POR UN TIEMPO
        //((AndroidDriver) driver).runAppInBackground(Duration.ofMillis(5000));

        //ACTIVAR APLIACION (ABRIR APLICACION)
        ((AndroidDriver) driver).activateApp("com.android.settings");

        //ESTADO DE LA APLICACION
        //((AndroidDriver) driver).queryAppState("io.appium.android.apis");


    }
}
