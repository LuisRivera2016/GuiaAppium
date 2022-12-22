import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class InteractWithKeyboard {
    public static void main (String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = InitializeDriver.initializeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction","up",
                "percent",0.75
        ));

        driver.findElement(textFields).click();
        driver.findElement(editText).click();
        Thread.sleep(3000);

        System.out.println(((AndroidDriver)driver).isKeyboardShown());

        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.A));

        //SALIR A INICIO
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        //ABRIR CALENDARIO
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));

        Thread.sleep(3000);
        ((AndroidDriver)driver).hideKeyboard();


    }
}
