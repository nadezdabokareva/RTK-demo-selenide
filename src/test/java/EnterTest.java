import POM.AuthPage;
import POM.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.Assert.assertTrue;

public class EnterTest {

    private MainPage mainPage;
    private AuthPage authPage;

    private final String number = "12121212";

    @Before
    public void setUp() {
        mainPage = open("https://voronezh.rt.ru/", MainPage.class);
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    public void openAuthorizationTest() {
        mainPage.goToTheEnterAccountButton();
        authPage = open("https://b2c.passport.rt.ru/auth/realms/b2c/protocol/openid-connect/auth?client_id=" +
                "lk_decosystems&redirect_uri=" +
                "https://voronezh.rt.ru/&response_type=code&scope=openid&_gl=" +
                "1*b7k0si*_ga*MTgwNDQ5NzAwLjE2Njk2NDI5MDU." +
                "*_ga_9G5GWSHJG0*MTY2OTY0MjkwNS4xLjAuMTY2OTY0MjkwNy41OC4wLjA.", AuthPage.class);
        assertTrue(authPage.openAuthPage());
    }

    @Test
    public void unCorrectAuthorizationTest() {
        mainPage.goToTheEnterAccountButton();
        authPage = open("https://b2c.passport.rt.ru/auth/realms/b2c/protocol/openid-connect/auth?client_id=" +
                "lk_decosystems&redirect_uri=" +
                "https://voronezh.rt.ru/&response_type=code&scope=openid&_gl=" +
                "1*b7k0si*_ga*MTgwNDQ5NzAwLjE2Njk2NDI5MDU." +
                "*_ga_9G5GWSHJG0*MTY2OTY0MjkwNS4xLjAuMTY2OTY0MjkwNy41OC4wLjA.", AuthPage.class);
        authPage.setNumberOrEmail(number)
                        .getCode();
        assertTrue(authPage.getErrorText());
    }
}
