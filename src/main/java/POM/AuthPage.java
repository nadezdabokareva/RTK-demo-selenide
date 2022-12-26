package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthPage {

    @FindBy(how = How.XPATH, using = "//button[@id='standard_auth_btn']")
    private SelenideElement enterWithPasswordButton;
    @FindBy(how = How.CLASS_NAME, using = "card-container__title")
    private SelenideElement authPageTittle;
    @FindBy(how = How.CLASS_NAME, using = "rt-input-container")
    private SelenideElement errorText;
    @FindBy(how = How.XPATH, using = "//input[@id='address']")
    private SelenideElement setNumberOrEmail;
    @FindBy(how = How.XPATH, using = "//button[@id='otp_get_code']")
    private SelenideElement getCodeButton;

    public boolean openAuthPage() {
        //вызываем переменную с заголовком
        //дальше пишем условие - переменая должна содержать текст и в скобках пишем необходимый текст
        authPageTittle.shouldHave(Condition.exactText("Авторизация по коду"));
        //если условие указанное выше выполняется, то метод должен вернуть true - правда
        return true;
    }

    public boolean getErrorText() {
        errorText.shouldHave(Condition.exactText("<div class=\"rt-input-container rt-input-container--error email-or-phone otp-form__address\">E-mail или мобильный телефон\n" + "Введите телефон в формате +7ХХХХХХХХХХ или +375XXXXXXXXX, или email в формате example@email.ru</div>"));
        return true;
    }

    public AuthPage getText() {
        errorText.getText();
        return this;
    }

    public AuthPage setNumberOrEmail(String number) {
        setNumberOrEmail.setValue(number);
        return this;
    }

    public AuthPage getCode() {
        getCodeButton.click();
        return this;
    }

    public AuthPage getTextFromTheTitle() {
        authPageTittle.getText();
        return this;
    }
}
