package com.test.sample.selenium.webdriver_factory;

import com.test.sample.utils.TestDataManager;
import org.openqa.selenium.WebDriver;

import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebDriverFactory extends AbstractWebDriverFactory {

    private Lock lock = new ReentrantLock();
    private int timeout = 60;

    @Override
    public WebDriver getWebdriver() {
        lock.lock();
        Optional<String> browserFromMaven = Optional.ofNullable(System.getProperty("browser"));
        String browser = browserFromMaven.map(String::toString)
                .orElse(TestDataManager.getReader().readSpecificProperty("browser"));
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


}
