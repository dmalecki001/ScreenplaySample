package com.sample.screenplay.selenium.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebDriverFactory extends AbstractWebDriverFactory {

    private static final int TIMEOUT = 60;
    private Lock lock = new ReentrantLock();

    @Override
    public WebDriver supplyWebDriver() {
        lock.lock();
        Optional<String> browserFromMaven = Optional.ofNullable(System.getProperty("browser"));
        String browser = browserFromMaven.map(String::toString)
                .orElse(environmentVariables.getProperty("browser"));
        try {
            switch (browser) {
                case "chrome":
                    return createChrome(TIMEOUT);
                case "firefox":
                    return createFirefox(TIMEOUT);
                default:
                    throw new UnsupportedOperationException(" WebDriver not recognised or implemented");
            }
        } finally {
            lock.unlock();
        }
    }

}
