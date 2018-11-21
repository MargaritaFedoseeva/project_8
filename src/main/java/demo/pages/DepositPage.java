package demo.pages;

import demo.annotation.FieldName;
import demo.util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class DepositPage extends BasePageObject {

    @FindBy(xpath = "//a[text()='Оставить заявку'][@class='button']")
    @FieldName(name = "Оставить заявку")
    public WebElement requestBtn;

    @FindBy(xpath = "//*[text()='Фамилия']/parent::div/input")
    @FieldName(name = "Фамилия")
    public WebElement surname;

    @FindBy(xpath = "//*[text()='Имя']/parent::div/input")
    @FieldName(name = "Имя")
    public WebElement name;

    @FindBy(xpath = "//*[text()='Отчество']/parent::div/input")
    @FieldName(name = "Отчество")
    public WebElement middleName;

    @FindBy(xpath = "//*[text()='Дата рождения']/parent::div/input")
    @FieldName(name = "Дата рождения")
    public WebElement birthDate;

    @FindBy(xpath = "//*[text()='Телефон']/parent::div/input")
    @FieldName(name = "Телефон")
    public WebElement phone;

    @FindBy(xpath = "//*[text()='Город']/parent::div/div")
    @FieldName(name = "Город")
    public WebElement city;

    @FindBy(xpath = "//*[text()='Отделение банка']/parent::div/div")
    @FieldName(name = "Отделение банка")
    public WebElement bank;

    @FindBy(xpath = "//*[contains(text(),'подтверждаю')]/..")
    @FieldName(name = "Я подтверждаю")
    public WebElement acceptChecBox;

    @FindBy(xpath = "//*[text()='Выслать код']")
    @FieldName(name = "Выслать код")
    public WebElement sentCode;

    @FindBy(xpath = "//div[@class='page-item__invalid'][.//div[text()='Осталось заполнить поля:']]//span[text()='Телефон']")
    @FieldName(name = "Заполнить поле телефона")
    public WebElement notFilledField;

    public WebElement getField(String name) throws Exception {
        Class depositPageClass = Class.forName("demo.pages.DepositPage");
        List<Field> fields = Arrays.asList(depositPageClass.getFields());
        for(Field field: fields){
            if(field.getAnnotation(FieldName.class).name().equals(name)){
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }

        }
        Assert.fail("Не объявлен элемент с наименованием" +name);
        return null;
    }

}
