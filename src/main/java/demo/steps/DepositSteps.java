package demo.steps;

import demo.pages.DepositPage;
import demo.util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DepositSteps {
    DepositPage depositPage = new DepositPage();

    public void fillField(String name, String value) throws Exception {
        WebElement element = depositPage.getField(name);
        depositPage.fillField(element, value);
    }

    public void click(String name) throws Exception {
        WebElement element = depositPage.getField(name);
        depositPage.click(element);
    }
    public void checkField(String name,String value) throws Exception {
        WebElement element = depositPage.getField(name);
        Assert.assertEquals(value,element.getAttribute("value"));
    }

    public void checkFieldIsEnabled(String name) throws Exception {
        WebElement element = depositPage.getField(name);
        Assert.assertTrue(String.format("Поле [%s] не доступно",name),element.isEnabled());
    }

    public void selectInput(String field,String value) throws Exception {
        WebElement element = depositPage.getField(field);
        depositPage.selectInput(element,value);
    }

    public void checkFieldIsPresent(String name) throws Exception {
        try{
            DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            depositPage.getField(name).isDisplayed();
        }catch (NoSuchMethodException e){
            Assert.fail(String.format("Отсутствует элемент [%s]",name));

        }finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        }

    }
}
