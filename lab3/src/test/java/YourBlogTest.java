import org.example.MainPage;
import org.example.Utils;
import org.example.YourBlog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class YourBlogTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }


    @TestFactory
    public Stream<DynamicTest> testOpenMessage() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к сообщениям " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var message = YourBlog.openMessage();
                        Utils.waitUrlFromPage(message.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/u/1/blog/posts/6528969160695298349", message.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenStatistic() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к статистике " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var stat = YourBlog.openStatistic();
                        Utils.waitUrlFromPage(stat.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/u/1/blog/posts/6528969160695298349", stat.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenComments() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к комментариям " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var comments = YourBlog.openComments();
                        Utils.waitUrlFromPage(comments.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/u/1/blog/posts/6528969160695298349", comments.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenIncome() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к прибыли " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);


                        YourBlog YourBlog = new YourBlog(driver);
                        var income = YourBlog.openIncome();
                        Utils.waitUrlFromPage(income.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/u/1/blog/posts/6528969160695298349", income.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenDesign() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к дизайну " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var design = YourBlog.openDesign();
                        Utils.waitUrlFromPage(design.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/u/1/blog/posts/6528969160695298349", design.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenSettings() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к настройкам " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var settings = YourBlog.openSettings();
                        Utils.waitUrlFromPage(settings.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/u/1/blog/posts/6528969160695298349", settings.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenReadList() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к списку чтения " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var list = YourBlog.openReadList();
                        Utils.waitUrlFromPage(list.getDriver());
                        Assertions.assertEquals("https://www.blogger.com/blog/reading/4104795739286863268", list.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testSearch() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Поиск " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var list = YourBlog.openSearch();
                        list.search(Utils.SEARCH);
                        Utils.waitUrlFromPage(list.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/blog/reading/4104795739286863268", list.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenHelp() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к помощи " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var list = YourBlog.openHelp();
                        Utils.waitUrlFromPage(list.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/blog/reading/4104795739286863268", list.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    @TestFactory
    public Stream<DynamicTest> testOpenLabel() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к написанию лейбла" + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Utils.BASE_URL);
                        var inputLog = mainPage.goLogin();
                        inputLog.login(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);

                        YourBlog YourBlog = new YourBlog(driver);
                        var write = YourBlog.openLabel();
                        write.writeLabel(Utils.LABEL);
                        Utils.waitUrlFromPage(write.getDriver());
                        var apply = YourBlog.applyLabel();
                        Utils.waitUrlFromPage(apply.getDriver());
                        Assertions.assertEquals("https://www.blogger.com/blog/posts/4104795739286863268", write.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }

}

