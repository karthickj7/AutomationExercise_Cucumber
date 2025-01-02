package stepDefinitions;

import factory.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;


public class Hooks {
    WebDriver driver;
    Properties p;

    @Before
    public void setUp() throws IOException {
        driver = BaseClass.initDriver();
        p = BaseClass.getProperties();

        driver.get(p.getProperty("baseUrl"));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] ss = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(ss, "image/png", scenario.getName());
        }

    }
}
