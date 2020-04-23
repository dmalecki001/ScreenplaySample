package com.sample.screenplay.selenium.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class AbstractWebDriverFactory {

    private static final String HEADLESS_MODE = "headlessMode";
    protected final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    abstract WebDriver supplyWebDriver();

    private boolean isHeadless() {
        final String headless = System.getProperty(HEADLESS_MODE);
        return Objects.isNull(headless) ?
                Boolean.valueOf(environmentVariables.getProperty(HEADLESS_MODE)) :
                Boolean.valueOf(headless);
    }

    protected WebDriver createChrome(int timeoutInSeconds) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-notifications");
        options.addArguments("--touch-events=disabled");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setHeadless(isHeadless());
        WebDriver driver = ThreadGuard.protect(new ChromeDriver(options));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        return driver;
    }

    protected WebDriver createFirefox(int timeoutInSeconds) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(isHeadless());
        WebDriver driver = ThreadGuard.protect(new FirefoxDriver(options));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        return driver;
    }

}
