package POM;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsPage {
    @FindBy(how = How.CLASS_NAME, using = "rt-font-h3")
    private SelenideElement results;

    public boolean getTextFromResultsPage() {
        $(byText("Результаты поиска")).getText();
        return true;
    }
}
