import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getDriver;

public class BaseTest {
    WebDriverWait wait;
    private static WebDriver driver;

//    public static WebDriver createDriver(){
//        switch ()
//    }

    @Before
    public void startScenario() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension",false);
        options.addArguments("--disable-browser-side-navigation");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void afterMethod(){
        driver.quit();
    }

    public  void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void scrollAndClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return arguments[0].scrollIntoView(false);",element);
       // wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.TAB);
    }
    public void swipeElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }



}
