package demo.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import demo.pages.BasePageObject;
import demo.pages.TransferPage;
import demo.pages.TransferResultPage;
import demo.util.DriverManager;

import java.util.concurrent.TimeUnit;

public class ScenarioSteps {
    TransferPage transferPage = new TransferPage();
    static String currentPageName;

    @When("загружена страница \"(.*)\"")
    public void stepPageLoaded(String pageName){
        currentPageName = pageName;
    }

    @When("выбран тип перевода \"(.*)\"")
    public void selectMenuItem(String itemName){
        transferPage.selectMenuItem(transferPage.transferMenu, itemName);
    }


    @When("поле \"(.*)\" заполняется значением \"(.*)\"")
    public void fillField(String name, String value) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        page.fillField(name, value);
    }

    @When("значение поля \"(.*)\" равно \"(.*)\"")
    public void checkField(String name, String value) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        Assert.assertEquals(value, page.getField(name).getText());
    }

    @When("элемент \"(.*)\" не активен")
    public void disabled(String name) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        Assert.assertTrue( page.getField(name).getAttribute("disabled"), true);
    }

    @When("элемент \"(.*)\" активен")
    public void notDisabled(String name) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        Assert.assertFalse( page.getField(name).getAttribute("disabled"), false);
    }

    @When("значение ошибки в поле \"(.*)\" равно \"(.*)\"")
    public void checkErrorField(String name, String value) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        Assert.assertEquals(value, page.getError(name));
    }

    @When("значение не редактируемого поля \"(.*)\" равно \"(.*)\"")
    public void checkStaticTextField(String name, String value) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        Assert.assertEquals(value, page.getField(name).getText());
    }

    @When("поле \"(.*)\" доступно")
    public void checkIsEnabled(String name) throws Exception {
        Assert.assertTrue("Кнопка - "+ name +" не активна", transferPage.getField(name).isEnabled());
    }

    @When("выполнено нажатие на \"(.*)\"")
    public void click(String name) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        page.click(name);
    }

    @When("выполнено нажатие на (\\d+)-й елемент \"(.*)\"")
    public void clickIem(int num, String name) throws Exception {
        Class example = Class.forName("demo.pages." + currentPageName);
        BasePageObject page = (BasePageObject) example.newInstance();
        page.click(num,name);
    }

    @When("выпадающий список \"(.*)\" заполняется значением \"(.*)\"")
    public void selectInput(String field, String value) throws Exception {
        WebElement element = transferPage.getField(field);
        transferPage.selectInput(element, value);
    }

    @When("поле \"(.*)\" присутствует")
    public void checkFieldIsPresent(String name)throws Exception{
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Assert.assertTrue(String.format("Элемент [%s] не видимый", name), transferPage.getField(name).isDisplayed());
        }catch (NoSuchElementException e){
            Assert.fail(String.format("Отсутствует элемент [%s]", name));
        }finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

    }

    @When("заполняются поля:")
    public void fillFields(DataTable fields) throws Exception {
        fields.asMap(String.class, String.class).forEach(
                (k, v) -> {
                    try {
                        fillField(k, v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @When("поля заполнены значениями:")
    public void checkfillFields(DataTable fields) throws Exception {
        fields.asMap(String.class, String.class).forEach(
                (k, v) -> {
                    try {
                        checkField(k, v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }


}
