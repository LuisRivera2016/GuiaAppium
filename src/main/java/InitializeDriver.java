import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class InitializeDriver {
    public static AppiumDriver initializeDriver() throws MalformedURLException {
        //LEVANTAR DISPOSITIVO EMULADO SIN NECESIDAD DE INICIARLO
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("newCommandTimeout",300);
        caps.setCapability("avd","Pixel_4_API_30_2");
        caps.setCapability("avdLaunchTimeout","180000");
        String appUrl = System.getProperty("user.dir") + File.separator + "";
        // caps.setCapability(MobileCapabilityType.APP, "C:/Users/BDGSA/Documents/S7/ApiDemos-debug.apk");
        caps.setCapability("appPackage","io.appium.android.apis");
        caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        //CHROMEDRIVER
        //caps.setCapability("chromedriverExecutable","C:/drivers");
        //PIN DESBLOQUEO
//        caps.setCapability("unlockType","pin");
//        caps.setCapability("unlockKey","1996");
        //PATRON DESBLOQUEO
          //caps.setCapability("unlockType","pattern");
         // caps.setCapability("unlockKey","14789");

        //MAPS
         //caps.setCapability("appPackage","com.google.android.apps.maps");
         //caps.setCapability("appActivity","com.google.android.maps.MapsActivity");


        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url,caps);
        return driver;
    }
}
