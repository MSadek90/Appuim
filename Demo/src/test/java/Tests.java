import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
                    new URI("http://192.168.100.8").toURL(), options
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        service.stop();
    }
}