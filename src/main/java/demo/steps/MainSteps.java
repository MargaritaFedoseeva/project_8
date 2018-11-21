package demo.steps;

import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import demo.pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();

    @Когда("выбран пункт меню \"(.*)\"")
    public void selectMenuItem(String itemName) {
        mainPage.selectMenuItem(mainPage.mainMenu, itemName);
    }

    @Когда("выбран подпункт меню \"(.*)\"")
    public void selectSubMenuItem(String itemName) {
        mainPage.selectMenuItem(mainPage.subMenu, itemName);
    }

    @Когда("подтверждение региона")
    public void acceptRegion() {
        mainPage.click(mainPage.acceptRegion);
    }

    @Когда("закрыто всплывающее окно")
    public void closeBunner() {
        mainPage.click(mainPage.closeBtn);
    }
}
