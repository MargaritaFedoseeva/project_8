package demo.pages;

import demo.annotation.FieldName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TransferPage extends BasePageObject {

    @FindBy(xpath = "//div[contains(@class,'extension-menu__name')]")
    @FieldName(name = "Виды переводов")
    public List<WebElement> transferMenu;

    @FindBy(xpath = "//ruble-transfer-form-account//div[@class='rc-row__value']")
    @FieldName(name = "Счет списания")
    public WebElement fromAccount;

    @FindBy(xpath = "//*[text()='По номеру телефона']")
    @FieldName(name = "По номеру телефона")
    public WebElement byPhoneNumber;

    @FindBy(xpath = "//input[contains(@class,'c-input-phone__input')]")
    @FieldName(name = "Телефон")
    public WebElement number;

    @FindBy(xpath = "//div[@class='rc-row__static-value']")
    @FieldName(name = "ФИО получателя")
    public WebElement fio;

    @FindBy(xpath = "//ruble-transfer-form-amount//input")
    @FieldName(name = "Сумма")
    public WebElement amount;

    @FindBy(xpath = "//ruble-transfer-form-message//textarea")
    @FieldName(name = "Сообщение")
    public WebElement message;

    @FindBy(xpath = "//button[@class='rc-form__submit rc-button']")
    @FieldName(name = "Перевести")
    public WebElement transferBtn;

    @FindBy(xpath = "//c-commission-ruble-transfer")
    @FieldName(name = "Коммиссия")
    public WebElement commission;


    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name,"demo.pages.TransferPage");
    }

    @Override
    public List<WebElement> getFields(String name) throws Exception {
        return null;
    }
}
