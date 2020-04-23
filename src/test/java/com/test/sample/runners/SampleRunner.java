package com.test.sample.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.test.sample.stepDefinitions"},
        features = {"src/test/resources/features"},
        tags = {"@AAA"}
)
public class SampleRunner {
}
