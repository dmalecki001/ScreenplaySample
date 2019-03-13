package com.test.sample.selenium.webdriver_factory;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider implements DriverSource {

    @Override
    public WebDriver newDriver() {
        return new WebDriverFactory().getDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
