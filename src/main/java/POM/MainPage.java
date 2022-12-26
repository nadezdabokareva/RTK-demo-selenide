package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    //описать кнопку и обратиться к ней можно тремя способами

    //по xpath (путь сделан с помощью расширения для браузера ChroPath
    @FindBy(how = How.XPATH, using = "sp-l-0-2")
    private SelenideElement enterToAccountButton;

    //c помощью названия класса элемента (взят из кода страницы)
    @FindBy(how = How.CLASS_NAME, using = "rt-button-small")
    private SelenideElement continueButton;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Интернет')]")
    private SelenideElement internetButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Помощь')]")
    private SelenideElement helpButton;

    public MainPage clickToInternetButton() {
        internetButton.click();
        return this;
    }

    public MainPage clickToHomeInternetButton() {
        $(byText("Домашний интернет")).shouldBe(Condition.visible).click();
        return this;
    }

    public MainPage clickToContinueButton() {
        continueButton.click();
        return this;
    }

    public MainPage goToTheEnterAccountButton() {
        $(byText("Войти")).click();
        return this;
    }

    public MainPage goToHelp() {
        $(byText("Отправьте заявку на подключение в г. Воронеж")).scrollTo().shouldBe(Condition.visible);
        helpButton.scrollTo();
        helpButton.click();
        return this;
    }

}