package demo.pages;

import demo.annotation.FieldName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServicePage extends BasePageObject {

    @FindBy(xpath = "//a[contains(@href,'/retail/remote_service/')]")
    @FieldName(name = "Сервисы самообслуживания")
    public WebElement selfService;

    @FindBy(xpath = "//h1[contains(@class,'e-title')]")
    @FieldName(name = "Заголовок страницы")
    public WebElement pageTitle;

    @FindBy(xpath = "//input[@placeholder='Номер карты отправителя']")
    @FieldName(name = "Карта отправителя")
    public WebElement senderCard;

    @FindBy(xpath = "//input[@placeholder='Номер карты получателя']")
    @FieldName(name = "Карта получателя")
    public WebElement recipientCard;

    @FindBy(xpath = "//input[@autocomplete='cc-exp-month']")
    @FieldName(name = "Срок действия - Месяц")
    public WebElement validityMonth;

    @FindBy(xpath = "//input[@autocomplete='cc-exp-year']")
    @FieldName(name = "Срок действия - Год")
    public WebElement validityYear;

    @FindBy(xpath = "//input[@autocomplete='cc-csc']")
    @FieldName(name = "CVC")
    public WebElement cvc;

    @FindBy(xpath = "//input[contains(@placeholder,'Сумма перевода')]")
    @FieldName(name = "Сумма")
    public WebElement sum;

    @FindBy(xpath = "//div[@class='c2c__error']")
    @FieldName(name = "Сообщение об ошибке")
    public WebElement errorMessage;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "demo.pages.ServicePage");
    }

    @Override
    public List<WebElement> getFields(String name) throws Exception {
        return getFields(name, "demo.pages.ServicePage");
    }
}
