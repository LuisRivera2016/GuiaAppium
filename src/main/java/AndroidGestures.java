import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;

public class AndroidGestures {
    public static void main (String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = InitializeDriver.initializeDriver();
        scrollGesture(driver);


    }

    //LONG CLICK(MANTENER PRESIONADO)
    public static void longClickGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: longClickGesture",ImmutableMap.of(
                //ElementID
                //"elementId",((RemoteWebElement) element).getId(),
                //Coordinates
                "x",217,
                "y",659,
                "duration",1000
        ));
    }

    //CLICK (PRESIONAR)
    public static void clickGesture(AppiumDriver driver){
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        driver.executeScript("mobile: clickGesture",ImmutableMap.of(
                //ElementID
                "elementId",((RemoteWebElement) element).getId()
                //Coordinates
                //"x",520,
               // "y",1859
        ));
    }

    //DRAG GESTURE (ARRASTRAR)
    public static void dragGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture",ImmutableMap.of(
                //ElementID
                "elementId",((RemoteWebElement) element).getId(),
                "endX", 649,
                "endY", 662

        ));
    }

    //ZOOM IN ZOOM OUT (ZOOM ALEJAR O ACERCAR)
    public static void zoomGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(5000);

        //ZOOM IN
        driver.executeScript("mobile: pinchOpenGesture",ImmutableMap.of(
                "left",200,
                "top",470,
                "width",600,//width - left
                "height",600, //height - top
                "percent", 0.75

        ));

        //ZOOM OUT
        /*driver.executeScript("mobile: pinchCloseGesture",ImmutableMap.of(
                "left",200,
                "top",470,
                "width",600,//width - left
                "height",600, //height - top
                "percent", 0.75

        ));*/

    }

    //SWIPE GESTURE (Deslizar)
    public static void swipeGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.
                xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

        driver.executeScript("mobile: swipeGesture",ImmutableMap.of(
                //ElementId
                 "elementId", ((RemoteWebElement) element).getId(),
                //Coordinates
                //"left",100, "top",100, "width",600,//width - left
                //"height",600, //height - top
                "direction","left",
                "percent", 0.75

        ));

       /* driver.executeScript("mobile: swipeGesture",ImmutableMap.of(
                //ElementId
               // "elementId", ((RemoteWebElement) element).getId(),
                //Coordinates
                "left",100, "top",100, "width",600,//width - left
                "height",600, //height - top
                "direction","up",
                "percent", 0.75

        ));*/

    }

    //SCROLL GESTURE (Desplazarse)
    public static void scrollGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));


        //SCROLL HASTA QUE SE PUEDA
        boolean canScrollMore = true;
        while (canScrollMore){
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture",ImmutableMap.of(
                    //ElementId
                    "elementId", ((RemoteWebElement) element).getId(),
                    //Coordinates
                    //"left",100, "top",100, "width",600, "height",600,
                    "direction","down",
                    "percent", 0.75

            ));
        }

    }
}
