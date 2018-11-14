import demo.pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DepositTest extends BaseTest {
    @Test
    public  void testDeposit(){

        MainPage mainPage = new MainPage();
        mainPage.acceptRegion();
        mainPage.selectMenuItem("Вклады");
        mainPage.selectSubMenuItem("Накопительные счета");

//        HashMap<String,String> testData = new HashMap<String, String>();
////        testData();
//
//        WebDriver driver = getDriver();
//        driver.get("https://www.raiffeisen.ru/");
//        acceptRegion();
//
//        click(driver.findElement(By.xpath("//a[@class='main-menu__link' and text()='Вклады']")));
//        click(driver.findElement(By.xpath("//a[text()='Накопительные счета']")));
//        click(driver.findElement(By.xpath("//a[text()='Накопительные счета']")));
    }
     private void acceptRegion(){
        click(getDriver().findElement(By.xpath("//*[text()='Да']")));
     }
}
