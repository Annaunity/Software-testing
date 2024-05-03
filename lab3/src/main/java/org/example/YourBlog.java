package org.example;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class YourBlog extends Page{

    public YourBlog(WebDriver driver) {
        super(driver);
    }

    public YourBlog openMessage() {
        var message = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[5]/span[1]/div[2]/a\n"));
        message.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }

    public YourBlog openStatistic() {
        var stat = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[5]/span[2]/div[2]/a\n"));
        stat.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }
    public YourBlog openComments() {
        var comments = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[5]/span[3]/div[2]/a\n"));
        comments.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }
    public YourBlog openIncome() {
        var income = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[5]/span[4]/div[2]/a\n"));
        income.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }
    public YourBlog openDesign() {
        var design = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[5]/span[7]/div[2]/a\n"));
        design.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }
    public YourBlog openSettings() {
        var settings = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[5]/span[8]/div[2]/a\n"));
        settings.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }

    public YourBlog openReadList() throws InterruptedException {
        var list = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[6]/span/div[2]/a\n"));
        Thread.sleep(2000);
        list.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }


    public YourBlog openSearch() {
        var searchButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/div[2]/header/div[2]/div[2]/div[2]/form/button[4]\n"));
        searchButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }

    public void search(String search) {
        WebElement searchInput = Utils.getElementBySelector(driver, By.xpath("//*[@class=\"Ax4B8 ZAGvjd\"]\n"));
        searchInput.clear();
        searchInput.sendKeys(search);
    }
    public YourBlog openHelp() {
        var helpButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/div[2]/header/div[2]/div[2]/div[3]/div/div/div\n"));
        helpButton.click();
//        var feedButton = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"google-feedback\"]\n"));
//        feedButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }
    public YourBlog openLabel() {
        WebElement labelButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz/div[2]/div/c-wiz/div[1]/div[1]/div[2]/div[1]\n"));
        labelButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }

    public void writeLabel(String label) {
        WebElement lableInput = Utils.getElementBySelector(driver, By.xpath("//*[@class=\"KHxj8b tL9Q4c\"]\n"));
        lableInput.clear();
        lableInput.sendKeys(label);
    }
    public YourBlog applyLabel() {
        WebElement applyButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/div[4]/div/div[2]/div[2]/div[2]\n"));
        applyButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }

    public YourBlog openWrite() {
        WebElement writeButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[7]/c-wiz[2]/div[1]/gm-raised-drawer/div/div[2]/div/c-wiz/div[3]/div/div\n"));
        writeButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return new YourBlog(this.driver);
    }
}
