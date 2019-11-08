package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class MenuPage extends BasePage {
    private static final int XML_REFRESH_DELAY = 1000;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
    private MobileElement preferenceButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accessibility']")
    private MobileElement accessibilityButton;



    public MenuPage(AppiumDriver driver){
        super(driver);
    }

    public void clickOnPreferenceButton() throws InterruptedException {

        preferenceButton.click();
        Thread.sleep(XML_REFRESH_DELAY);
    }

    public boolean verifyAccessiblityButtonIsDisplayed() {

        return accessibilityButton.isDisplayed();
    }


}
