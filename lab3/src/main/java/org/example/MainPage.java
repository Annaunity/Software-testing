package org.example;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.Utils;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goLogin() {
        var buttonLogin = Utils.getElementBySelector(driver, By.xpath("/html/body/header/div[1]/div[2]/a[1]\n\n"));
        buttonLogin.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new LoginPage(this.driver);
    }

}
