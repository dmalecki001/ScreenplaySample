package com.test.sample.selenium.webdriver_factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.util.concurrent.TimeUnit;

public abstract class AbstractWebDriverFactory {

    abstract WebDriver getWebdriver();

    protected WebDriver getChrome(int timeoutInSeconds) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-notifications");
        options.addArguments("--touch-events=disabled");
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver = ThreadGuard.protect(new ChromeDriver(options));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        return driver;
    }

    protected WebDriver getFirefox(int timeoutInSeconds) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = ThreadGuard.protect(new FirefoxDriver(options));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        return driver;
    }

}
