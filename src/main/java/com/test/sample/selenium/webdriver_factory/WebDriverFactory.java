package com.test.sample.selenium.webdriver_factory;

import com.test.sample.utils.TestDataManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class WebDriverFactory {

    private Lock lock = new ReentrantLock();
    private int timeout = 60;

    WebDriver getDriver() {
        lock.lock();
        String browser = System.getProperty("browser") != null ?
                System.getProperty("browser").toLowerCase() :
                TestDataManager.getReader().readSpecificProperty("browser").toLowerCase();
        try {
            switch (browser) {
                case "chrome":
                    return getChrome(timeout);
                case "firefox":
                    return getFirefox(timeout);
                default:
                    return getChrome(timeout);
            }
        } finally {
            lock.unlock();
        }

    }

    private WebDriver getChrome(int timeoutInSeconds) {
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

    private WebDriver getFirefox(int timeoutInSeconds) {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = ThreadGuard.protect(new FirefoxDriver(options));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        return driver;
    }

}
