import POM.HelpPage;
import POM.MainPage;
import POM.ResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class QuestionTest {

    private MainPage mainPage;
    private HelpPage helpPage;
    private ResultsPage resultsPage;

    private final String questionText = "Оплата услуг";

    @Before
    public void setUp() {
        mainPage = open("https://voronezh.rt.ru/", MainPage.class);
        mainPage.clickToContinueButton();
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    public void questionTest(){
        mainPage.goToHelp();
        helpPage = open("https://voronezh.rt.ru/help", HelpPage.class);
        helpPage.clickToQuestionBox(questionText);
        resultsPage = open("https://voronezh.rt.ru/help/search?text=" +
                "%D0%BE%D0%BF%D0%BB%D0%B0%D1%82%D0%B0+%D1%83%D1%81%D0%BB%D1%83%D0%B3", ResultsPage.class);

        assertTrue(resultsPage.getTextFromResultsPage());
    }
}