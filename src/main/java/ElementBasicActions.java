import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ElementBasicActions {
    //CLICK, SENDKEYS, CLEAR
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = initializeDriver();
        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();
        //SWIPE SCROLL
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text");
        Thread.sleep(3000);
        driver.findElement(editText).clear();


    }

    public static AppiumDriver initializeDriver() throws MalformedURLException {
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

        return new AppiumDriver(url,caps);
    }
}
