package org.example;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
@Setter
public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String login, String password) throws InterruptedException {
        Utils.waitUntilPageLoads(driver, 30);
        WebElement loginInput = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"identifierId\"]\n"));
        WebElement nextButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button\n"));
        loginInput.clear();
        loginInput.sendKeys(login);
        nextButton.click();
        Thread.sleep(6000);
        WebElement loginPassword = Utils.getElementBySelector(driver, By.xpath("//*[@class=\"whsOnd zHQkBf\"]\n"));
        WebElement next2Button = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button\n"));
        loginPassword.clear();
        loginPassword.sendKeys(password);
        next2Button.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void incorrectlogin(String login, String password) throws InterruptedException {
        Utils.waitUntilPageLoads(driver, 30);
        WebElement loginInput = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"identifierId\"]\n"));
        WebElement nextButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button\n"));
        loginInput.clear();
        loginInput.sendKeys(login);
        nextButton.click();
        Thread.sleep(6000);
        WebElement loginPassword = Utils.getElementBySelector(driver, By.xpath("//*[@class=\"whsOnd zHQkBf\"]\n"));
        WebElement next2Button = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button\n"));
        loginPassword.clear();
        loginPassword.sendKeys(password);
        next2Button.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

