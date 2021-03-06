package demo.steps;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import demo.util.DriverManager;
import demo.util.TestProperties;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static Properties properties = TestProperties.getInstance().getProperties();


    @Before
    public void startScenario() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(properties.getProperty("app1.url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod() {
        DriverManager.quitDriver();
    }
}
