package demo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositListPage extends BasePageObject{
    @FindBy(xpath = "//div[@class='b-card__content']")
    public List<WebElement> depositCollection;



}
