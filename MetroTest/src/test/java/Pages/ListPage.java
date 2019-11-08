package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListPage extends BasePage {

    @AndroidFindBy(uiAutomator = "text(\"5. Preferences from code\")")
    private MobileElement preferenceFromCodeButton;

    @AndroidFindBy(uiAutomator = "text(\"3. Preference dependencies\")")
    private MobileElement preferenceDependenciesButton;



    public ListPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnPreferenceFromCodeButton() {

        preferenceFromCodeButton.click();
    }

    public void clickOnPreferenceDependencyButton() {

        preferenceDependenciesButton.click();
    }


}
