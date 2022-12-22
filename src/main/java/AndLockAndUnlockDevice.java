import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndLockAndUnlockDevice {
    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = InitializeDriver.initializeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //BLOQUEAR POR UN TIEMPO
        //((AndroidDriver)driver).lockDevice(Duration.ofSeconds(5));

        //BLOQUEAR
        ((AndroidDriver)driver).lockDevice();

        //SABER SI ESTA BLOQUEADO
        System.out.println(((AndroidDriver) driver).isDeviceLocked());

        //DESBLOQUEAR
        ((AndroidDriver)driver).unlockDevice();


    }
}
