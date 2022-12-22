import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class WebViewInspectUsingAI {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = InitializeDriver.initializeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Views");

        driver.findElement(views).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction","up",
                "percent",0.75
        ));

        driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View[1]")).getText());


    }

}
