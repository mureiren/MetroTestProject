package Steps;

import Base.BaseTest;
import ExtentListeners.ExtentTestManager;
import com.aventstack.extentreports.Status;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

import java.io.IOException;
import java.net.MalformedURLException;

public class BeforeActions extends BaseTest {

    @Before
    public void before(Scenario scenario) throws IOException {

        String scenarioName = scenario.getName();
        ExtentTestManager.startTest("Scenario No: " + scenarioName);
        ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenarioName);

        this.setUpAppium();
    }
}
