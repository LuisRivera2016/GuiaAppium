import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DiferentWaysOfDefiningElements {

    //@ANOTACIONES A NIVEL DE CLASE
    @AndroidFindBy(xpath = "//*[@text=\"Accessibility\"]")
    @FindBy(css = "ssss")
    private static WebElement myElement5;

    public DiferentWaysOfDefiningElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = initializeDriver();

        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(myElement.getText());

        //
        By myElement2 = AppiumBy.xpath("//*[@text=\"Accessibility\"]");
        System.out.println(driver.findElement(myElement2).getText());
        //ANDROID AND IOS
        By myElement3 = AppiumBy.accessibilityId("Accessibility");
        By myElement4 = AppiumBy.xpath("//*[@text=\"Accessibility\"]");
        System.out.println(driver.findElement(myElement3).getText());
        //ANOTACIONES
        DiferentWaysOfDefiningElements diferentWaysOfDefiningElements = new DiferentWaysOfDefiningElements(driver);
        System.out.println(myElement5.getText());








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
