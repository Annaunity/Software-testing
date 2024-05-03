import lombok.SneakyThrows;
import org.example.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void testDriver() {
        Utils.getDrivers().forEach(this::executeWithCapabilities);
    }

    @SneakyThrows
    private void executeWithCapabilities(WebDriver driver) {
        driver.get(Utils.BASE_URL);
        Thread.sleep(2000);
        String title = driver.getTitle();
        assertEquals("Blogger.com – Чтобы создать свой собственный блог, потребуется лишь несколько минут.", title);
        driver.quit();
    }
}
