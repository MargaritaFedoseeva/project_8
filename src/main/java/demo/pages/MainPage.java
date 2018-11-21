package demo.pages;

import demo.annotation.FieldName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePageObject {

//    @FindBy(xpath = "//ul[@class='main-menu']//li")
//    public List<WebElement> mainMenu;

    @FindBy(xpath = "//a[contains(@class,'actions-menu__item')]")
    @FieldName(name = "Главное меню")
    public List<WebElement> mainMenu;


    @FindBy(xpath = "//a[contains(@class,'menu-section-link')][@href]")
    public List<WebElement> subMenu;

    @FindBy(xpath = "//*[text()='Да']")
    public WebElement acceptRegion;



    @FindBy(xpath = "//div[@class='rc-icon-svg rc-icon-svg_close']")
    @FieldName(name = "Закрыть")
    public WebElement closeBtn;



    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name,"demo.pages.MainPage");
    }
}
