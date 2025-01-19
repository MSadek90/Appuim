import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.BaseOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Tests {

    @Test
    public void test()  {

        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver;
        try {
            driver = new AndroidDriver(
                    // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                    new URI("http://127.0.0.1:4723").toURL(), options
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        service.stop();
    }
}