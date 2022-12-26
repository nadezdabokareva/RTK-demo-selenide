import POM.CreateOrderPage;
import POM.HomeInternetPage;
import POM.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class CreateInternetOrderTest {

    private final String address = "г Воронеж, ул Минская, д 100000";
    private final String name = "Иванов Иван Иваныч";
    private final String phone = "7900000000";
    private MainPage mainPage;
    private HomeInternetPage homeInternetPage;
    private CreateOrderPage createOrderPage;

    @Before
    public void setUp() {

        mainPage = open("https://voronezh.rt.ru/", MainPage.class);
        mainPage.clickToInternetButton()
                .clickToHomeInternetButton();
        homeInternetPage = open("https://voronezh.rt.ru/homeinternet", HomeInternetPage.class);
        homeInternetPage.chooseTariff();
        createOrderPage = open("https://voronezh.rt.ru/about_offer?offer=418923262504&cardId=3ee2ecc6&lcs=active&pr7=" +
                "POSTPAIDUNLIM&ref=%2Fhomeinternet&tech=" +
                "2&speed=100&tech=2&speed=100&tech=2&speed=100&cardPos=5", CreateOrderPage.class);
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    public void creatingInternetOrderWithoutFieldsTest() {
        createOrderPage.fillOrder(address, name, phone);
        assertTrue(createOrderPage.errorMessagesIsVisible());
    }
}
