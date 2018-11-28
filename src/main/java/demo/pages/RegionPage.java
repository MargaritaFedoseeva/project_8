package demo.pages;

import demo.annotation.FieldName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegionPage extends BasePageObject {

    @FindBy(xpath = "//a[contains(@class,'region-active')]")
    @FieldName(name = "Выбор региона")
    public WebElement btnRegionSelection;

    @FindBy(xpath = "//a[contains(@class,'region-list__city')]")
    @FieldName(name = "Регион")
    public WebElement region;

    @FindBy(xpath = "//div[@class='footer__top cols cols3']")
    @FieldName(name = "Footer")
    public WebElement footer;

    @FindBy(xpath = "//div[@class='footer__top cols cols3']//li//a")
    @FieldName(name = "Ссылки в Footer")
    public WebElement footerLinks;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name,"demo.pages.RegionPage");
    }

    @Override
    public List<WebElement> getFields(String name) throws Exception {
        return getFields(name,"demo.pages.RegionPage");
    }

}
