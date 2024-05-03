import org.example.ListOfArticles;
import org.example.MainPage;
import org.example.Utils;
import org.example.YourBlog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class ListOfArticleTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @TestFactory
    public Stream<DynamicTest> testOpenArticle() {
        return Utils.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Переход к написанию " + driver.getClass(),
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

                        ListOfArticles ListOfArticles = new ListOfArticles(driver);
                        var articles = ListOfArticles.openArticle();
                        Utils.waitUrlFromPage(articles.getDriver());
                        Assertions.assertNotEquals("https://www.blogger.com/u/1/blog/reading/6528969160695298349?hl=ru", articles.getDriver().getCurrentUrl());
                    } finally {
                        driver.quit();
                    }
                }));
    }
}
