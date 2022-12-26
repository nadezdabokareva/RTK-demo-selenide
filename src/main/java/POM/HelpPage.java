package POM;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HelpPage {

    @FindBy(how = How.CLASS_NAME, using = "rtk-help-search-content-input-field")
    private SelenideElement questionBox;

    @FindBy(how = How.XPATH, using = "//input[contains(text(),'Помощь')]")
    private SelenideElement helpButton;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Найдено 26 результатов')]")
    private SelenideElement searchingResultsPageTitle;

    @FindBy(how = How.CLASS_NAME, using = "rt-button")
    private SelenideElement findButton;

    public HelpPage clickToQuestionBox(String questionText) {
        questionBox.click();
        questionBox.setValue(questionText);
        findButton.click();
        return this;
    }

}