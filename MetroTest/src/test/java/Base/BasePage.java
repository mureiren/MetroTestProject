package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;

    protected final AppiumDriver driver;

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    protected boolean sendKeysToElement(String input, WebElement element, boolean appendNewLine)
            throws InterruptedException {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;
        String text;

        do {
            element.clear();
            Thread.sleep(KEYBOARD_ANIMATION_DELAY);

            if (appendNewLine) {
                element.sendKeys(input + "\n");
            } else {
                element.sendKeys(input);
            }

            Thread.sleep(XML_REFRESH_DELAY);

            text = element.getText();
//            if (text.equals("")) {
//            	text=element.getAttribute("value");
//            }

//            System.out.println(element.getAttribute("value").toString());

        } while (!text.contains(input) && ++attempts < MAX_ATTEMPTS);

        return element.getText().contains(input);

    }

    public void waitForWebElement(WebElement element, int timeout) throws Error {

        try {

            System.out.println("Waiting time will be: " + timeout + " seconds until element is located");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));

            System.out.println("Element was located on the page");

        } catch (Exception e) {
            System.out.println("Element wasn't located on the page");
        }
    }

    public void waitForListMobileElement(By elements, int timeout) throws Error {

        try {

            System.out.println("Waiting time: " + timeout + " seconds until element is located");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elements, 1));
            System.out.println("Element located on the page");

        } catch (Exception e) {
            System.out.println("Element was NOT located on the page");
        }
    }
}