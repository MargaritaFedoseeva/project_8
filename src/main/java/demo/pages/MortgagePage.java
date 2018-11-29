package demo.pages;

import demo.annotation.FieldName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MortgagePage extends BasePageObject {

    @FindBy(xpath = "//a[contains(@href,'/retail/mortgageloans/')]")
    @FieldName(name = "Ссылки раздела Ипотека")
    public WebElement mortgageSectionLinks;

    @FindBy(xpath = "//h1[contains(@class,'e-title')]")
    @FieldName(name = "Заголовок страницы")
    public WebElement pageTitle;

    @FindBy(xpath = "//span[@id='form_city-button']//span[@class='ui-selectmenu-text']")
    @FieldName(name = "Город")
    public WebElement city;


    @FindBy(xpath = "//span[@id='form_program-button']//span[@class='ui-selectmenu-text']")
    @FieldName(name = "Вид ипотечной программы")
    public WebElement typeOfMortgageProgram;

    @FindBy(xpath = "//li[@class='ui-menu-item']//div")
    @FieldName(name = "Значение из списка")
    public WebElement valueList;

    @FindBy(xpath = "//span[@id='form_documents-button']//span[2]")
    @FieldName(name = "Уровень дохода подтверждаю")
    public WebElement confirmIncomeLevel;

    @FindBy(xpath = "//span[@id='form_category-button']//span[2]")
    @FieldName(name = "Являюсь")
    public WebElement am;

    @FindBy(xpath = "//span[@class='checkbox-block__span']")
    @FieldName(name = "Чек-бокс - Знаю свою ипотечную программу")
    public WebElement checkBox;

    @FindBy(xpath = "//input[@id='form_credit_amount']")
    @FieldName(name = "В банке возьму")
    public WebElement takeInTheBank;

    @FindBy(xpath = "//input[@id='form_initial']")
    @FieldName(name = "Первоначальный взнос")
    public WebElement anInitialFee;

    @FindBy(xpath = "//input[@id='form_period']")
    @FieldName(name = "Срок кредита")
    public WebElement creditTerm;

    @FindBy(xpath = "//input[@class='button-invert']")
    @FieldName(name = "Кнопка - Рассчитать")
    public WebElement btnToCalculate;

    @FindBy(xpath = "//span[@class='monthly-payment']")
    @FieldName(name = "Ежемесячный платеж")
    public WebElement monthlyPayment;

    @FindBy(xpath = "//div[contains(@class,'total-payment')]")
    @FieldName(name = "Общая сумма выплат")
    public WebElement totalPayment;

    @FindBy(xpath = "//div[contains(@class,'percent-sum')]")
    @FieldName(name = "Cумма выплат по процентам")
    public WebElement percentSum;

    @FindBy(xpath = "//div[contains(@class,'interest-rate')]")
    @FieldName(name = "Процентная ставка")
    public WebElement interestRate;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "demo.pages.MortgagePage");
    }

    @Override
    public List<WebElement> getFields(String name) throws Exception {
        return getFields(name, "demo.pages.MortgagePage");
    }
}
