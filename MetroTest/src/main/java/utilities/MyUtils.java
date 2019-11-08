package utilities;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.TouchAction;
        import io.appium.java_client.touch.offset.PointOption;
        import org.openqa.selenium.Dimension;

        import static io.appium.java_client.touch.offset.PointOption.point;

public class MyUtils {

    public static void scrollUpSome(AppiumDriver driver) throws Exception {

        // The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = size.height - 1500;
        PointOption stratPoint = point(startX, startY);

        int endX = size.width / 2;
        int endY = 100;
        PointOption endPoint = point(endX, endY);

        TouchAction touchaction = new TouchAction(driver);
        touchaction.press(stratPoint);
        touchaction.waitAction();
        touchaction.moveTo(endPoint);
        touchaction.release();
        touchaction.perform();
    }

    public static void scrollUp(AppiumDriver driver) throws Exception {

        // The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = size.height - 400;
        PointOption stratPoint = point(startX, startY);

        int endX = size.width / 2;
        int endY = 200;
        PointOption endPoint = point(endX, endY);

        TouchAction touchaction = new TouchAction(driver);
        touchaction.press(stratPoint);
        touchaction.waitAction();
        touchaction.moveTo(endPoint);
        touchaction.release();
        touchaction.perform();
    }
}
