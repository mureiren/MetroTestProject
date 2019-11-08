package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import utilities.MyUtils;

public class PreferencePage extends BasePage {

    @AndroidFindBy(id = "android:id/switch_widget")
    private MobileElement switchToggle;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='ON']")
    private MobileElement switchToggleON;

    @AndroidFindBy(uiAutomator = "text(\"Child checkbox preference\")")
    private MobileElement childCheckBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Checkbox preference']")
    private MobileElement CheckBoxPref;


    public PreferencePage(AppiumDriver driver) {
        super(driver);
    }

    public void ToggleOnSwitchPreferenceToggleButton() throws InterruptedException {

        Point point = driver.findElementById("android:id/switch_widget").getLocation();
        TouchAction t = new TouchAction(driver);
        // toggle on
        t.tap(PointOption.point(point.x + 20, point.y + 30)).perform();
        Thread.sleep(3000);
    }

    public boolean checkToggleButtonIsON(){

       return switchToggleON.isDisplayed();
    }

    public void clickChildCheckBox() throws Exception {

        MyUtils.scrollUp(driver);
        childCheckBox.click();
    }

    public boolean verifyPrefCheckBox() {

        return CheckBoxPref.isDisplayed();
    }

    public boolean verifyChildCheckBoxIsSelected(){

        return childCheckBox.isEnabled();
    }
}
