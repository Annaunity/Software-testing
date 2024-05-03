package org.example;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListOfArticles extends Page {

    public ListOfArticles(WebDriver driver) {
        super(driver);
    }

    public ListOfArticles openArticle() {
        var article = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz[2]/div[2]/div/c-wiz/div/div[3]/div[1]/span/a\n"));
        article.click();
//        var yes = Utils.getElementBySelector(driver, By.xpath("/html/body/div[2]/a[1]\n"));
//        yes.click();
        return new ListOfArticles(this.driver);
    }
}
