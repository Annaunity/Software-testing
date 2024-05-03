import org.example.MainPage;
import org.example.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class LoginPageTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @TestFactory
    public Stream<DynamicTest> testLogin() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Вход по почте " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);
                        Assertions.assertNotEquals("https://www.blogger.com/u/3/blog/posts/4104795739286863268", inputLog.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testIncorrectLogin() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Вход неверный " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.incorrectlogin(Utils.CORRECT_EMAIL, Utils.INCORRECT_PASSWORD);
                        Assertions.assertNotEquals("https://www.blogger.com/u/3/blog/posts/4104795739286863268", inputLog.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

}