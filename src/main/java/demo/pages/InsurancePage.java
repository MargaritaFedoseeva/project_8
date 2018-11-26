package demo.pages;

import demo.annotation.FieldName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InsurancePage extends BasePageObject {
    //Сценарий 12.11.18
    //Форма заявки на страховую программу

    @FindBy(xpath = "//a[text()='Страхование']")
    @FieldName(name = "Пункт меню страхование")
    public WebElement insuranceMenuItem;

    @FindBy(xpath = "//div[5]//a[@class='menu-block__href']")
    @FieldName(name = "В путешествие")
    public WebElement inATrip;

    @FindBy(xpath = "//div[@class='b-intro__block-buttons']//a[text()='Оставить заявку']")
    @FieldName(name = "Оставить заявку")
    public WebElement btnSubmitYourApplication;

    @FindBy(xpath = "//h1[@class='e-title e-title--h2']")
    @FieldName(name = "Текст")
    public WebElement text;

    @FindBy(xpath = "//span[@class='ui-selectmenu-text']")
    @FieldName(name = "Поле продукт")
    public WebElement productField;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    @FieldName(name = "Фамилия")
    public WebElement surnameInsurancePage;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    @FieldName(name = "Имя")
    public WebElement nameInsurancePage;

    @FindBy(xpath = "//input[@placeholder='Отчество']")
    @FieldName(name = "Отчество")
    public WebElement patronymicInsurancePage;

    @FindBy(xpath = "//input[@data-validators=' phone noempty']")
    @FieldName(name = "Номер телефона")
    public WebElement phone;

    @FindBy(xpath = "//input[@placeholder='Дата Рождения']")
    @FieldName(name = "Поле дата Рождения")
    public WebElement bateOfBirthField;

    @FindBy(xpath = "//a[@class='ui-state-default']")
    @FieldName(name = "Дата Рождения")
    public WebElement bateOfBirth;

    @FindBy(xpath = "//input[@placeholder='Электронная почта']")
    @FieldName(name = "Электронная почта")
    public WebElement email;

    @FindBy(xpath = "//input[@placeholder='Проверочный код']")
    @FieldName(name = "Проверочный код")
    public WebElement kod;

    @FindBy(xpath = "//span[@class='checkbox-block__span']")
    @FieldName(name = "Чек-бокс")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@id='btn_submit']")
    @FieldName(name = "Кнопка отправить")
    public WebElement btn_submit;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name,"demo.pages.InsurancePage");
    }
}
