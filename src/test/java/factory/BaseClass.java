package factory;

import io.cucumber.java.it.Ma;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    static Properties p;
    static Logger logger;

    public static WebDriver initDriver() throws IOException {
        p = getProperties();
        String env = p.getProperty("execution_env");
        String os = p.getProperty("os");
        String browser = p.getProperty("browser");

        if (env.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            switch (os.toLowerCase()) {
                case "mac":
                    capabilities.setPlatform(Platform.MAC);
                    break;
                case "windows":
                    capabilities.setPlatform(Platform.WINDOWS);
                    break;
                case "linux":
                    capabilities.setPlatform(Platform.LINUX);
                    break;
                default:
                    System.out.println("No Matching OS found");
                    return null;
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "default":
                    System.out.println("No matching browser found");
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } else if (env.equalsIgnoreCase("local")) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    //  Adding custom download folder
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Downloads");
                    options.setExperimentalOption("prefs", prefs);
                    //  Adding chrome extensions
                    File file = new File(System.getProperty("user.dir") + "\\Extention\\uBlock.crx");
                    options.addExtensions(file);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("No matching browser found");
                    driver = null;
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProperties() throws IOException {
        FileReader property = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        p = new Properties();
        p.load(property);
        return p;
    }

    public static Logger getLogger() {
        logger = LogManager.getLogger();
        return logger;
    }

    public static String getRandomAlphabetic() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String getRandomAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public static String getRandomNumeric() {
        return RandomStringUtils.randomNumeric(10);
    }
}
