import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LevantarDriverSession {
    public static void main(String[] args) throws MalformedURLException {
        //LEVANTAR DISPOSITIVO EMULADO SIN NECESIDAD DE INICIARLO
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5556");
        caps.setCapability("newCommandTimeout",300);
        caps.setCapability("avd","Pixel_4_API_30");
        caps.setCapability("avdLaunchTimeout","180000");
        String appUrl = System.getProperty("user.dir") + File.separator + "";
        // caps.setCapability(MobileCapabilityType.APP, "C:/Users/BDGSA/Documents/S7/ApiDemos-debug.apk");
        caps.setCapability("appPackage","io.appium.android.apis");
        caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");


        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AppiumDriver(url,caps);
        System.out.println("Sesion id: "+ driver.getSessionId());
    }
}
