import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingOptions {
    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options().
                setDeviceName("Pixel_4").
                setAutomationName("Uiautomator2").
                setUdid("emulator-5556").
                setApp("C:/Users/BDGSA/Documents/S7/ApiDemos-debug.apk");

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AppiumDriver(url,options);
    }
}
