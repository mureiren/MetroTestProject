package Steps;

import Base.BaseTest;
import Pages.ListPage;
import Pages.MenuPage;
import Pages.PreferencePage;
import Pages.WifiPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class APIDemo extends BaseTest {
    private static final String WIFI_NAME = "Test";


    @Given("^user is on \"([^\"]*)\"$")
    public void userOnPage(String page) throws Throwable {
        MenuPage menuPage = new MenuPage(driver);
        ListPage listPage = new ListPage(driver);
        WifiPage wifiPage = new WifiPage(driver);
        PreferencePage preferencePage = new PreferencePage(driver);

        if (page.equals("prefpage")) {
            menuPage.clickOnPreferenceButton();
            listPage.clickOnPreferenceFromCodeButton();
            preferencePage.verifyPrefCheckBox();
        } else if (page.equals("wifipage")) {
            menuPage.clickOnPreferenceButton();
            listPage.clickOnPreferenceDependencyButton();
            Assert.assertTrue(wifiPage.verifyWifiTextIsDisplayed());
        }

    }

    @When("^user clicks \"([^\"]*)\"$")
    public void userClicksButton(String button) throws Throwable {
        MenuPage menuPage = new MenuPage(driver);
        ListPage listPage = new ListPage(driver);
        WifiPage wifiPage = new WifiPage(driver);
        PreferencePage preferencePage = new PreferencePage(driver);

        if (button.equals("togbutton")) {
            preferencePage.ToggleOnSwitchPreferenceToggleButton();
        } else if (button.equals("wifisetting")) {
            wifiPage.tickWifiCheckBox();
            wifiPage.tapWifiSettingButton();
            wifiPage.enterWifiName(WIFI_NAME);
            wifiPage.clickOkButton();
        } else if (button.equals("childcheckbox")) {
            preferencePage.clickChildCheckBox();
        }

    }

    @Then("^wifi connection is added successfully$")
    public void wifiConnectionAdded() throws Throwable {
        WifiPage wifiPage = new WifiPage(driver);
        wifiPage.tapWifiSettingButton();
        Assert.assertTrue(wifiPage.verifyWifiAddedInEditBox());

    }

    @Then("^child checkbox is marked as turned on$")
    public void bchildCheckBoxOn() throws Throwable {
        PreferencePage preferencePage = new PreferencePage(driver);
        Assert.assertTrue(preferencePage.verifyChildCheckBoxIsSelected());

    }

    @Then("^toggle button is switched on$")
    public void toggleButtonOn() throws Throwable {
        PreferencePage preferencePage = new PreferencePage(driver);
        Assert.assertTrue(preferencePage.checkToggleButtonIsON());

    }


}
