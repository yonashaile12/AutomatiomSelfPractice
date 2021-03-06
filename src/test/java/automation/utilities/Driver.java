package automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {}
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            if (System.getProperty("browser") != null) {
                System.out.println("Browser type was changed to: " + System.getProperty("browser"));
                browser = System.getProperty("browser");
            }
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "remote-chrome":
                    try {
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        URL gridUrl = new URL("http://3.89.67.27:4444/wd/hub");
                        driver = new RemoteWebDriver(gridUrl, desiredCapabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        URL gridUrl = new URL("http://3.82.5.142:4444/wd/hub");
                        driver = new RemoteWebDriver(gridUrl, desiredCapabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new RuntimeException("No such a browser yet!");
            }
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    public static void pageLoadTimeout() {
        Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public static void implicitlyWait() {
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
