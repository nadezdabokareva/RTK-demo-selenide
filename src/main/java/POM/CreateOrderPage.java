package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateOrderPage {

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Облачный')]")
    private SelenideElement tariffTitle;

    @FindBy(how = How.NAME, using = "address")
    private SelenideElement addressBox;

    @FindBy(how = How.NAME, using = "fullName")
    private SelenideElement nameBox;

    @FindBy(how = How.NAME, using = "phoneNumber")
    private SelenideElement numberBox;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Выберите дом из справочника')]")
    private SelenideElement errorAddress;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Введите существующий номер телефона')]")
    private SelenideElement errorPhone;

    public boolean textFromTitleOrder() {
       tariffTitle.shouldHave(Condition.text("Облачный"));
        return true;
    }

    public CreateOrderPage fillOrder(String address, String name, String phoneNumber) {
        addressBox.setValue(address);
        nameBox.setValue(name);
        numberBox.setValue(phoneNumber);
        return this;
    }

    public boolean errorMessagesIsVisible() {
        errorAddress.shouldBe(Condition.visible);
        errorPhone.shouldBe(Condition.visible);
        return true;
    }

}
