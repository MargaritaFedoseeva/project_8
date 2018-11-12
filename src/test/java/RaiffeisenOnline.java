import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class RaiffeisenOnline extends BaseTest {

    @Test
    public void testMethod() {
        WebDriver driver = getDriver();
        driver.get("https://online.raiffeisen.ru/demo/");

        click(driver.findElement(By.xpath("//div[@class='rc-icon-svg rc-icon-svg_close']")));

        click(driver.findElement(By.xpath("//*[text()='Перевести']/..")));
        click(driver.findElement(By.xpath("//*[text()='Клиенту банка']/..")));
        selectInput(driver.findElement((By.xpath("//ruble-transfer-form-account//div[@class='rc-row__value']"))), "Мой счет в рублях");
        click(driver.findElement(By.xpath("//*[text()='По номеру телефона']")));
        fillField(driver.findElement(By.xpath("//input[contains(@class,'c-input-phone__input')]")), "79139705232");
        Assert.assertEquals("Сидоров П.И.", driver.findElement(By.xpath("//div[@class='rc-row__static-value']")).getText());
        fillField(driver.findElement(By.xpath("//ruble-transfer-form-amount//input")), "0");
        Assert.assertEquals("Сумма перевода должна быть больше 0", driver.findElement(By.xpath("//simple-error[@class='ng-star-inserted']")).getText());
        fillField(driver.findElement(By.xpath("//ruble-transfer-form-amount//input")), "20000000000");
        Assert.assertEquals("Введенная сумма превышает максимально допустимую (1 000 000,00 \u20BD)", driver.findElement(By.xpath("//simple-error[@class='ng-star-inserted']")).getText());
        fillField(driver.findElement(By.xpath("//ruble-transfer-form-amount//input")), "100");
        fillField(driver.findElement(By.xpath("//ruble-transfer-form-message//textarea")), "test");
        click(driver.findElement(By.xpath("//button[@class='rc-form__submit rc-button']")));
    }

    public void selectInput(WebElement select, String value) {
        select.click();
        click(select.findElement(By.xpath(".//*[text()='" + value + "']//..")));

    }


    @Test
    public void testMethod2() {
        WebDriver driver = getDriver();
        driver.get("https://online.raiffeisen.ru/demo/");

        click(driver.findElement(By.xpath("//div[@class='rc-icon-svg rc-icon-svg_close']")));
        click(driver.findElement(By.xpath("//*[text()='Шаблоны и автоплатежи']")));
        click(driver.findElement(By.xpath("//*[text()='Оплатить']/..")));
        click(driver.findElement(By.xpath("//*[text()='Мобильная связь']")));
        fillField(driver.findElement(By.xpath("//*[contains(@class,'ne__input')]")), "79139705232");
        selectInput(driver.findElement((By.xpath("//payment-form-card"))), "Дебетовка в рублях");
        fillField(driver.findElement(By.xpath("//payment-form-amount//input")), "100");
        click(driver.findElement(By.xpath("//form-footer-controls//label[text()='Создать шаблон']")));
        fillField(driver.findElement(By.xpath("//form-footer-template-form//div[@class=\"rc-row create-template__row-name\"]//input")), "Шаблон");
        click(driver.findElement(By.xpath("//span[text()='оплатить' and contains(@class,'star')]")));

    }


    //дз к 12.11.2018
    @Test
    public void testMethod3() {
        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");

        click(driver.findElement(By.xpath("//a[text()='Страхование']")));
        click(driver.findElement(By.xpath("//div[5]//a[@class='menu-block__href']")));
        click(driver.findElement(By.xpath("//div[@class='b-intro__block-buttons']//a[text()='Оставить заявку']")));
        Assert.assertEquals("Форма заявки на страховую программу", driver.findElement(By.xpath("//h1[@class='e-title e-title--h2']")).getText());
        Assert.assertEquals("Вояж (Комфорт/Бизнес класс/Первый класс)", driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).getText());
        fillField(driver.findElement(By.xpath("//input[@placeholder='Фамилия']")), "Сидоров");
        fillField(driver.findElement(By.xpath("//input[@placeholder='Имя']")), "Илья");
        fillField(driver.findElement(By.xpath("//input[@placeholder='Отчество']")), "Анатольевич");
        fillField(driver.findElement(By.xpath("//input[@data-validators=' phone noempty']")), "79138900099");
        fillField(driver.findElement(By.xpath("//input[@placeholder='Дата Рождения']")), "11111990");
        fillField(driver.findElement(By.xpath("//input[@placeholder='Электронная почта']")), "fmatghj@mail.ru");

        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='btn_submit']")).getAttribute("disabled"), true);

        fillField(driver.findElement(By.xpath("//input[@placeholder='Проверочный код']")), "9nk99");
        click(driver.findElement(By.xpath("//span[@class='checkbox-block__span']")));

        Assert.assertFalse(driver.findElement(By.xpath("//button[@id='btn_submit']")).getAttribute("disabled"), false);

    }
}
