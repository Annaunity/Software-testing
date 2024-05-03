
import org.example.MainPage;
import org.example.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class MainPageTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @TestFactory
    public Stream<DynamicTest> testGoLogin() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Вход" + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var goLogin = mainPage.goLogin();
                        Utils.waitUrlFromPage(goLogin.getDriver());
                        Assertions.assertEquals("https://www.blogger.com/about/?bpli=1", goLogin.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }
}