package demo.pages;

import demo.annotation.FieldName;
import demo.util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static demo.util.DriverManager.getDriver;

public abstract class BasePageObject {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);

    public BasePageObject() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public void fillField(String name, String value) throws Exception {
        WebElement element = getField(name);
        fillField(element, value);

    }

    public void click(String name) throws Exception {
        WebElement element = getField(name);
        click(element);
    }

    public void scroll(String name) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement element = getField(name);
        js.executeScript("return arguments[0].scrollIntoView(false);", element);
    }

    public void click(int num, String name) throws Exception {
        List<WebElement> elements = getFields(name);
        elements.get(num - 1).click();
    }

    public void click(String name, String value) throws Exception {
        List<WebElement> elements = getFields(name);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(value)) {
                click(element);
                break;
            }

        }
    }

    public abstract WebElement getField(String name) throws Exception;

    public abstract List<WebElement> getFields(String name) throws Exception;

    public WebElement getField(String name, String className) throws Exception {
        Class example = Class.forName(className);
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields) {
            if (field.getAnnotation(FieldName.class).name().equals(name)) {
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public List<WebElement> getFields(String name, String className) throws Exception {
        Class example = Class.forName(className);
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields) {
            if (field.getAnnotation(FieldName.class).name().equals(name)) {
                return DriverManager.getDriver().findElements(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public void fillField(WebElement field, String value) {
        Actions action = new Actions(DriverManager.getDriver());
//        action.sendKeys(field,Keys.BACK_SPACE).build().perform();
        action.click(field).build().perform();
        action.sendKeys(field, value).build().perform();
//        action.click(field).sendKeys(value).build().perform();
//        field.sendKeys(value);
    }


    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void selectMenuItem(List<WebElement> menuItems, String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }


    public void selectInput(WebElement element, String value) {
        element.click();
        element.findElement(By.xpath(".//*[contains(text(),'" + value + "')]")).click();
    }

    public String getError(String name) throws Exception {
        WebElement element = getField(name);
        return element.findElement(By.xpath("./../following-sibling::control-errors")).getText();
    }
}
