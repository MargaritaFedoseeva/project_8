package demo.pages;

import org.openqa.selenium.WebElement;

public class TransferResultPage extends BasePageObject {

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name,"demo.pages.TransferResultPage");
    }
}
