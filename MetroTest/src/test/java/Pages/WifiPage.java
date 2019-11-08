package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class WifiPage extends BasePage {
    private static final int XML_REFRESH_DELAY = 1000;

    @AndroidFindBy(id = "android:id/checkbox")
    private MobileElement wifiCheckBox;

    @AndroidFindBy(uiAutomator = "text(\"WiFi settings\")")
    private MobileElement wifiSettingButton;

    @AndroidFindBy(id = "android:id/edit")
    private MobileElement wifiNameField;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;

    @AndroidFindBy(uiAutomator = "text(\"WiFi\")")
    private MobileElement wifiText;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Test']")
    private MobileElement wifiAdded;


    public WifiPage(AppiumDriver driver) {
        super(driver);
    }

    public void tickWifiCheckBox() {

        wifiCheckBox.click();
    }

    public void tapWifiSettingButton() {

        TouchAction t = new TouchAction(driver);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(wifiSettingButton))).perform();
    }

    public void clearWifiNameField() {

        wifiNameField.clear();
    }

    public void enterWifiName(String wifiName) {

        wifiNameField.sendKeys(wifiName);
    }

    public void clickOkButton() {

        okButton.click();
    }

    public boolean verifyWifiTextIsDisplayed() throws InterruptedException {

        Thread.sleep(XML_REFRESH_DELAY);
        return wifiText.isDisplayed();
    }

    public boolean verifyWifiAddedInEditBox(){

        return wifiAdded.isDisplayed();
    }


}
