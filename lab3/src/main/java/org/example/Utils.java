package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Utils {

    public static final String CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String CHROME_SYSTEM_PROPERTY_PATH = "drivers/chromedriver.exe";
    public static final String FIREFOX_SYSTEM_PROPERTY_NAME = "webdriver.gecko.driver";
    public static final String FIREFOX_SYSTEM_PROPERTY_PATH = "drivers/geckodriver.exe";
    public static final String BASE_URL = "https://www.blogger.com";

    public static final String SEARCH = "Здравствуйте!";
    public static final String LABEL = "Приветствие";
    public static final String CORRECT_EMAIL = "softwaretestinglab3@gmail.com";
    public static final String CORRECT_PASSWORD = "pr1vetg00gle";

    public static final String INCORRECT_PASSWORD = "1234";

    public static List<WebDriver> getDrivers() {
        List<WebDriver> drivers = new ArrayList<>();
        try {
            List<String> properties = Files.readAllLines(Paths.get("lab.properties"));
            for (String property : properties) {
                if (property.startsWith("WEB_DRIVER")) {
                    switch (property.toLowerCase().split("=")[1]) {
                        case "chrome":
                            drivers.add(getChromeDriver());
                            return drivers;
                        case "firefox":
                            drivers.add(getFirefoxDriver());
                            return drivers;
                        case "both":
                            drivers.add(getChromeDriver());
                            drivers.add(getFirefoxDriver());
                            return drivers;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Web driver is not specified");
    }

    private static ChromeDriver getChromeDriver() {
        if (!System.getProperties().containsKey(CHROME_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Chrome driver not set properly");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "");
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    }

    private static FirefoxDriver getFirefoxDriver() {
        if (!System.getProperties().containsKey(FIREFOX_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Firefox driver not set properly");
        }
        return new FirefoxDriver();
    }

    public static void prepareDrivers() {
        System.setProperty(CHROME_SYSTEM_PROPERTY_NAME, CHROME_SYSTEM_PROPERTY_PATH);
        System.setProperty(FIREFOX_SYSTEM_PROPERTY_NAME, FIREFOX_SYSTEM_PROPERTY_PATH);
    }

    public static WebElement getElementBySelector(WebDriver driver, By selector) {
        WebDriverWait driverWait = new WebDriverWait(driver, 30);
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void waitUntilPageLoads(WebDriver driver, long timeout) {
        WebDriverWait waitDriver = new WebDriverWait(driver, timeout);
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void waitUrlFromPage(WebDriver driver) {
        while (driver.getCurrentUrl().equals("about:blank")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

