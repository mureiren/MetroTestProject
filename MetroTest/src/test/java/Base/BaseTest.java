package Base;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver = null;


    @BeforeSuite
    public void beforeSuite() throws IOException {
        this.setUpAppium();
    }

    public void setUpAppium() throws IOException {

        String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        File f = new File("src");
        File fs = new File(f, (String) prop.get("App"));


        DesiredCapabilities capabilities = new DesiredCapabilities();
        String dv = (String) prop.get("device");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dv);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        capabilities.setCapability("automationName", "UiAutomator2");

        driver = new AndroidDriver<MobileElement>(url, capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDownAppium() {
        if (driver != null) {
            driver.quit();
        }

    }
}