package demo.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class TransferResultPage extends BasePageObject {

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name,"demo.pages.TransferResultPage");
    }

    @Override
    public List<WebElement> getFields(String name) throws Exception {
        return null;
    }
}
