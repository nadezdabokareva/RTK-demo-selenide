package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeInternetPage {

    @FindBy(how = How.CLASS_NAME, using = "rt-carousel-v3-arrow")
    private SelenideElement arrowButton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Облачный')]")
    private SelenideElement oblachInternetButton;

    public HomeInternetPage chooseTariff() {
        arrowButton.shouldBe(Condition.visible).click();
        oblachInternetButton.click();
        return this;
    }

}
