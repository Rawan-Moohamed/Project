import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.example.PostAnAdPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static AndroidDriver driver;

    PostAnAdTest postAnAdTest;
    PostAnAdPage postAnAdPage;

    @BeforeMethod
    public void Setup() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "OJIBMN55IF6XEYNZ");
        capabilities.setCapability("AndroidVersion", "13");
        capabilities.setCapability("appPackage", "com.forsale.forsale");
        capabilities.setCapability("appActivity", "com.forsale.app.features.maincontainer.MainContainerActivity");
        capabilities.setCapability("skipDeviceInitialization", true);
        capabilities.setCapability("ignoreUnimportantViews", true);
        capabilities.setCapability("skipUnlock", "true");
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        postAnAdPage = new PostAnAdPage(driver);
        postAnAdTest = new PostAnAdTest();
    }


    @AfterTest
    public void tearDown(){
        if (null != driver)
            driver.quit();
    }
}
